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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author michi
 */
public class Controlador_ventas implements ActionListener{
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
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == vis1.BCrear){
            
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
        vis1. Cclientee.setVisible(false);
        vis1. Cnproducto.setVisible(false);
         vis1.BuscarP.setVisible(false);
         
            
            
        }
                if(e.getSource() == vis1.ListaB){
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
            vis1.Logo.setVisible(false);

         vis1.Opciones.setVisible(true);
   
         vis1.Cfecha.setVisible(true);
        vis1. Cclientee.setVisible(true);
        vis1. Cnproducto.setVisible(true);
         vis1.BuscarP.setVisible(true);
         
            
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
            model = mom.Lista_Inv();
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
    

