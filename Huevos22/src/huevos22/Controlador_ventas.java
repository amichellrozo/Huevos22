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
public class Controlador_ventas implements ActionListener {

    Vista_ventas vis1;
    BD_huevos mom;

    Controlador_ventas(Vista_ventas v1, BD_huevos m) {
        mom = m;
        vis1 = v1;
        vis1.ListaB.addActionListener(this);
        vis1.BCrear.addActionListener(this);
        vis1.CerrarB.addActionListener(this);
        vis1.MinimizarB.addActionListener(this);
        vis1.volver.addActionListener(this);
        vis1.Mostrar.addActionListener(this);
        vis1.BuscarP.addActionListener(this);
        vis1.Cproductos.addActionListener(this);
        vis1.CrearP.addActionListener(this);
        vis1.Ccliente.addActionListener(this);
        vis1.Cproductos.setModel(mom.Combo_Productos());
        vis1.Ccliente.setModel(mom.Combo_nombrecliente());
        vis1.Cnproducto.setModel(mom.combo_pro());
        vis1.Cclientee.setModel(mom.combo_clientes());
        vis1.Cfecha.setModel(mom.combo_fecha());
        vis1.Opciones.addActionListener(this);
        vis1.BEliminar.addActionListener(this);
    }

    public void limpiarcampos() {
        vis1.Tprecio.setText("");
        vis1.Tcantidad.setText("");
        vis1.Ccliente.removeAllItems();
        vis1.Cproductos.removeAllItems();
        vis1.Cnproducto.removeAllItems();
        vis1.Cfecha.removeAllItems();
           vis1.Cclientee.removeAllItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vis1.BEliminar) {
            int k = vis1.tablav.getSelectedRow();
            int c = vis1.tablav.getSelectedRowCount();
            if (k >= 0 && c == 1) {
                vis1.TId_proveeedor.setText(String.valueOf(vis1.tablav.getValueAt(k, 0)));
                vis1.TId_proveeedor.setEditable(false);
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta venta?", "Alerta!", JOptionPane.YES_NO_OPTION);
                contacto1 = huevos22.BD_huevos.getConexion();
                if (resp == 0) {
                    this.mom.BorrarVenta(Integer.parseInt(this.vis1.TId_proveeedor.getText()));
                    JOptionPane.showMessageDialog(null, "Venta Eliminado");
                    DefaultTableModel model = new DefaultTableModel();
                    model = mom.Lista_ven();
                    vis1.tablav.setModel(model);
                    TableColumnModel columnModel = vis1.tablav.getColumnModel();

                    columnModel.getColumn(0).setPreferredWidth(20);
                    columnModel.getColumn(1).setPreferredWidth(50);
                    columnModel.getColumn(2).setPreferredWidth(50);
                    columnModel.getColumn(3).setPreferredWidth(50);
                    columnModel.getColumn(4).setPreferredWidth(100);
                    columnModel.getColumn(5).setPreferredWidth(100);
                    columnModel.getColumn(6).setPreferredWidth(120);
                    mom.desconectar();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe aceptar la eliminación");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }
        }
        if (e.getSource() == vis1.CrearP) {
            contacto1 = huevos22.BD_huevos.getConexion();
            if (vis1.Cproductos.getSelectedIndex() == 0 || vis1.Tcantidad.getText().isEmpty() || vis1.Tprecio.getText().isEmpty() || vis1.Ccliente.getSelectedIndex() == 0) { // si estos coampos no estan llenos
                JOptionPane.showMessageDialog(null, "Campos Vacios");
            } else {
                String cantidad = this.mom.cantidad(this.vis1.TId_proveeedor.getText());
                int amordemivida = Integer.parseInt(cantidad);
                int cantidad2 = Integer.parseInt(vis1.Tcantidad.getText());
                int vali = 1;
                if ((vis1.Tcantidad.getText().equals("0"))) {
                    JOptionPane.showMessageDialog(null, "No puede vender 0 cantidades", "informacion", 0);
                } else {
                    if ((cantidad2 > amordemivida)) {
                        JOptionPane.showMessageDialog(null, "No hay suficientes productos en bodega", "informacion", 0);
                    } else {

                        if (vali == 1) {
                            int v = this.mom.Agre_ventita(Integer.parseInt(vis1.TId_proveeedor.getText()), Integer.parseInt(vis1.Tcantidad.getText()), Integer.parseInt(vis1.Tprecio.getText()), Integer.parseInt(vis1.TId_proveeedor1.getText()));
                            if (v == 0) {
                                JOptionPane.showMessageDialog(null, "No Guardado", "Informacion", 0);
                            } else {
                                limpiarcampos();
                                vis1.Cproductos.setModel(mom.Combo_Productos());
                                vis1.Ccliente.setModel(mom.Combo_nombreProveedor());
                                JOptionPane.showMessageDialog(null, "Venta Registrada", "Información", 1);
                                contacto1 = huevos22.BD_huevos.getConexion();
                                DefaultTableModel model = new DefaultTableModel();
                                model = mom.Lista_ven();
                                vis1.tablav.setModel(model);
                                TableColumnModel columnModel = vis1.tablav.getColumnModel();

                                columnModel.getColumn(0).setPreferredWidth(20);
                                columnModel.getColumn(1).setPreferredWidth(50);
                                columnModel.getColumn(2).setPreferredWidth(50);
                                columnModel.getColumn(3).setPreferredWidth(50);
                                columnModel.getColumn(4).setPreferredWidth(100);
                                columnModel.getColumn(5).setPreferredWidth(100);
                                columnModel.getColumn(6).setPreferredWidth(120);
                                mom.desconectar();
                            }
                        }
                    }
                }

            }
        }
        if (e.getSource() == vis1.BCrear) {

            vis1.Lpeso.setVisible(true);
            vis1.Lunid.setVisible(true);
            vis1.Lprecio.setVisible(true);
            vis1.Lcliente.setVisible(true);
            vis1.LProduto.setVisible(true);
            vis1.LCantidad.setVisible(true);
            vis1.Tcantidad.setVisible(true);
            vis1.Tprecio.setVisible(true);
            vis1.Ccliente.setVisible(true);
            vis1.Cproductos.setVisible(true);
            vis1.JS1.setVisible(true);
            vis1.JS2.setVisible(true);
            vis1.CrearP.setVisible(true);
            vis1.Logo.setVisible(false);
            vis1.Opciones.setVisible(false);
            vis1.Cfecha.setVisible(false);
            vis1.Cclientee.setVisible(false);
            vis1.Cnproducto.setVisible(false);
            vis1.BuscarP.setVisible(false);
         vis1.Cproductos.setModel(mom.Combo_Productos());
        vis1.Ccliente.setModel(mom.Combo_nombrecliente());

        }
        if (e.getSource() == vis1.Cproductos) {
            contacto1 = huevos22.BD_huevos.getConexion();
            if (this.vis1.Cproductos.getSelectedIndex() >= 0) {
                String idproo = this.mom.idproductos(this.vis1.Cproductos.getSelectedItem().toString());
                this.vis1.TId_proveeedor.setText(idproo);
                String cantidad = this.mom.cantidad(this.vis1.TId_proveeedor.getText());

                System.out.println("la id del producto es :" + idproo + "Cantidad:" + cantidad);

                if (this.vis1.Cproductos.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);

                }
            }

        }

        if (e.getSource() == vis1.Ccliente) {
            contacto1 = huevos22.BD_huevos.getConexion();
            if (this.vis1.Ccliente.getSelectedIndex() >= 0) {
                String idproo = this.mom.idcliente(this.vis1.Ccliente.getSelectedItem().toString());
                //String cantidad = this.mom.cantidad(this.vism.idpro.getText());

                this.vis1.TId_proveeedor1.setText(idproo);

                System.out.println("la id del producto es :" + idproo);

                if (this.vis1.Ccliente.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);

                }
            }

        }

