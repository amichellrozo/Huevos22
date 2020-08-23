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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author michi
 */
public class Controlador_cliente implements ActionListener, MouseListener, KeyListener {

    Vista_clientes vis1;
    BD_huevos mom;


    Controlador_cliente(Vista_clientes v1, BD_huevos m) {
        mom = m;
        vis1 = v1;

        vis1.BCrear.addActionListener(this);
        this.vis1.tablac.addMouseListener(this);
        vis1.ActualizarB.addActionListener(this);
        vis1.BEliminar.addActionListener(this);
        vis1.ListaB.addActionListener(this);
        vis1.CrearP.addActionListener(this);
        vis1.Mostrar.addActionListener(this);
        vis1.ActualizarC.addActionListener(this);
        vis1.CerrarB.addActionListener(this);
        vis1.MinimizarB.addActionListener(this);
        vis1.volver.addActionListener(this);
        vis1.Nombres.setModel(mom.Combo_nombrecliente());
        vis1.Telefonos.setModel(mom.Combo_telefonocliente());
        vis1.BuscarP.addActionListener(this);
        vis1.Opciones.addActionListener(this);

    }

    public void limpiarcliente() {
        vis1.TPNombre.setText("");
        vis1.TSNombre.setText("");
        vis1.TPApellido.setText("");
        vis1.TSApellido.setText("");
        vis1.TCorreo.setText("");
        vis1.TTelefono.setText("");
        vis1.TDireccion.setText("");
        vis1.TId_cliente.setText("");
        vis1.Nombres.removeAllItems();
        vis1.Telefonos.removeAllItems();
    }

    public void recarcarven() {
        vis1.Nombres.setModel(mom.Combo_nombrecliente());
        vis1.Telefonos.setModel(mom.Combo_telefonocliente());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == vis1.BCrear) {
            vis1.PNombre.setVisible(true);
            vis1.SNombre.setVisible(true);
            vis1.PApellido.setVisible(true);
            vis1.SApellido.setVisible(true);
            vis1.Correo.setVisible(true);
            vis1.Telefono.setVisible(true);
            vis1.Direccion.setVisible(true);
            vis1.TPNombre.setVisible(true);
            vis1.TSNombre.setVisible(true);
            vis1.TPApellido.setVisible(true);
            vis1.TSApellido.setVisible(true);
            vis1.TCorreo.setVisible(true);
            vis1.TTelefono.setVisible(true);
            vis1.TDireccion.setVisible(true);
            vis1.JS1.setVisible(true);
            vis1.JS2.setVisible(true);
            vis1.JS3.setVisible(true);
            vis1.JS4.setVisible(true);
            vis1.JS5.setVisible(true);
            vis1.JS6.setVisible(true);
            vis1.JS7.setVisible(true);
            vis1.CrearP.setVisible(true);
            vis1.Opciones.setVisible(false);
            vis1.Nombres.setVisible(false);
            vis1.Telefonos.setVisible(false);
            vis1.BuscarP.setVisible(false);
            vis1.ActualizarC.setVisible(false);
            vis1.Logo.setVisible(false);
            limpiarcliente();
        }

