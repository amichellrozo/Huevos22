/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevos22;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author michi
 */
public class Vista_ventas extends JFrame {

    JPanel Panel1, Panel2;
    JLabel Titulo, LProduto, LCantidad, Lprecio, Lcliente;
    JTextField Tcantidad, Tprecio;
    JButton CerrarB, MinimizarB, BCrear, BEliminar, CrearP, volver, ListaB, Mostrar, ActualizarC, BuscarP;
    ImageIcon Cerrar, Minimizar, ICrear, IEliminar, VolverI, ListaI, imagen;
    JSeparator JS1, JS2, JS3, JS4;
    JTable tablav;
    JScrollPane panel;
    Border thickBorder = new LineBorder(Color.white, 2);
    JComboBox Opciones, Cproductos, Cfecha, Cclientee, Cnproducto, Ccliente;
    String Titulos[] = {"Nombre", "Apellido", "Edad"};
    Font fuente1 = new Font("Microsoft JhengHei Light", Font.PLAIN, 50);
    Font fuente2 = new Font("Microsoft JhengHei Light", Font.PLAIN, 18);
    Font fuente3 = new Font("Microsoft JhengHei Light", Font.PLAIN, 15);
    Color color1 = new Color(110, 197, 184);
    Color color2 = new Color(220, 91, 5);

    Vista_ventas() {
        setTitle("Clientes");
        setSize(1250, 720);
        setLayout(null);

        Panel1 = new JPanel();
        Panel1.setLayout(null);
        Panel1.setBackground(Color.WHITE);
        Panel1.setBounds(800, 0, 550, 720);

        Panel2 = new JPanel();
        Panel2.setLayout(null);
        Panel2.setBackground(color1);
        Panel2.setBounds(0, 0, 800, 720);

        Titulo = new JLabel("VENTAS");
        Titulo.setFont(fuente1);
        Titulo.setForeground(color2);
        Titulo.setBounds(100, 50, 350, 45);

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

        BCrear = new JButton(Cerrar);
        BCrear.setContentAreaFilled(false);
        BCrear.setBorderPainted(false);
        ICrear = new ImageIcon("user.png");
        BCrear.setToolTipText("ESTA OPCIÓN PERMITE CREAR UN CLIENTES");
        ImageIcon p = new ImageIcon(ICrear.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
        BCrear.setIcon(p);
        BCrear.setBounds(130, 30, 80, 80);

        BEliminar = new JButton(Cerrar);
        BEliminar.setContentAreaFilled(false);
        BEliminar.setBorderPainted(false);
        IEliminar = new ImageIcon("eliminar.png");
        BEliminar.setToolTipText("ESTA OPCIÓN PERMITE ELIMINAR UN CLIENTES");
        ImageIcon pf = new ImageIcon(IEliminar.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
        BEliminar.setIcon(pf);
        BEliminar.setBounds(370, 25, 80, 80);

        ListaB = new JButton(Cerrar);
        ListaB.setContentAreaFilled(false);
        ListaB.setBorderPainted(false);
        ListaI = new ImageIcon("lista.png");
        ListaB.setToolTipText("ESTA OPCIÓN PERMITE LISTAR TODOS LOS CLIENTES");
        ImageIcon pfee = new ImageIcon(ListaI.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
        ListaB.setIcon(pfee);
        ListaB.setBounds(590, 25, 80, 80);

        LProduto = new JLabel("Producto:");
        LProduto.setBounds(50, 160, 170, 50);
        LProduto.setFont(fuente2);
        LProduto.setForeground(color2);
        
        Cproductos = new JComboBox();
        Cproductos.setBackground(color1);
        Cproductos.setOpaque(false);
        Cproductos.setFont(fuente2);
        Cproductos.setBorder(new LineBorder(Color.white));
        Cproductos.setForeground(color2);
        Cproductos.setBounds(50, 200, 200, 50);

        LCantidad = new JLabel("Cantidad:");
        LCantidad.setBounds(50, 260, 170, 50);
        LCantidad.setFont(fuente2);
        LCantidad.setForeground(color2);

        Tcantidad = new JTextField("");
        Tcantidad.setBounds(50, 300, 190, 27);
        Tcantidad.setFont(fuente2);
        Tcantidad.setForeground(color2);
        Tcantidad.setBorder(thickBorder);
        
        JS2 = new JSeparator(JSeparator.HORIZONTAL);
        JS2.setForeground(color2);
        JS2.setBounds(50, 327, 190, 30);
        Panel1.add(JS2);

        Lprecio = new JLabel("Total:");
        Lprecio.setBounds(50, 360, 170, 50);
        Lprecio.setFont(fuente2);
        Lprecio.setForeground(color2);

        Tprecio = new JTextField("");
        Tprecio.setBounds(50, 400, 190, 27);
        Tprecio.setFont(fuente2);
        Tprecio.setForeground(color2);
        Tprecio.setBorder(thickBorder);
        
        JS1 = new JSeparator(JSeparator.HORIZONTAL);
        JS1.setForeground(color2);
        JS1.setBounds(50, 427, 190, 30);
        Panel1.add(JS1);

        Lcliente = new JLabel("Cliente:");
        Lcliente.setBounds(50, 460, 170, 50);
        Lcliente.setFont(fuente2);
        Lcliente.setForeground(color2);

        Mostrar = new JButton("MOSTRAR TODO");
        Mostrar.setToolTipText("ESTA OPCIÓN LISTA LOS PROVEEDORES");
        Mostrar.setForeground(color2);
        Mostrar.setBackground(Color.white);
        Mostrar.setFont(fuente2);
        Mostrar.setBounds(300, 670, 180, 45);
        Panel2.add(Mostrar);

        
         tablav = new JTable();
        tablav = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        panel = new JScrollPane(tablav);// debe ir aqui pare evitar errores
        tablav.getTableHeader().setReorderingAllowed(false);//Orden de las columnas
        tablav.getTableHeader().setResizingAllowed(false);// orden
        tablav.setFocusable(false);//
        tablav.setBackground(new Color(110, 197, 184));
        panel.getViewport().setBackground(color1);
        panel.setBorder(new LineBorder(color1));
        tablav.setBorder(new LineBorder(color1));
        tablav.setForeground(Color.white);
        panel.setBounds(60, 170, 660, 500);

        Panel1.add(Titulo);
        Panel1.add(LProduto);
        Panel1.add(LCantidad);
        Panel1.add(Lprecio);
        Panel1.add(Lcliente);
        Panel2.add(panel);

        Panel2.add(ListaB);
        Panel1.add(CerrarB);
        Panel1.add(MinimizarB);
        Panel2.add(BCrear);
        Panel2.add(BEliminar);

        this.add(Panel2);
        this.add(Panel1);

        // this.setUndecorated(true);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(3);

    }

}
