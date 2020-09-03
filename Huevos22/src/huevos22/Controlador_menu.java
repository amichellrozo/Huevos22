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

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author michi
 */
public class Controlador_menu implements ActionListener {
    
    Vista_menu vs;
    BD_huevos mom;
    
    Controlador_menu(Vista_menu v, BD_huevos m) {
        mom = m;
        vs = v;
        
        this.vs.JBclientes.addActionListener(this);
        this.vs.JBproveedores.addActionListener(this);
        this.vs.JBcompras.addActionListener(this);
        this.vs.JBventas.addActionListener(this);
        this.vs.JBinformec.addActionListener(this);
        this.vs.JBinformev.addActionListener(this);
        this.vs.JBinventario.addActionListener(this);
        vs.JBminimizar.addActionListener(this);
        vs.JBcerrar.addActionListener(this);
        vs.volver.addActionListener(this);
        vs.JBgastos.addActionListener(this);
    }
    
    static Connection contacto1 = null;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == vs.JBproveedores) {
            
            Vista_Proveedor v1 = new Vista_Proveedor();
            BD_huevos m = new BD_huevos();
            Controlador_Proveedor n = new Controlador_Proveedor(v1, m);
            
            vs.setVisible(false);
            
        }
        if (ae.getSource() == vs.JBclientes) {
            Vista_clientes v1 = new Vista_clientes();
            BD_huevos m = new BD_huevos();
            Controlador_cliente n = new Controlador_cliente(v1, m);
            
            vs.setVisible(false);
        }
        
        if (ae.getSource() == vs.JBventas) {
            Vista_ventas v2 = new Vista_ventas();
            BD_huevos m = new BD_huevos();
            Controlador_ventas n = new Controlador_ventas(v2, m);
            
            vs.setVisible(false);
        }
        
        if (ae.getSource() == vs.JBcompras) {
            Vista_compras vi = new Vista_compras();
            BD_huevos bd = new BD_huevos();
            Controlador_compras c1 = new Controlador_compras(vi, bd);
            vs.setVisible(false);
        }
        if (ae.getSource() == vs.JBinventario) {
            Vista_inventario vi = new Vista_inventario();
            BD_huevos bd = new BD_huevos();
            Controlador_Inventario c1 = new Controlador_Inventario(vi, bd);
            vs.setVisible(false);
        }
        if (ae.getSource() == vs.JBinformec) {
            Vista_informe_compras v = new Vista_informe_compras();
            BD_huevos bd = new BD_huevos();
            Controlador_informe_comprass c1 = new Controlador_informe_comprass(v, bd);
            vs.setVisible(false);
        }
        
        if (ae.getSource() == vs.JBinformev) {
            Vista_informe_ventas v = new Vista_informe_ventas();
            BD_huevos bd = new BD_huevos();
            Controlador_informe_ventas c1 = new Controlador_informe_ventas(v, bd);
            vs.setVisible(false);
        }
        if (ae.getSource() == vs.volver) {
            Vista_login v1 = new Vista_login();
            BD_huevos m = new BD_huevos();
            Controlador_Login n = new Controlador_Login(v1, m);
            
            vs.setVisible(false);
        }
        if (ae.getSource() == vs.JBgastos) {
            Vista_gastos v1 = new Vista_gastos();
            BD_huevos m = new BD_huevos();
            Controlador_gastos n = new Controlador_gastos(v1, m);
            
            vs.setVisible(false);
        }
        
        if (ae.getSource() == vs.JBcerrar) {
            System.exit(0);
        }
        if (ae.getSource() == vs.JBminimizar) {
            vs.setExtendedState(ICONIFIED);
        }
    }
    
}
