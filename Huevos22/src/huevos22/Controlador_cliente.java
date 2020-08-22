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
             vis1.ActualizarC.setVisible(false);
            vis1.Logo.setVisible(false);
            limpiarcliente();
        }

        if (ae.getSource() == vis1.CrearP) {
            contacto1 = huevos22.BD_huevos.getConexion();
            int co = this.mom.Val_clie_Correo(this.vis1.TCorreo.getText());
            if (vis1.TPNombre.getText().isEmpty() || vis1.TSNombre.getText().isEmpty() || vis1.TPApellido.getText().isEmpty() || vis1.TSApellido.getText().isEmpty() || vis1.TCorreo.getText().isEmpty() || vis1.TTelefono.getText().isEmpty() || vis1.TDireccion.getText().isEmpty()) { // si estos coampos no estan llenos
                JOptionPane.showMessageDialog(null, "campos vacios");
            } else {
                if (co == 1) {
                    JOptionPane.showMessageDialog(null, "Este Cliente ya esta Registrado");
                } else {
                    if (!vis1.TCorreo.getText().contains("@") || !vis1.TCorreo.getText().contains(".")) {
                        JOptionPane.showMessageDialog(null, "Correo Invalido");
                    } else {
                        int v = this.mom.Agre_clientes(vis1.TPNombre.getText(), vis1.TSNombre.getText(), vis1.TPApellido.getText(), vis1.TSApellido.getText(), vis1.TCorreo.getText(), vis1.TTelefono.getText(), vis1.TDireccion.getText());
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
                    mom.desconectar();
                } else {
                    JOptionPane.showMessageDialog(null, "Debe aceptar la eliminación");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción", "Error", 0);
            }
        }
           

        if (ae.getSource() == vis1.ActualizarB) {
              limpiarcliente();
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
            limpiarcliente();
            mom.desconectar();
            } else {
                JOptionPane.showMessageDialog(null, "Cliete No Actulizado");
            }

        }
         
        
          if (ae.getSource() == vis1.Mostrar) {
              limpiarcliente();
            contacto1 = huevos22.BD_huevos.getConexion();
            DefaultTableModel model = new DefaultTableModel();
            model = mom.Lista_clie();
            vis1.tablac.setModel(model);
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
