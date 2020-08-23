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
public class Controlador_compras implements ActionListener {

    Vista_compras vis1;
    BD_huevos mom;

    Controlador_compras(Vista_compras v1, BD_huevos m) {
        mom = m;
        vis1 = v1;

        vis1.BCrear.addActionListener(this);
        vis1.CerrarB.addActionListener(this);
        vis1.MinimizarB.addActionListener(this);
        vis1.volver.addActionListener(this);
        vis1.Mostrar.addActionListener(this);
        vis1.Cproductos.addActionListener(this);
        vis1.Cprobe.addActionListener(this);
        vis1.CrearP.addActionListener(this);
        vis1.Cproductos.setModel(mom.Combo_Productos());
        vis1.Cprobe.setModel(mom.Combo_nombreProveedor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vis1.BCrear) {
            vis1.Lpeso.setVisible(true);
            vis1.Lunid.setVisible(true);
            vis1.Lprecio.setVisible(true);
            vis1.Lcliente.setVisible(true);
            vis1.LProduto.setVisible(true);
            vis1.LCantidad.setVisible(true);
            vis1.Tcantidad.setVisible(true);
            vis1.Tprecio.setVisible(true);
            vis1.Cprobe.setVisible(true);
            vis1.Cproductos.setVisible(true);
            vis1.JS1.setVisible(true);
            vis1.JS2.setVisible(true);
            vis1.CrearP.setVisible(true);
            vis1.Logo.setVisible(false);
        }
        if (e.getSource() == vis1.Cproductos) {
            contacto1 = huevos22.BD_huevos.getConexion();
            if (this.vis1.Cproductos.getSelectedIndex() >= 0) {
                String idproo = this.mom.idproductos(this.vis1.Cproductos.getSelectedItem().toString());
                //String cantidad = this.mom.cantidad(this.vism.idpro.getText());

                this.vis1.TId_proveeedor.setText(idproo);

                System.out.println("la id del producto es :" + idproo);

                if (this.vis1.Cproductos.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);

                }
            }

        }
        if (e.getSource() == vis1.Cprobe) {
            contacto1 = huevos22.BD_huevos.getConexion();
            if (this.vis1.Cprobe.getSelectedIndex() >= 0) {
                String idproo = this.mom.idproveedor(this.vis1.Cprobe.getSelectedItem().toString());
                //String cantidad = this.mom.cantidad(this.vism.idpro.getText());

                this.vis1.TId_proveeedor1.setText(idproo);

                System.out.println("la id del producto es :" + idproo);

                if (this.vis1.Cprobe.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);

                }
            }

        }
        if (e.getSource() == vis1.CrearP) {
            contacto1 = huevos22.BD_huevos.getConexion();
            if (vis1.Cproductos.getSelectedIndex() == 0 || vis1.Tcantidad.getText().isEmpty() || vis1.Tprecio.getText().isEmpty() || vis1.Cprobe.getSelectedIndex() == 0) { // si estos coampos no estan llenos
                JOptionPane.showMessageDialog(null, "Campos Vacios");
            } else {

                int v = this.mom.Agre_Com(Integer.parseInt(vis1.TId_proveeedor.getText()), Integer.parseInt(vis1.Tcantidad.getText()), Integer.parseInt(vis1.Tprecio.getText()), Integer.parseInt(vis1.TId_proveeedor1.getText()));
                if (v == 0) {
                    JOptionPane.showMessageDialog(null, "No Guardado", "Informacion", 0);
                } else {
                    JOptionPane.showMessageDialog(null, "Compra Registrada", "Información", 1);
                    contacto1 = huevos22.BD_huevos.getConexion();
                    DefaultTableModel model = new DefaultTableModel();
                    model = mom.Lista_compras();
                    vis1.tablac.setModel(model);
                    TableColumnModel columnModel = vis1.tablac.getColumnModel();

                    columnModel.getColumn(0).setPreferredWidth(20);
                    columnModel.getColumn(1).setPreferredWidth(100);
                    columnModel.getColumn(2).setPreferredWidth(100);
                    columnModel.getColumn(3).setPreferredWidth(100);
                    mom.desconectar();
                }

            }
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
            model = mom.Lista_compras();
            vis1.tablac.setModel(model);
            TableColumnModel columnModel = vis1.tablac.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(100);
            columnModel.getColumn(2).setPreferredWidth(100);
            columnModel.getColumn(3).setPreferredWidth(100);
            mom.desconectar();
        }
    }
}
