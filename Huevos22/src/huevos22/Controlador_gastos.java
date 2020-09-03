/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevos22;

import static huevos22.Controlador_Registro.contacto1;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author michi
 */
public class Controlador_gastos implements ActionListener {

    Vista_gastos vis1;
    BD_huevos mom;

    Controlador_gastos(Vista_gastos v1, BD_huevos m) {
        mom = m;
        vis1 = v1;

        vis1.BCrear.addActionListener(this);
        vis1.CerrarB.addActionListener(this);
        vis1.MinimizarB.addActionListener(this);
        vis1.volver.addActionListener(this);
        vis1.Mostrar.addActionListener(this);
        vis1.Cproductos.addActionListener(this);
        vis1.BEliminar.addActionListener(this);
        vis1.CrearP.addActionListener(this);
        vis1.Opciones.addActionListener(this);
        vis1.BuscarP.addActionListener(this);
        vis1.ListaB.addActionListener(this);
        vis1.ActualizarB.addActionListener(this);
        vis1.ActualizarP.addActionListener(this);
        vis1.Bginforme.addActionListener(this);
        vis1.Binforme.addActionListener(this);
        vis1.Cnproducto.addActionListener(this);
    
        vis1.Cnproducto.setModel(mom.combo_gASTOS());
        // vis1.Cproveedor.setModel(mom.combo_prove());
        //vis1.Cfecha.setModel(mom.combo_fechac());
        vis1.Cproductos.setModel(mom.combo_tipogasto());
        vis1.cfecha.setModel(mom.combo_FEHCA());
        vis1.cfecha1.setModel(mom.combo_FEHCA());
    }

    public void limpiarcampos() {
        vis1.Tprecio.setText("");
        vis1.Tcantidad.setText("");
        vis1.Cproductos.removeAllItems();
        vis1.Cnproducto.removeAllItems();
        vis1.Cproveedor.removeAllItems();
        vis1.Cfecha.removeAllItems();
    }

    public int SumaBalance() {
        int contar = vis1.tablac.getRowCount();
        int duma = 0;
        for (int i = 0; i < contar; i++) {
            duma = duma + Integer.parseInt(vis1.tablac.getValueAt(i, 3).toString());
        }
        return duma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis1.ActualizarP) {
            contacto1 = huevos22.BD_huevos.getConexion();
            int i = mom.Actualizargasto(Integer.parseInt(vis1.TId_proveeedor.getText()),
                    vis1.Cproductos.getSelectedItem().toString(), vis1.Tcantidad.getText(), Integer.parseInt(vis1.Tprecio.getText()));

            if (i == 1) {
                System.out.println(i);
                JOptionPane.showMessageDialog(null, "Gasto Actualizado");
                DefaultTableModel model = new DefaultTableModel();
                model = mom.Lista_gastos();
                vis1.tablac.setModel(model);
                TableColumnModel columnModel = vis1.tablac.getColumnModel();
                vis1.Cproductos.setSelectedIndex(0);
                vis1.Tcantidad.setText("");
                vis1.Tprecio.setText("");
                mom.desconectar();
            } else {
                JOptionPane.showMessageDialog(null, "Gasto No Actulizado");
            }
        }