        if (ae.getSource() == vis1.CrearP) {
            contacto1 = huevos22.BD_huevos.getConexion();
            int co = this.mom.Val_clie_Correo(this.vis1.TCorreo.getText());
            if (vis1.TPNombre.getText().isEmpty() || vis1.TSNombre.getText().isEmpty() || vis1.TPApellido.getText().isEmpty() || vis1.TSApellido.getText().isEmpty() || vis1.TDireccion.getText().isEmpty() || vis1.TTelefono.getText().isEmpty() || vis1.TCorreo.getText().isEmpty()) { // si estos coampos no estan llenos
                JOptionPane.showMessageDialog(null, "campos vacios");
            } else {
                if (co == 1) {
                    JOptionPane.showMessageDialog(null, "Este Cliente ya esta Registrado");
                } else {
                    if (!vis1.TCorreo.getText().contains("@") || !vis1.TCorreo.getText().contains(".")) {
                        JOptionPane.showMessageDialog(null, "Correo Invalido");
                    } else {
                        int v = this.mom.Agre_clientes(vis1.TPNombre.getText(), vis1.TSNombre.getText(), vis1.TPApellido.getText(), vis1.TSApellido.getText(), vis1.TDireccion.getText(), vis1.TTelefono.getText(), vis1.TCorreo.getText());
                        limpiarcliente();
                        if (v == 0) {
                            JOptionPane.showMessageDialog(null, "No Guardado", "Informacion", 0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente Registrado", "informacion", 1);
                            limpiarcliente();
                            contacto1 = huevos22.BD_huevos.getConexion();
                            DefaultTableModel model = new DefaultTableModel();
                            model = mom.Lista_clie();
                            vis1.tablac.setModel(model);
                            TableColumnModel columnModel = vis1.tablac.getColumnModel();

                            columnModel.getColumn(0).setPreferredWidth(20);
                            columnModel.getColumn(1).setPreferredWidth(50);
                            columnModel.getColumn(2).setPreferredWidth(50);
                            columnModel.getColumn(3).setPreferredWidth(50);
                            columnModel.getColumn(4).setPreferredWidth(50);
                            columnModel.getColumn(5).setPreferredWidth(70);
                            columnModel.getColumn(6).setPreferredWidth(60);
                            columnModel.getColumn(7).setPreferredWidth(150);
                            recarcarven();
                            mom.desconectar();
                        }
                    }

                }

            }
            mom.desconectar();
        }
        //borrar
        if (ae.getSource() == vis1.BEliminar) {
            limpiarcliente();
            int k = vis1.tablac.getSelectedRow();
            int c = vis1.tablac.getSelectedRowCount();
            if (k >= 0 && c == 1) {
                vis1.TId_cliente.setText(String.valueOf(vis1.tablac.getValueAt(k, 0)));
                vis1.TId_cliente.setEditable(false);
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este Cliente?", "Alerta!", JOptionPane.YES_NO_OPTION);
                contacto1 = huevos22.BD_huevos.getConexion();
                if (resp == 0) {
                    this.mom.Borrarcliente(Integer.parseInt(this.vis1.TId_cliente.getText()));
                    JOptionPane.showMessageDialog(null, "Cliente Eliminado");
                    DefaultTableModel model = new DefaultTableModel();
                    model = mom.Lista_clie();
                    vis1.tablac.setModel(model);
                    TableColumnModel columnModel = vis1.tablac.getColumnModel();

                    columnModel.getColumn(0).setPreferredWidth(20);
                    columnModel.getColumn(1).setPreferredWidth(50);
                    columnModel.getColumn(2).setPreferredWidth(50);
                    columnModel.getColumn(3).setPreferredWidth(50);
                    columnModel.getColumn(4).setPreferredWidth(50);
                    columnModel.getColumn(5).setPreferredWidth(70);
                    columnModel.getColumn(6).setPreferredWidth(60);
                    columnModel.getColumn(7).setPreferredWidth(150);
                    recarcarven();
                    mom.desconectar();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe aceptar la eliminación");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }
        }
        //actualizar

        if (ae.getSource() == vis1.ActualizarB) {
            limpiarcliente();
            vis1.Opciones.setVisible(false);
            vis1.Nombres.setVisible(false);
            vis1.Telefonos.setVisible(false);
            vis1.BuscarP.setVisible(false);
            vis1.PNombre.setVisible(true);
            vis1.SNombre.setVisible(true);
            vis1.PApellido.setVisible(true);
            vis1.SApellido.setVisible(true);
            vis1.Correo.setVisible(true);
            vis1.Telefono.setVisible(true);
            vis1.Direccion.setVisible(true);
            vis1.TPNombre.setVisible(true);
            vis1.TSNombre.setVisible(true);
            vis1.TPApellido.setVisible(true);
            vis1.TSApellido.setVisible(true);
            vis1.TCorreo.setVisible(true);
            vis1.TTelefono.setVisible(true);
            vis1.TDireccion.setVisible(true);
            vis1.JS1.setVisible(true);
            vis1.JS2.setVisible(true);
            vis1.JS3.setVisible(true);
            vis1.JS4.setVisible(true);
            vis1.JS5.setVisible(true);
            vis1.JS6.setVisible(true);
            vis1.JS7.setVisible(true);
            vis1.CrearP.setVisible(false);
            vis1.ActualizarC.setVisible(true);
            vis1.TId_cliente.setVisible(false);

            vis1.Logo.setVisible(false);
            int k = vis1.tablac.getSelectedRow();
            int c = vis1.tablac.getSelectedRowCount();
            if (k >= 0 && c == 1) {
                vis1.TId_cliente.setText(String.valueOf(vis1.tablac.getValueAt(k, 0)));
                vis1.TPNombre.setText(String.valueOf(vis1.tablac.getValueAt(k, 1)));
                vis1.TSNombre.setText(String.valueOf(vis1.tablac.getValueAt(k, 2)));
                vis1.TPApellido.setText(String.valueOf(vis1.tablac.getValueAt(k, 3)));
                vis1.TSApellido.setText(String.valueOf(vis1.tablac.getValueAt(k, 4)));
                vis1.TDireccion.setText(String.valueOf(vis1.tablac.getValueAt(k, 5)));
                vis1.TTelefono.setText(String.valueOf(vis1.tablac.getValueAt(k, 6)));
                vis1.TCorreo.setText(String.valueOf(vis1.tablac.getValueAt(k, 7)));
                vis1.TId_cliente.setEditable(false);

            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }

        }

        if (ae.getSource() == vis1.ActualizarC) {
            contacto1 = huevos22.BD_huevos.getConexion();
            int i = mom.Actualizarcliente(Integer.parseInt(vis1.TId_cliente.getText()), vis1.TPNombre.getText(), vis1.TSNombre.getText(),
                    vis1.TPApellido.getText(), vis1.TSApellido.getText(), vis1.TDireccion.getText(), vis1.TTelefono.getText(), vis1.TCorreo.getText());

            if (i == 1) {
                System.out.println(i);
                JOptionPane.showMessageDialog(null, "Cliete Actualizado");
                DefaultTableModel model = new DefaultTableModel();
                model = mom.Lista_clie();
                vis1.tablac.setModel(model);
                TableColumnModel columnModel = vis1.tablac.getColumnModel();

                columnModel.getColumn(0).setPreferredWidth(20);
                columnModel.getColumn(1).setPreferredWidth(50);
                columnModel.getColumn(2).setPreferredWidth(50);
                columnModel.getColumn(3).setPreferredWidth(50);
                columnModel.getColumn(4).setPreferredWidth(50);
                columnModel.getColumn(5).setPreferredWidth(70);
                columnModel.getColumn(6).setPreferredWidth(60);
                columnModel.getColumn(7).setPreferredWidth(150);
                limpiarcliente();
                recarcarven();
                mom.desconectar();
            } else {
                JOptionPane.showMessageDialog(null, "Cliete No Actulizado");
            }

        }

        //buscar
        if (ae.getSource() == vis1.ListaB) {
            limpiarcliente();

            vis1.Opciones.setVisible(true);
            vis1.Nombres.setVisible(false);
            vis1.Telefonos.setVisible(false);
            vis1.BuscarP.setVisible(true);

            vis1.PNombre.setVisible(false);
            vis1.SNombre.setVisible(false);
            vis1.PApellido.setVisible(false);
            vis1.SApellido.setVisible(false);
            vis1.Correo.setVisible(false);
            vis1.Telefono.setVisible(false);
            vis1.Direccion.setVisible(false);
            vis1.TPNombre.setVisible(false);
            vis1.TSNombre.setVisible(false);
            vis1.TPApellido.setVisible(false);
            vis1.TSApellido.setVisible(false);
            vis1.TCorreo.setVisible(false);
            vis1.TTelefono.setVisible(false);
            vis1.TDireccion.setVisible(false);
            vis1.JS1.setVisible(false);
            vis1.JS2.setVisible(false);
            vis1.JS3.setVisible(false);
            vis1.JS4.setVisible(false);
            vis1.JS5.setVisible(false);
            vis1.JS6.setVisible(false);
            vis1.JS7.setVisible(false);
            vis1.CrearP.setVisible(false);
            vis1.ActualizarC.setVisible(false);
            vis1.Logo.setVisible(false);
        }
        if (ae.getSource() == vis1.Opciones) {
            if (vis1.Opciones.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Opción");
            }
            if (vis1.Opciones.getSelectedIndex() == 1) {
                vis1.Nombres.setVisible(true);
                vis1.Telefonos.setVisible(false);
                limpiarcliente();
                recarcarven();
            }
            if (vis1.Opciones.getSelectedIndex() == 2) {
                vis1.Telefonos.setVisible(true);
                vis1.Nombres.setVisible(false);
                limpiarcliente();
                recarcarven();
            }
        }

        if (ae.getSource() == vis1.BuscarP) {
            if (vis1.Opciones.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione Opción");
            }
            if (vis1.Opciones.getSelectedIndex() == 1) {
                contacto1 = huevos22.BD_huevos.getConexion();
                vis1.tablac.setModel(this.mom.Buscar_cliente(vis1.Nombres.getSelectedItem().toString(), vis1.Opciones.getSelectedIndex()));
                TableColumnModel columnModel = vis1.tablac.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(20);
                columnModel.getColumn(1).setPreferredWidth(50);
                columnModel.getColumn(2).setPreferredWidth(50);
                columnModel.getColumn(3).setPreferredWidth(50);
                columnModel.getColumn(4).setPreferredWidth(50);
                columnModel.getColumn(5).setPreferredWidth(70);
                columnModel.getColumn(6).setPreferredWidth(60);
                columnModel.getColumn(7).setPreferredWidth(150);

                if (this.vis1.Nombres.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);
                    limpiarcliente();
                    recarcarven();
                    mom.desconectar();
                }
            }
            if (vis1.Opciones.getSelectedIndex() == 2) {
                contacto1 = huevos22.BD_huevos.getConexion();
                vis1.tablac.setModel(this.mom.Buscar_cliente(vis1.Telefonos.getSelectedItem().toString(), vis1.Opciones.getSelectedIndex()));
                TableColumnModel columnModel = vis1.tablac.getColumnModel();

                columnModel.getColumn(0).setPreferredWidth(20);
                columnModel.getColumn(1).setPreferredWidth(50);
                columnModel.getColumn(2).setPreferredWidth(50);
                columnModel.getColumn(3).setPreferredWidth(50);
                columnModel.getColumn(4).setPreferredWidth(50);
                columnModel.getColumn(5).setPreferredWidth(70);
                columnModel.getColumn(6).setPreferredWidth(60);
                columnModel.getColumn(7).setPreferredWidth(150);
                if (this.vis1.Telefonos.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCIÓN", "SIN SELECCIÓN", 0);
                    limpiarcliente();
                    recarcarven();
                    mom.desconectar();
                }
            }
        }

        if (ae.getSource() == vis1.Mostrar) {
                 vis1.PNombre.setVisible(   false);
            vis1.SNombre.setVisible(   false);
            vis1.PApellido.setVisible(   false);
            vis1.SApellido.setVisible(   false);
            vis1.Correo.setVisible(   false);
            vis1.Telefono.setVisible(   false);
            vis1.Direccion.setVisible(   false);
            vis1.TPNombre.setVisible(   false);
            vis1.TSNombre.setVisible(   false);
            vis1.TPApellido.setVisible(   false);
            vis1.TSApellido.setVisible(   false);
            vis1.TCorreo.setVisible(   false);
            vis1.TTelefono.setVisible(   false);
            vis1.TDireccion.setVisible(   false);
            vis1.JS1.setVisible(   false);
            vis1.JS2.setVisible(   false);
            vis1.JS3.setVisible(   false);
            vis1.JS4.setVisible(   false);
            vis1.JS5.setVisible(   false);
            vis1.JS6.setVisible(   false);
            vis1.JS7.setVisible(   false);
            vis1.CrearP.setVisible(   false);
            vis1.Opciones.setVisible(false);
            vis1.Nombres.setVisible(false);
            vis1.Telefonos.setVisible(false);
            vis1.BuscarP.setVisible(false);
            vis1.ActualizarC.setVisible(false);
            vis1.Logo.setVisible(true);
            contacto1 = huevos22.BD_huevos.getConexion();
            DefaultTableModel model = new DefaultTableModel();
            model = mom.Lista_clie();
             vis1.tablac.setModel(model);
            TableColumnModel columnModel = vis1.tablac.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(20);
            columnModel.getColumn(1).setPreferredWidth(50);
            columnModel.getColumn(2).setPreferredWidth(50);
            columnModel.getColumn(3).setPreferredWidth(50);
            columnModel.getColumn(4).setPreferredWidth(50);
            columnModel.getColumn(5).setPreferredWidth(70);
            columnModel.getColumn(6).setPreferredWidth(60);
            columnModel.getColumn(7).setPreferredWidth(150);

            limpiarcliente();
            recarcarven();
            mom.desconectar();
        }
        if (ae.getSource() == vis1.CerrarB) {
            System.exit(0);
        }
        if (ae.getSource() == vis1.MinimizarB) {
            vis1.setExtendedState(ICONIFIED);
        }
        if (ae.getSource() == vis1.volver) {
            Vista_menu v = new Vista_menu();
            BD_huevos h = new BD_huevos();
            Controlador_menu M = new Controlador_menu(v, h);
            vis1.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
