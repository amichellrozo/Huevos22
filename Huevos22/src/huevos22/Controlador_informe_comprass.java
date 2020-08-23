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
public class Controlador_informe_comprass implements ActionListener {

    Vista_informe_compras vis1;
    BD_huevos mom;

    Controlador_informe_comprass(Vista_informe_compras v1, BD_huevos m) {
        mom = m;
        vis1 = v1;

        vis1.CerrarB.addActionListener(this);
        vis1.MinimizarB.addActionListener(this);
        vis1.volver.addActionListener(this);
        vis1.Mostrar.addActionListener(this);
        vis1.Opciones.setModel(mom.combo_fechac());
        vis1.Opciones1.setModel(mom.combo_fechac());
    }

    public int SumaBalance() {
        int contar = vis1.tabla.getRowCount();
        int duma = 0;
        for (int i = 0; i < contar; i++) {
            duma = duma + Integer.parseInt(vis1.tabla.getValueAt(i, 4).toString());
        }
        return duma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
            model = mom.Lista_ICOMPRAS(vis1.Opciones.getSelectedItem().toString(), vis1.Opciones1.getSelectedItem().toString());
            vis1.tabla.setModel(model);
            TableColumnModel columnModel = vis1.tabla.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(30);
            columnModel.getColumn(1).setPreferredWidth(40);
            columnModel.getColumn(2).setPreferredWidth(40);
            columnModel.getColumn(3).setPreferredWidth(40);
            mom.desconectar();
            System.out.print(Integer.toString(SumaBalance()));
            vis1.egresos.setVisible(true);
            vis1.pesos.setVisible(true);
            vis1.total.setVisible(true);
            vis1.Logo.setVisible(false);
            vis1.total.setText(Integer.toString(SumaBalance()));
        }
    }

}
