/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevos22;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author michi
 */
public class Vista_informe_ventas extends JFrame  {
     JPanel Panel1, Panel2;
    JLabel Titulo, Titulo1, Logo, fecha1, fecha2, ingresos, pesos, total;
    JTextField TPNombre;
    Font fuente1 = new Font("Microsoft JhengHei Light", Font.PLAIN, 50);
    
     Font fuentev = new Font("Microsoft JhengHei Light", Font.PLAIN, 40);
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
    JComboBox Opciones, Opciones1;
    
    Vista_informe_ventas(){ 
        setTitle("INGRESOS");
        setSize(1250, 720);
        setLayout(null);

        ImageIcon favicon = new ImageIcon("gallina.png");//img pola
        Image iconog = favicon.getImage();// la polita
        this.setIconImage(iconog);

        JPanel Panel1 = new JPanel();
        Panel1.setLayout(null);
        Panel1.setBackground(Color.WHITE);
        Panel1.setBounds(800, 0, 550, 720);

        JPanel Panel2 = new JPanel();
        Panel2.setLayout(null);
        Panel2.setBackground(color1);
        Panel2.setBounds(0, 0, 800, 720);

        JLabel Titulo = new JLabel("INFORME");
        Titulo.setFont(fuente1);
        Titulo.setForeground(color2);
        Titulo.setBounds(110, 50, 350, 45);

        JLabel Titulo1 = new JLabel("INGRESOS");
        Titulo1.setFont(fuente1);
        Titulo1.setForeground(color2);
        Titulo1.setBounds(100, 100, 600, 45);
        Panel1.add(Titulo1);

        ingresos = new JLabel("TOTAL VENTA :");
        ingresos.setFont(fuentev);
        ingresos.setForeground(color2);
        ingresos.setBounds(70, 600, 600, 45);
        Panel1.add(ingresos);

        pesos = new JLabel("$");
        pesos.setFont(fuentev);
        pesos.setForeground(color2);
        pesos.setBounds(80, 650, 40, 45);
        Panel1.add(pesos);
        
        total = new JLabel();
        total.setFont(fuentev);
        total.setForeground(color2);
        total.setBounds(120, 650, 250, 45);
        Panel1.add(total);
        
        ingresos.setVisible(false);
        pesos.setVisible(false);
        total.setVisible(false);

        JLabel fecha1 = new JLabel("Fecha Inicio :");
        fecha1.setFont(fuente2);
        fecha1.setForeground(color2);
        fecha1.setBounds(60, 50, 140, 45);
        Panel2.add(fecha1);

    
        Opciones = new JComboBox();
        Opciones.setBackground(Color.white);
        Opciones.setOpaque(false);
        Opciones.setFont(fuente2);
        Opciones.setBorder(new LineBorder(color1));
        Opciones.setForeground(color2);
        Opciones.setBounds(170, 50, 200, 50);
        Panel2.add(Opciones);

        JLabel fecha2 = new JLabel("Fecha Final :");
        fecha2.setFont(fuente2);
        fecha2.setForeground(color2);
        fecha2.setBounds(410, 50, 140, 45);
        Panel2.add(fecha2);

        Opciones1 = new JComboBox();
        Opciones1.setBackground(Color.white);
        Opciones1.setOpaque(false);
        Opciones1.setFont(fuente2);
        Opciones1.setBorder(new LineBorder(color1));
        Opciones1.setForeground(color2);
        Opciones1.setBounds(520, 50, 200, 50);
        Panel2.add(Opciones1);
        
        

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
        Logo.setBounds(20, 10, 410, 680);
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

        Mostrar = new JButton("OBTENER INGRESOS");
        Mostrar.setToolTipText("ESTA OPCIÓN LISTA LOS INGRESOS CON EL FILTRO DE FECHAS");
        Mostrar.setForeground(color2);
        Mostrar.setBackground(Color.white);
        Mostrar.setFont(fuente2);

        Mostrar.setBounds(280, 110, 220, 45);
        Panel2.add(Mostrar);
        Panel2.add(panel);
        Panel1.add(Logo);
        Panel1.add(volver);
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