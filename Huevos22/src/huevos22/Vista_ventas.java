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
    JLabel Titulo, LProduto, LCantidad, Lprecio, Lcliente, Lunid, Lpeso, Logo, Lidv;
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
    Color blanco = new Color(255, 255, 255);
    Color negro = new Color(0, 0, 0);

    Vista_ventas() {
        setTitle("Ventas");
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

        imagen = new ImageIcon("Logo1.png");
        Logo = new JLabel(imagen);
        Logo.setBounds(20, 20, 410, 680);
        Panel1.add(Logo);

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
        BCrear.setToolTipText("ESTA OPCIÓN PERMITE CREAR UNA VENTA");
        ImageIcon p = new ImageIcon(ICrear.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
        BCrear.setIcon(p);
        BCrear.setBounds(120, 30, 80, 80);

        BEliminar = new JButton(Cerrar);
        BEliminar.setContentAreaFilled(false);
        BEliminar.setBorderPainted(false);
        IEliminar = new ImageIcon("eliminar.png");
        BEliminar.setToolTipText("ESTA OPCIÓN PERMITE ELIMINAR UNA VENTA");
        ImageIcon pf = new ImageIcon(IEliminar.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
        BEliminar.setIcon(pf);
        BEliminar.setBounds(370, 25, 80, 80);

        ListaB = new JButton(Cerrar);
        ListaB.setContentAreaFilled(false);
        ListaB.setBorderPainted(false);
        ListaI = new ImageIcon("lista.png");
        ListaB.setToolTipText("ESTA OPCIÓN PERMITE LISTAR TODOS LAS VENTAS");
        ImageIcon pfee = new ImageIcon(ListaI.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_DEFAULT));
        ListaB.setIcon(pfee);
        ListaB.setBounds(590, 25, 80, 80);

        CrearP = new JButton("Agregar venta");
        CrearP.setBounds(140, 590, 170, 50);
        CrearP.setBackground(color1);
        CrearP.setForeground(negro);
        CrearP.setFont(fuente2);
        Panel1.add(CrearP);

        LProduto = new JLabel("Producto:");
        LProduto.setBounds(80, 160, 170, 50);
        LProduto.setFont(fuente2);
        LProduto.setForeground(color2);

        Cproductos = new JComboBox();
        Cproductos.setBackground(blanco);
        Cproductos.setOpaque(false);
        Cproductos.setFont(fuente2);
        Cproductos.setBorder(new LineBorder(color1));
        Cproductos.setForeground(color1);
        Cproductos.setBounds(80, 220, 200, 50);
        Panel1.add(Cproductos);

        LCantidad = new JLabel("Cantidad:");
        LCantidad.setBounds(80, 260, 170, 50);
        LCantidad.setFont(fuente2);
        LCantidad.setForeground(color2);

        Lunid = new JLabel("Uds");
        Lunid.setBounds(280, 310, 50, 50);
        Lunid.setFont(fuente2);
        Lunid.setForeground(color2);
        Panel1.add(Lunid);

        Tcantidad = new JTextField("");
        Tcantidad.setBounds(80, 320, 190, 27);
        Tcantidad.setFont(fuente2);
        Tcantidad.setForeground(color2);
        Tcantidad.setBorder(thickBorder);
        Panel1.add(Tcantidad);

        JS2 = new JSeparator(JSeparator.HORIZONTAL);
        JS2.setForeground(color2);
        JS2.setBounds(80, 347, 190, 30);
        Panel1.add(JS2);

        Lprecio = new JLabel("Precio Por Unidad:");
        Lprecio.setBounds(80, 360, 170, 50);
        Lprecio.setFont(fuente2);
        Lprecio.setForeground(color2);

        Tprecio = new JTextField("");
        Tprecio.setBounds(90, 420, 180, 27);
        Tprecio.setFont(fuente2);
        Tprecio.setForeground(color2);
        Tprecio.setBorder(thickBorder);
        Panel1.add(Tprecio);

        Lpeso = new JLabel("$");
        Lpeso.setBounds(80, 410, 50, 50);
        Lpeso.setFont(fuente2);
        Lpeso.setForeground(color2);
        Panel1.add(Lpeso);

        Lidv = new JLabel("$");
        Lidv.setBounds(80, 410, 50, 50);
        Lidv.setFont(fuente2);
        Lidv.setForeground(color2);
        Panel1.add(Lidv);

        JS1 = new JSeparator(JSeparator.HORIZONTAL);
        JS1.setForeground(color2);
        JS1.setBounds(90, 447, 190, 30);
        Panel1.add(JS1);

        Lcliente = new JLabel("Cliente:");
        Lcliente.setBounds(80, 460, 170, 50);
        Lcliente.setFont(fuente2);
        Lcliente.setForeground(color2);

        Ccliente = new JComboBox();
        Ccliente.setBackground(blanco);
        Ccliente.setOpaque(false);
        Ccliente.setFont(fuente2);
        Ccliente.setBorder(new LineBorder(color1));
        Ccliente.setForeground(color2);
        Ccliente.setBounds(80, 520, 200, 50);
        Panel1.add(Ccliente);

        Mostrar = new JButton("MOSTRAR TODO");
        Mostrar.setToolTipText("ESTA OPCIÓN LISTA LAS VENTAS");
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

        
         String opcPP[] = {"Seleccionar Opción", "Producto", "Cliente","Fecha venta"};
        Opciones = new JComboBox(opcPP);
        Opciones.setBackground(blanco);
        Opciones.setOpaque(false);
        Opciones.setFont(fuente2);
        Opciones.setBorder(new LineBorder(color1));
        Opciones.setForeground(color2);
        Opciones.setBounds(100, 180, 200, 50);
        Panel1.add(Opciones);

        Cnproducto = new JComboBox();
        Cnproducto.setBackground(blanco);
        Cnproducto.setOpaque(false);
        Cnproducto.setFont(fuente2);
        Cnproducto.setBorder(new LineBorder(color1));
        Cnproducto.setForeground(color2);
        Cnproducto.setBounds(100, 280, 200, 50);
        Panel1.add(Cnproducto);

        Cclientee = new JComboBox();
        Cclientee.setBackground(blanco);
        Cclientee.setOpaque(false);
        Cclientee.setFont(fuente2);
        Cclientee.setBorder(new LineBorder(color1));
        Cclientee.setForeground(color2);
        Cclientee.setBounds(100, 380, 200, 50);
        Panel1.add(Cclientee);

        Cfecha = new JComboBox();
        Cfecha.setBackground(blanco);
        Cfecha.setOpaque(false);
        Cfecha.setFont(fuente2);
        Cfecha.setBorder(new LineBorder(color1));
        Cfecha.setForeground(color1);
        Cfecha.setBounds(100, 480, 200, 50);
        Panel1.add(Cfecha);

        BuscarP = new JButton("Buscar Venta");
        BuscarP.setBounds(110, 580, 180, 50);
        BuscarP.setBackground(color1);
        BuscarP.setForeground(negro);
        BuscarP.setFont(fuente2);
        Panel1.add(BuscarP);
        
        volver = new JButton(Minimizar);
        volver.setContentAreaFilled(false);
        volver.setBorderPainted(false);
        volver.setToolTipText("ESTA OPCION NOS REGRESA AL MENÚ");
        VolverI = new ImageIcon("volver.png");
        ImageIcon de = new ImageIcon(VolverI.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        volver.setIcon(de);
        volver.setBounds(400, 670, 35, 35);
        Panel1.add(volver);

        Lidv.setVisible(false);
      
        LProduto.setVisible(false);
        LCantidad.setVisible(false);
        Lprecio.setVisible(false);
        Lcliente.setVisible(false);
        Lunid.setVisible(false);
        Lpeso.setVisible(false);
        Tcantidad.setVisible(false);
        Tprecio.setVisible(false);
        Cproductos.setVisible(false);
        CrearP.setVisible(false);
        Ccliente.setVisible(false);
        JS1.setVisible(false);
        JS2.setVisible(false);
        Opciones.setVisible(false);
        CrearP.setVisible(false);
        Cfecha.setVisible(false);
        Cclientee.setVisible(false);
        Cnproducto.setVisible(false);
        BuscarP.setVisible(false);
        
      
        

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

        this.setUndecorated(true);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(3);

    }

}