        if (e.getSource() == vis1.ActualizarB) {
            vis1.Lpeso.setVisible(true);
            vis1.Lunid.setVisible(true);
            vis1.Lprecio.setVisible(true);
            vis1.LProduto.setVisible(true);
            vis1.LCantidad.setVisible(true);
            vis1.Tcantidad.setVisible(true);
            vis1.Tprecio.setVisible(true);
            vis1.Cproductos.setVisible(true);
            vis1.JS1.setVisible(true);
            vis1.JS2.setVisible(true);
            vis1.ActualizarP.setVisible(true);
            vis1.CrearP.setVisible(false);
            vis1.Logo.setVisible(false);
            vis1.Opciones.setVisible(false);
            vis1.Cfecha.setVisible(false);
            vis1.Cnproducto.setVisible(false);
            vis1.BuscarP.setVisible(false);
            vis1.Opciones1.setVisible(false);
            vis1.cfecha.setVisible(false);
            vis1.cfecha1.setVisible(false);
            vis1.Bginforme.setVisible(false);
                vis1.ingresos.setVisible(false);
            vis1.pesos.setVisible(false);
            vis1.total.setVisible(false);

            int k = vis1.tablac.getSelectedRow();
            int c = vis1.tablac.getSelectedRowCount();
            if (k >= 0 && c == 1) {
                vis1.TId_proveeedor.setText(String.valueOf(vis1.tablac.getValueAt(k, 0)));
                vis1.Cproductos.setSelectedItem(String.valueOf(vis1.tablac.getValueAt(k, 1)));
                vis1.Tcantidad.setText(String.valueOf(vis1.tablac.getValueAt(k, 2)));
                vis1.Tprecio.setText(String.valueOf(vis1.tablac.getValueAt(k, 3)));
                vis1.TId_proveeedor.setEditable(false);

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }

        }
        if (e.getSource() == vis1.BEliminar) {
            int k = vis1.tablac.getSelectedRow();
            int c = vis1.tablac.getSelectedRowCount();
            if (k >= 0 && c == 1) {
                vis1.TId_proveeedor.setText(String.valueOf(vis1.tablac.getValueAt(k, 0)));
                vis1.TId_proveeedor.setEditable(false);
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta compra?", "Alerta!", JOptionPane.YES_NO_OPTION);
                contacto1 = huevos22.BD_huevos.getConexion();
                if (resp == 0) {
                    this.mom.Borrargastos(Integer.parseInt(this.vis1.TId_proveeedor.getText()));
                    JOptionPane.showMessageDialog(null, "Gasto Eliminado");
                    DefaultTableModel model = new DefaultTableModel();
                    model = mom.Lista_gastos();
                    vis1.tablac.setModel(model);
                    TableColumnModel columnModel = vis1.tablac.getColumnModel();
                    mom.desconectar();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe aceptar la eliminación");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }
        }
        if (e.getSource() == vis1.BCrear) {
            vis1.Lpeso.setVisible(true);
         
            vis1.Lprecio.setVisible(true);
            vis1.LProduto.setVisible(true);
            vis1.LCantidad.setVisible(true);
            vis1.Tcantidad.setVisible(true);
            vis1.Tprecio.setVisible(true);
            vis1.Cproductos.setVisible(true);
            vis1.JS1.setVisible(true);
            vis1.JS2.setVisible(true);
            vis1.CrearP.setVisible(true);
            vis1.Logo.setVisible(false);
            vis1.Opciones.setVisible(false);
            vis1.Cfecha.setVisible(false);
            vis1.Cnproducto.setVisible(false);
            vis1.BuscarP.setVisible(false);
            vis1.Opciones1.setVisible(false);
            vis1.ActualizarP.setVisible(false);
            vis1.cfecha.setVisible(false);
            vis1.cfecha1.setVisible(false);
            vis1.Bginforme.setVisible(false);
                vis1.ingresos.setVisible(false);
            vis1.pesos.setVisible(false);
            vis1.total.setVisible(false);

            vis1.Cproductos.setModel(mom.combo_tipogasto());
            vis1.Cproveedor.setModel(mom.combo_prove());
        }

        if (e.getSource() == vis1.CrearP) {
            contacto1 = huevos22.BD_huevos.getConexion();
            if (vis1.Cproductos.getSelectedIndex() == 0 || vis1.Tcantidad.getText().isEmpty() || vis1.Tprecio.getText().isEmpty()) { // si estos coampos no estan llenos
                JOptionPane.showMessageDialog(null, "Campos Vacios");
            } else {

                int v = this.mom.Agre_gastos(vis1.Cproductos.getSelectedItem().toString(), vis1.Tcantidad.getText(), Integer.parseInt(vis1.Tprecio.getText()));
                if (v == 0) {
                    JOptionPane.showMessageDialog(null, "No Guardado", "Informacion", 0);
                } else {
                    limpiarcampos();
                    vis1.Cproductos.setModel(mom.Combo_Productos());

                    JOptionPane.showMessageDialog(null, "Gasto Registrado", "Información", 1);
                    contacto1 = huevos22.BD_huevos.getConexion();
                    DefaultTableModel model = new DefaultTableModel();
                    model = mom.Lista_gastos();
                    vis1.tablac.setModel(model);
                    TableColumnModel columnModel = vis1.tablac.getColumnModel();
                    mom.desconectar();
                }

            }
        }
        if (e.getSource() == vis1.ListaB) {
            vis1.Lpeso.setVisible(false);

            vis1.Lprecio.setVisible(false);
            vis1.LProduto.setVisible(false);
            vis1.LCantidad.setVisible(false);
            vis1.Tcantidad.setVisible(false);
            vis1.Tprecio.setVisible(false);
            vis1.Cproveedor.setVisible(false);
            vis1.Cproductos.setVisible(false);
            vis1.JS1.setVisible(false);
            vis1.JS2.setVisible(false);
            vis1.CrearP.setVisible(false);
            vis1.ActualizarP.setVisible(false);
            vis1.Logo.setVisible(true);
            vis1.BuscarP.setVisible(true);
            vis1.cfecha.setVisible(false);
            vis1.cfecha1.setVisible(false);
            vis1.Bginforme.setVisible(false);

            vis1.Opciones.setVisible(true);
            vis1.Cnproducto.setModel(mom.combo_tipogasto());

        }

        if (e.getSource() == vis1.Opciones) {
            if (vis1.Opciones.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Opción");
            }
            if (vis1.Opciones.getSelectedIndex() == 1) {
                vis1.Cnproducto.setVisible(true);

            }

        }
//
        if (e.getSource() == vis1.BuscarP) {
            if (vis1.Opciones.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Opción");
            }
            if (vis1.Opciones.getSelectedIndex() == 1) {
                contacto1 = huevos22.BD_huevos.getConexion();

                vis1.tablac.setModel(this.mom.Buscar_gasto(vis1.Cnproducto.getSelectedItem().toString(), vis1.Opciones.getSelectedIndex()));

                if (this.vis1.Cnproducto.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);
                    mom.desconectar();
                }

            }

        }
        if (e.getSource() == vis1.Binforme) {
            vis1.Lpeso.setVisible(false);

            vis1.Lprecio.setVisible(false);
            vis1.LProduto.setVisible(false);
            vis1.LCantidad.setVisible(false);
            vis1.Tcantidad.setVisible(false);
            vis1.Tprecio.setVisible(false);
            vis1.Cproveedor.setVisible(false);
            vis1.Cproductos.setVisible(false);
            vis1.JS1.setVisible(false);
            vis1.JS2.setVisible(false);
            vis1.CrearP.setVisible(false);
            vis1.ActualizarP.setVisible(false);
            vis1.Logo.setVisible(true);
            vis1.BuscarP.setVisible(false);
            vis1.cfecha.setVisible(true);
            vis1.cfecha1.setVisible(true);
            vis1.Bginforme.setVisible(true);
            vis1.ingresos.setVisible(false);
            vis1.pesos.setVisible(false);
            vis1.total.setVisible(false);
            vis1.Cnproducto.setVisible(false);
        
            
            vis1.Opciones.setVisible(false);

        }

        if (e.getSource() == vis1.Bginforme) {
            contacto1 = huevos22.BD_huevos.getConexion();
            DefaultTableModel model = new DefaultTableModel();
            model = mom.Lista_IGASTOS(vis1.cfecha.getSelectedItem().toString(), vis1.cfecha1.getSelectedItem().toString());
   
            vis1.tablac.setModel(model);
            TableColumnModel columnModel = vis1.tablac.getColumnModel();

          
            System.out.print(Integer.toString(SumaBalance()));
            vis1.ingresos.setVisible(true);
            vis1.pesos.setVisible(true);
            vis1.total.setVisible(true);
            vis1.Logo.setVisible(true);
            vis1.total.setText(Integer.toString(SumaBalance()));
        }

        if (e.getSource() == vis1.CerrarB) {
            System.exit(0);
        }
        if (e.getSource() == vis1.MinimizarB) {
            vis1.setExtendedState(ICONIFIED);
        }
        if (e.getSource() == vis1.volver) {
            Vista_menu v = new Vista_menu();
            BD_huevos h = new BD_huevos();
            Controlador_menu M = new Controlador_menu(v, h);
            vis1.setVisible(false);

        }
        if (e.getSource() == vis1.Mostrar) {
            contacto1 = huevos22.BD_huevos.getConexion();
            DefaultTableModel model = new DefaultTableModel();
            model = mom.Lista_gastos();
            vis1.tablac.setModel(model);
            TableColumnModel columnModel = vis1.tablac.getColumnModel();
            mom.desconectar();
        }
    }
}
