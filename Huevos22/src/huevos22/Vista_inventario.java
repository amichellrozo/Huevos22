/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevos22;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author michi
 */
public class Vista_inventario extends JFrame{
     JPanel Panel1, Panel2;
    JLabel Titulo, Logo;
    JTextField TPNombre;
    Font fuente1 = new Font("Microsoft JhengHei Light", Font.PLAIN, 50);
    Font fuente2 = new Font("Microsoft JhengHei Light", Font.PLAIN, 18);
    Font fuente3 = new Font("Microsoft JhengHei Light", Font.PLAIN, 15);
    Color color1 = new Color(110, 197, 184);
    Color color2 = new Color(220, 91, 5);
    Border thickBorder = new LineBorder(Color.white, 2);
    JButton CerrarB, MinimizarB, volver, Mostrar;
    ImageIcon Cerrar, Minimizar, ICrear, IEliminar, VolverI, ActualizarI, ListaI, imagen, MostrarI;
    JTable tabla;
    JScrollPane panel;
    String Titulos[] = {"Nombre", "Apellido", "Edad"};

    Vista_inventario() {
        setTitle("Menu");
        setSize(1250, 720);
        setLayout(null);

        JPanel Panel1 = new JPanel();
        Panel1.setLayout(null);
        Panel1.setBackground(Color.WHITE);
        Panel1.setBounds(800, 0, 550, 720);

        JPanel Panel2 = new JPanel();
        Panel2.setLayout(null);
        Panel2.setBackground(color1);
        Panel2.setBounds(0, 0, 800, 720);

        JLabel Titulo = new JLabel("INVENTARIO");
        Titulo.setFont(fuente1);
        Titulo.setForeground(color2);
        Titulo.setBounds(50, 50, 350, 45);

        MinimizarB = new JButton(Minimizar);
        MinimizarB.setContentAreaFilled(false);
        MinimizarB.setBorderPainted(false);
        MinimizarB.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Minimizar = new ImageIcon("minimizarn.png");
        ImageIcon d = new ImageIcon(Minimizar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        MinimizarB.setIcon(d);

        CerrarB = new JButton(Cerrar);
        CerrarB.setContentAreaFilled(false);
        CerrarB.setBorderPainted(false);
        CerrarB.setToolTipText("ESTA OPCION CIERRA EL PROGRAMA");
        Cerrar = new ImageIcon("cerrarn.png");
        ImageIcon e = new ImageIcon(Cerrar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        CerrarB.setIcon(e);

        CerrarB.setBounds(400, 10, 35, 35);
        MinimizarB.setBounds(365, 10, 35, 35);

        volver = new JButton(Minimizar);
        volver.setContentAreaFilled(false);
        volver.setBorderPainted(false);
        volver.setToolTipText("ESTA OPCION NOS REGRESA AL MENÚ");
        VolverI = new ImageIcon("volver.png");
        ImageIcon de = new ImageIcon(VolverI.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        volver.setIcon(de);

        volver.setBounds(400, 670, 35, 35);

        imagen = new ImageIcon("Logo1.png");
        Logo = new JLabel(imagen);
        Logo.setBounds(20, 20, 410, 680);

        tabla = new JTable();
        tabla = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        panel = new JScrollPane(tabla);// debe ir aqui pare evitar errores
        tabla.getTableHeader().setReorderingAllowed(false);//Orden de las columnas
        tabla.getTableHeader().setResizingAllowed(false);// orden
        tabla.setFocusable(false);//
        tabla.setBackground(new Color(110, 197, 184));
        panel.getViewport().setBackground(color1);
        panel.setBorder(new LineBorder(color1));
        tabla.setBorder(new LineBorder(color1));
        tabla.setForeground(Color.white);
        panel.setBounds(60, 170, 660, 480);

        TPNombre.setVisible(false);
        
        
        Mostrar = new JButton("MOSTRAR TODO");
        Mostrar.setToolTipText("ESTA OPCIÓN LISTA LOS PROVEEDORES");
        Mostrar.setForeground(color2);
        Mostrar.setBackground(Color.white);
        Mostrar.setFont(fuente2);

        Mostrar.setBounds(300, 670, 180, 45);
        Panel2.add(Mostrar);
        Panel2.add(panel);
        Panel1.add(Logo);
        Panel1.add(volver);
        Panel1.add(TPNombre);
        Panel1.add(CerrarB);
        Panel1.add(MinimizarB);
        Panel1.add(Titulo);
        this.add(Panel2);
        this.add(Panel1);

        this.setUndecorated(true);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(3);
    }
}