        if (e.getSource() == vis1.ListaB) {
            vis1.Lpeso.setVisible(false);
            vis1.Lunid.setVisible(false);
            vis1.Lprecio.setVisible(false);
            vis1.Lcliente.setVisible(false);
            vis1.LProduto.setVisible(false);
            vis1.LCantidad.setVisible(false);
            vis1.Tcantidad.setVisible(false);
            vis1.Tprecio.setVisible(false);
            vis1.Ccliente.setVisible(false);
            vis1.Cproductos.setVisible(false);
            vis1.JS1.setVisible(false);
            vis1.JS2.setVisible(false);
            vis1.CrearP.setVisible(false);
            vis1.Logo.setVisible(true);

            vis1.Opciones.setVisible(true);
            vis1.BuscarP.setVisible(true);
                    vis1.Cnproducto.setModel(mom.combo_pro());
        vis1.Cclientee.setModel(mom.combo_clientes());
        vis1.Cfecha.setModel(mom.combo_fecha());
            

        }

        if (e.getSource() == vis1.Opciones) {
            if (vis1.Opciones.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Opción");
            }
            if (vis1.Opciones.getSelectedIndex() == 1) {
                vis1.Cfecha.setVisible(false);
                vis1.Cclientee.setVisible(false);
                vis1.Cnproducto.setVisible(true);

            }
            if (vis1.Opciones.getSelectedIndex() == 2) {
                vis1.Cfecha.setVisible(false);
                vis1.Cclientee.setVisible(true);
                vis1.Cnproducto.setVisible(false);

            }
            if (vis1.Opciones.getSelectedIndex() == 3) {
                vis1.Cfecha.setVisible(true);
                vis1.Cclientee.setVisible(false);
                vis1.Cnproducto.setVisible(false);

            }
        }

