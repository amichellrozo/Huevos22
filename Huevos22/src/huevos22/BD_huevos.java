package huevos22;

import static huevos22.BD_huevos.getConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class BD_huevos {

    static Connection contacto = null;
    int Activo = 0;

    //CONEXION BASE DE DATOS----------------------------------------------------------------------
    public static Connection getConexion() {
        String url = "jdbc:sqlserver://bdhuevos.mssql.somee.com;databaseName=bdhuevos";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException e) {

            System.out.println("error driver.");
        }
        try {
            contacto = DriverManager.getConnection(url, "JohanFZ_SQLLogin_1", "4so2rpfdrs");
        } catch (SQLException e) {
            System.out.println("error conexion.");
        }
        return contacto;
    }

    public void desconectar() {
        try {
            contacto.close();
            System.out.println("desconcetado");
        } catch (SQLException ex) {
            System.out.println("Error en el cierre" + ex.getMessage());
        }
    }

    public static ResultSet Consulta(String Consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(Consulta);
            return respuesta;
        } catch (SQLException e) {
            System.out.println("error conexion.");
        }
        return null;
    }

    public int Val_Usu_log(String Usu, String Pas) {
        int estado = 0;
        ResultSet result;
        String PasRes;

        try {
            PreparedStatement st = contacto.prepareStatement("select * from Usuario where username =?");
            st.setString(1, Usu);
            result = st.executeQuery();
            while (result.next()) {
                PasRes = result.getString("contraseña");
                if (PasRes.equals(Pas) && !result.getString("username").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }
    //TABLA USUARIOS

    public int Agre_Usu(String primernombre_usuario, String segundonombre_usuario, String primerapellido_usuario,
            String segundoapellido_usuario, String corrreo_cliente, String username, String contraseña) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Usuario (primernombre_usuario,segundonombre_usuario,primerapellido_usuario,segundoapellido_usuario,corrreo_cliente,username,contraseña) values (?,?,?,?,?,?,?)");
            st.setString(1, primernombre_usuario);
            st.setString(2, segundonombre_usuario);
            st.setString(3, primerapellido_usuario);
            st.setString(4, segundoapellido_usuario);
            st.setString(5, corrreo_cliente);
            st.setString(6, username);
            st.setString(7, contraseña);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public int Val_Usu_CO(String Usua) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Usuario where username=?");
            st.setString(1, Usua);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("username").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    // metodo de validadr q no sean el mismo correo
    public int Val_Usu_Correo(String corr) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Usuario where corrreo_cliente=?");
            st.setString(1, corr);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("corrreo_cliente").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    //VISTA PROVEEDOR
    public int Val_Pro_Correo(String corr) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Proveedor where corrreo_proveedor=?");
            st.setString(1, corr);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("corrreo_proveedor").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    public int Agre_Pro(String primernombre_proveedor, String segundonombre_proveedor, String primerapellido_proveedor,
            String segundoapellido_proveedor, String direccion_proveedor, String telefono_proveedor, String corrreo_proveedor) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Proveedor (primernombre_proveedor,segundonombre_proveedor,primerapellido_proveedor,segundoapellido_proveedor,corrreo_proveedor,telefono_proveedor,direccion_proveedor) values (?,?,?,?,?,?,?)");
            st.setString(1, primernombre_proveedor);
            st.setString(2, segundonombre_proveedor);
            st.setString(3, primerapellido_proveedor);
            st.setString(4, segundoapellido_proveedor);
            st.setString(5, direccion_proveedor);
            st.setString(6, telefono_proveedor);
            st.setString(7, corrreo_proveedor);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public DefaultTableModel Lista_prov() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 9) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        ResultSet result;
        try {

            PreparedStatement st = contacto.prepareStatement("select * from Proveedor ");

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "ID", "P Nombre", "S Nombre", "P Apellido", "S Apellido", "Dirección", "Telefono", "Correo"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
//                modelo.addRow(new Object[]{fila[0],new JLabel(this.view_img(3)),fila[2],fila[3]});
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }
//////

    public DefaultTableModel Buscar_Pro(String Dato, int opcion) {
        System.out.print(Dato);
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 9) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        String campoDB = "";
        ResultSet result;
        try {
            if (opcion == 1) {

                campoDB = "select * from Proveedor where primernombre_proveedor=" + "'" + Dato + "'";
            }

            if (opcion == 2) {
                campoDB = "SELECT * from Proveedor where telefono_proveedor=" + "'" + Dato + "'";
            }
            PreparedStatement st = contacto.prepareStatement(campoDB);

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "ID", "P Nombre", "S Nombre", "P Apellido", "S Apellido", "Dirección", "Telefono", "Correo"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
//                modelo.addRow(new Object[]{fila[0],new JLabel(this.view_img(3)),fila[2],fila[3]});
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }

    /////
    public String[] ModifiPro(int dato, int combo) {
        String resultado[] = new String[11], campoDB = "";
        ResultSet result;
        try {

            if (Activo == 0) {
                campoDB = "select * from Proveedor where id_proveedor";
            }
            PreparedStatement st
                    = contacto.prepareStatement(campoDB + "=?");
            st.setInt(1, dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("primernombre_proveedor");
                resultado[1] = result.getString("segundonombre_proveedor");
                resultado[2] = result.getString("primerapellido_proveedor");
                resultado[3] = result.getString("segundoapellido_proveedor");
                resultado[4] = result.getString("direccion_proveedor");
                resultado[5] = result.getString("telefono_proveedor");
                resultado[6] = result.getString("corrreo_proveedor");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int Borrarproveedor(int id_proveedor) {
        int estado;
        try {
            PreparedStatement st = contacto.prepareStatement("delete from Proveedor where id_proveedor = ?");

            st.setInt(1, id_proveedor);
            st.executeUpdate();

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public int Act_Pro(int id_proveedor, String primernombre_proveedor, String segundonombre_proveedor, String primerapellido_proveedor, String segundoapellido_proveedor, String direccion_proveedor, String telefono_proveedor, String corrreo_proveedor) {
        int estado2;
        try {
            PreparedStatement st = contacto.prepareStatement("update Proveedor set primernombre_proveedor=?, segundonombre_proveedor=?,primerapellido_proveedor=?,segundoapellido_proveedor=?,direccion_proveedor=?,telefono_proveedor=?, corrreo_proveedor=? where id_proveedor=?");
            st.setString(1, primernombre_proveedor);
            st.setString(2, segundonombre_proveedor);
            st.setString(3, primerapellido_proveedor);
            st.setString(4, segundoapellido_proveedor);
            st.setString(5, direccion_proveedor);
            st.setString(6, telefono_proveedor);
            st.setString(7, corrreo_proveedor);
            st.setInt(8, id_proveedor);
            st.execute();
            estado2 = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado2 = 0;
        }
        return estado2;
    }

    /// COmbos PROVEEDORES
    public DefaultComboBoxModel Combo_nombreProveedor() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select concat(primernombre_proveedor, ' ' ,primerapellido_proveedor) as Nombre from Proveedor");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("Nombre"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }

    public DefaultComboBoxModel Combo_telefonoProveedor() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select * from Proveedor");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("telefono_proveedor"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }

    //  VISTA CLIENTES
    public DefaultTableModel Lista_clie() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 9) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        ResultSet result;
        try {

            PreparedStatement st = contacto.prepareStatement("select * from Cliente ");

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "ID Cliente", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Dirección", "Telefono", "Correo"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }

                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }

    public int Val_clie_Correo(String corr) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Cliente where corrreo_cliente=?");
            st.setString(1, corr);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("corrreo_cliente").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    public int Agre_clientes(String primernombre_clientes, String segundonombre_clientes, String primerapellido_cliente,
            String segundoapellido_cliente, String direccion_cliente, String telefono_cliente, String correo_cliente) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Cliente (primernombre_cliente,segundonombre_cliente,primerapellido_cliente,segundoapellido_cliente,direccion_cliente,telefono_cliente, corrreo_cliente) values (?,?,?,?,?,?,?)");
            st.setString(1, primernombre_clientes);
            st.setString(2, segundonombre_clientes);
            st.setString(3, primerapellido_cliente);
            st.setString(4, segundoapellido_cliente);
            st.setString(5, direccion_cliente);
            st.setString(6, telefono_cliente);
            st.setString(7, correo_cliente);

            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public int Actualizarcliente(int id_cliente, String primernombre_clientes, String segundonombre_clientes, String primerapellido_cliente,
            String segundoapellido_cliente, String direccion_cliente, String telefono_cliente, String correo_cliente) {
        int estado;

        try {
            PreparedStatement st = contacto.prepareStatement("update Cliente set primernombre_cliente=?,segundonombre_cliente=?,primerapellido_cliente=?,segundoapellido_cliente=?,direccion_cliente=?,telefono_cliente=?,corrreo_cliente=? where id_cliente=?");
            st.setString(1, primernombre_clientes);
            st.setString(2, segundonombre_clientes);
            st.setString(3, primerapellido_cliente);
            st.setString(4, segundoapellido_cliente);
            st.setString(5, direccion_cliente);
            st.setString(6, telefono_cliente);
            st.setString(7, correo_cliente);
            st.setInt(8, id_cliente);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }
/////////BORRAR cliente

    public int Borrarcliente(int id_cliente) {
        int estado;
        try {
            PreparedStatement st = contacto.prepareStatement("delete from Cliente where id_cliente = ?");

            st.setInt(1, id_cliente);
            st.executeUpdate();

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public DefaultComboBoxModel Combo_nombrecliente() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select CONCAT(primernombre_cliente, ' ', primerapellido_cliente) as Nombre from Cliente");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("Nombre"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }

    public DefaultComboBoxModel Combo_telefonocliente() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select * from Cliente");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("telefono_cliente"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }

    public DefaultTableModel Buscar_cliente(String Dato, int opcion) {
        System.out.print(Dato);
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 9) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        String campoDB = "";
        ResultSet result;
        try {
            if (opcion == 1) {

                campoDB = "select * from Cliente where primernombre_cliente=" + "'" + Dato + "'";
            }

            if (opcion == 2) {
                campoDB = "SELECT * from Cliente where telefono_cliente=" + "'" + Dato + "'";
            }
            PreparedStatement st = contacto.prepareStatement(campoDB);

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "ID", "P Nombre", "S Nombre", "P Apellido", "S Apellido", "Dirección", "Telefono", "Correo"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
//              
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }

    //VENTAS
    public DefaultTableModel 
        Lista_ven() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 7) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        ResultSet result;
        try {

            PreparedStatement st = contacto.prepareStatement("select V.id_venta,\n"
                    + "P.nombre_producto,\n"
                    + "V.cantidad_venta as 'Cantidad por unidad',\n"
                    + "(V.cantidad_venta/30) as 'Cantidad Cubetas',\n"
                    + "V.total_venta,\n"
                    + "V.fecha_venta,\n"
                    + "CONCAT(C.primernombre_cliente,' ',C.primerapellido_cliente) as 'Proveedor'\n"
                    + "from Venta V , Producto P, Cliente C\n"
                    + "where P.id_producto=V.id_producto AND\n"
                    + "C.id_cliente=V.id_cliente");

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "N°", "Producto", "Unidad", "Cubeta", "Venta Total", "Fecha Venta", "Cliente"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
//                modelo.addRow(new Object[]{fila[0],new JLabel(this.view_img(3)),fila[2],fila[3]});
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }
        
          public int BorrarVenta(int id_compra) {
        int estado;
        try {
            PreparedStatement st = contacto.prepareStatement("delete from Venta where id_venta = ?");

            st.setInt(1, id_compra);
            st.executeUpdate();

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }
           public String idcliente(String idpro) {
        ResultSet result;
        String precio1 = null;
        try {

            PreparedStatement st = contacto.prepareStatement("select p.id_cliente\n"
                    + "from Cliente p\n"
                    + "where concat(p.primernombre_cliente, ' ', primerapellido_cliente)= ?");
            System.out.println("saleid");
            st.setString(1, idpro);

            st.execute();
            result = st.executeQuery();
            while (result.next()) {
                precio1 = result.getString("id_cliente");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return precio1;

    }
            public int Agre_ventita(int id_producto, int cantidad_venta, int total_venta,
            int id_cliente) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Venta (id_producto,cantidad_venta,total_venta,id_cliente) values (?,?,?,?)");
            st.setInt(1, id_producto);
            st.setInt(2, cantidad_venta);
            st.setInt(3, total_venta);
            st.setInt(4, id_cliente);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }
 public DefaultComboBoxModel combo_pro() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select P.nombre_producto\n"
                + "from Venta V,Producto P\n"
                + "where V.id_producto= P.id_producto\n"
                + "group by P.nombre_producto");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("nombre_producto"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }

    public DefaultComboBoxModel combo_clientes() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select  C.primernombre_cliente\n"
                + "from Venta V,Cliente C\n"
                + "where V.id_cliente=C.id_cliente\n"
                + "Group by C.primernombre_cliente");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("primernombre_cliente"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }

    public DefaultComboBoxModel combo_fecha() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select V.fecha_venta\n"
                + "from Venta V\n"
                + "Group by V.fecha_venta ");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("fecha_venta"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }

    public DefaultTableModel Buscar_venta(String Dato, int opcion) {
        System.out.print(Dato);
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 9) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        String campoDB = "";
        ResultSet result;
        try {
            if (opcion == 1) {

                campoDB = "select V.id_venta,\n"
                        + "                    P.nombre_producto,\n"
                        + "                    V.cantidad_venta as 'Cantidad por unidad',\n"
                        + "                    (V.cantidad_venta/30) as 'Cantidad Cubetas',\n"
                        + "                    V.total_venta,\n"
                        + "                    V.fecha_venta,\n"
                        + "                    CONCAT(C.primernombre_cliente,' ',C.primerapellido_cliente) as 'Proveedor'\n"
                        + "                   from Venta V , Producto P, Cliente C\n"
                        + "                    where P.id_producto=V.id_producto AND\n"
                        + "                    C.id_cliente=V.id_cliente and P.nombre_producto=" + "'" + Dato + "'";
            }

            if (opcion == 2) {
                campoDB = "select V.id_venta,\n"
                        + "                    P.nombre_producto,\n"
                        + "                    V.cantidad_venta as 'Cantidad por unidad',\n"
                        + "                    (V.cantidad_venta/30) as 'Cantidad Cubetas',\n"
                        + "                    V.total_venta,\n"
                        + "                    V.fecha_venta,\n"
                        + "                    CONCAT(C.primernombre_cliente,' ',C.primerapellido_cliente) as 'Proveedor'\n"
                        + "                   from Venta V , Producto P, Cliente C\n"
                        + "                    where P.id_producto=V.id_producto AND\n"
                        + "                    C.id_cliente=V.id_cliente and C.primernombre_cliente=" + "'" + Dato + "'";
            }
            if (opcion == 3) {
                campoDB = "select V.id_venta,\n"
                        + "                    P.nombre_producto,\n"
                        + "                    V.cantidad_venta as 'Cantidad por unidad',\n"
                        + "                    (V.cantidad_venta/30) as 'Cantidad Cubetas',\n"
                        + "                    V.total_venta,\n"
                        + "                    V.fecha_venta,\n"
                        + "                    CONCAT(C.primernombre_cliente,' ',C.primerapellido_cliente) as 'Proveedor'\n"
                        + "                   from Venta V , Producto P, Cliente C\n"
                        + "                    where P.id_producto=V.id_producto AND\n"
                        + "                    C.id_cliente=V.id_cliente and V.fecha_venta= " + "'" + Dato + "'";
            }
            PreparedStatement st = contacto.prepareStatement(campoDB);

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "ID", "P Nombre", "S Nombre", "P Apellido", "S Apellido", "Dirección", "Telefono", "Correo"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
//              
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }
    //INVENTARIO-------------------------------------------------------------------------------
    public DefaultTableModel Lista_Inv() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        ResultSet result;
        try {

            PreparedStatement st = contacto.prepareStatement("SELECT id_existencia,P.nombre_producto,cantidad_producto as \"Cantidad Unidad\",(cantidad_producto/30) as \"Cantidad Cubeta\" from Existencia EX,Producto P where EX.id_producto=P.id_producto ");

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "Id Existencia", "Nombre Producto", "Cantidad (Unidad)", "Cantidad (Cubeta)"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }
      

    //COMPRAS----------------------------------------------------------------------------------------------------------------------
    public DefaultTableModel Lista_compras() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        ResultSet result;
        try {

            PreparedStatement st = contacto.prepareStatement("select C.id_compra,\n"
                    + "P.nombre_producto,\n"
                    + "C.cantidad_comrpa 'Cantidad por unidad',\n"
                    + "(C.cantidad_comrpa/30) as 'Cantidad Cubetas',\n"
                    + "C.total_compra,\n"
                    + "C.fecha_compra,\n"
                    + "CONCAT(PV.primernombre_proveedor,' ',PV.primerapellido_proveedor) as 'Proveedor'\n"
                    + "from  Producto P, Compra C, Proveedor PV\n"
                    + "where P.id_producto=C.id_producto AND\n"
                    + "C.id_proveedor=PV.id_proveedor\n"
                    + "");

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "N°", "Producto", "Unidad", "Cubeta", "Compra Total", "Fecha Compra", "Proveedor"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }

                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }
    
    public int Agre_Com(int id_producto, int cantidad_comrpa, int total_compra,
            int id_proveedor) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Compra (id_producto,cantidad_comrpa,total_compra,id_proveedor) values (?,?,?,?)");
            st.setInt(1, id_producto);
            st.setInt(2, cantidad_comrpa);
            st.setInt(3, total_compra);
            st.setInt(4, id_proveedor);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }
    
        public DefaultComboBoxModel Combo_Productos() {
        DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
        listaModelo.addElement("Seleccione");
        ResultSet res = this.Consulta("select * from Producto");
        try {
            while (res.next()) {
                listaModelo.addElement(res.getString("nombre_producto"));
            }
            res.close();
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return listaModelo;
    }
    public String idproductos(String idpro) {
        ResultSet result;
        String precio1 = null;
        try {

            PreparedStatement st = contacto.prepareStatement("select p.id_producto\n"
                    + "from Producto p\n"
                    + "where p.nombre_producto= ?");
            System.out.println("saleid");
            st.setString(1, idpro);

            st.execute();
            result = st.executeQuery();
            while (result.next()) {
                precio1 = result.getString("id_producto");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return precio1;

    }
    
     public String idproveedor(String idpro) {
        ResultSet result;
        String precio1 = null;
        try {

            PreparedStatement st = contacto.prepareStatement("select p.id_proveedor\n"
                    + "from Proveedor p\n"
                    + "where concat(p.primernombre_proveedor, ' ', primerapellido_proveedor)= ?");
            System.out.println("saleid");
            st.setString(1, idpro);

            st.execute();
            result = st.executeQuery();
            while (result.next()) {
                precio1 = result.getString("id_proveedor");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return precio1;

    }
     
         
     
         public int BorrarCompra(int id_compra) {
        int estado;
        try {
            PreparedStatement st = contacto.prepareStatement("delete from Compra where id_compra = ?");

            st.setInt(1, id_compra);
            st.executeUpdate();

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }
                
           public String cantidad(String cantidad) {
        ResultSet result;
        String precio1 = null;
        try {
            PreparedStatement st = contacto.prepareStatement("select Ex.cantidad_producto  from Existencia Ex\n"
                    + "where Ex.id_producto=?");
 
            st.setString(1, cantidad);

            st.execute();
            result = st.executeQuery();
                       System.out.println("salecantidad");
            while (result.next()) {
                precio1 = result.getString("cantidad_producto");
                System.out.println("cantidad"+precio1);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return precio1;

    }  
          
}