        if (e.getSource() == vis1.BuscarP) {
            if (vis1.Opciones.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Opción");
            }
            if (vis1.Opciones.getSelectedIndex() == 1) {
                contacto1 = huevos22.BD_huevos.getConexion();
                vis1.tablav.setModel(this.mom.Buscar_venta(vis1.Cnproducto.getSelectedItem().toString(), vis1.Opciones.getSelectedIndex()));
                TableColumnModel columnModel = vis1.tablav.getColumnModel();

                columnModel.getColumn(0).setPreferredWidth(30);
                columnModel.getColumn(1).setPreferredWidth(80);
                columnModel.getColumn(2).setPreferredWidth(70);
                columnModel.getColumn(3).setPreferredWidth(70);
                columnModel.getColumn(4).setPreferredWidth(80);
                columnModel.getColumn(5).setPreferredWidth(80);
                columnModel.getColumn(6).setPreferredWidth(100);

                if (this.vis1.Cnproducto.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);
                    mom.desconectar();
                }
                        vis1.Cnproducto.setModel(mom.combo_pro());

            }

            if (vis1.Opciones.getSelectedIndex() == 2) {
                contacto1 = huevos22.BD_huevos.getConexion();
                vis1.tablav.setModel(this.mom.Buscar_venta(vis1.Cclientee.getSelectedItem().toString(), vis1.Opciones.getSelectedIndex()));
                TableColumnModel columnModel = vis1.tablav.getColumnModel();

                columnModel.getColumn(0).setPreferredWidth(30);
                columnModel.getColumn(1).setPreferredWidth(80);
                columnModel.getColumn(2).setPreferredWidth(70);
                columnModel.getColumn(3).setPreferredWidth(70);
                columnModel.getColumn(4).setPreferredWidth(80);
                columnModel.getColumn(5).setPreferredWidth(80);
                columnModel.getColumn(6).setPreferredWidth(100);

                if (this.vis1.Cclientee.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);
                    mom.desconectar();
                }
                        vis1.Cclientee.setModel(mom.combo_clientes());
     
            }

            if (vis1.Opciones.getSelectedIndex() == 3) {
                contacto1 = huevos22.BD_huevos.getConexion();
                vis1.tablav.setModel(this.mom.Buscar_venta(vis1.Cfecha.getSelectedItem().toString(), vis1.Opciones.getSelectedIndex()));
                TableColumnModel columnModel = vis1.tablav.getColumnModel();

                columnModel.getColumn(0).setPreferredWidth(30);
                columnModel.getColumn(1).setPreferredWidth(80);
                columnModel.getColumn(2).setPreferredWidth(70);
                columnModel.getColumn(3).setPreferredWidth(70);
                columnModel.getColumn(4).setPreferredWidth(80);
                columnModel.getColumn(5).setPreferredWidth(80);
                columnModel.getColumn(6).setPreferredWidth(100);

                if (this.vis1.Cfecha.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);
                    mom.desconectar();
                }
                   vis1.Cfecha.setModel(mom.combo_fecha());
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
            model = mom.Lista_ven();
            vis1.tablav.setModel(model);
            TableColumnModel columnModel = vis1.tablav.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(30);
            columnModel.getColumn(1).setPreferredWidth(80);
            columnModel.getColumn(2).setPreferredWidth(70);
            columnModel.getColumn(3).setPreferredWidth(70);
            columnModel.getColumn(4).setPreferredWidth(80);
            columnModel.getColumn(5).setPreferredWidth(80);
            columnModel.getColumn(6).setPreferredWidth(100);
            mom.desconectar();
        }
    }
}
