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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author michi
 */
public class Vista_menu extends javax.swing.JFrame {

    JPanel JPmenu;
    JLabel JLClientes, JLproveedores, JLcompras, JLventas,
            JLinventario, JLinformev, JLinformec, JLcerrarsesion, JLmenu, JLfondoprincipal;
    ImageIcon Icliente, Iproveedores, Icompras, Iventas,
            Iinventario, Iinformev, Iinformec, Icerrar, Iminimizar, Icerrarsesion, IMprincipal,VolverI;
    JButton JBclientes, JBproveedores, JBcompras, JBventas,
            JBinventario, JBinformev, JBinformec, JBcerrar, JBminimizar, JBcerrarsesion,volver;
    Font fuentetitulo = new Font("Microsoft JhengHei Light", Font.BOLD, 50);
    Font fuentenormal = new Font("Microsoft JhengHei Light", Font.BOLD, 20);
    Font fuentebotones = new Font("Microsoft JhengHei Light", Font.CENTER_BASELINE, 25);
    Color Azul = new Color(110, 197, 184);
    Color Naranja = new Color(220, 91, 5);

    Vista_menu() {
        setTitle("MENU");
        setSize(1250, 720);
        setLayout(null);
        ImageIcon favicon = new ImageIcon("gallina.png");//img pola
        Image iconog = favicon.getImage();// la polita
        this.setIconImage(iconog);

        JLfondoprincipal = new JLabel();
        JLfondoprincipal.setBackground(Azul);
        IMprincipal = new ImageIcon("hue.jpg");
        ImageIcon iconoEscala = new ImageIcon(IMprincipal.getImage().getScaledInstance(1250, 720, java.awt.Image.SCALE_DEFAULT));
        JLfondoprincipal.setIcon(iconoEscala);

        JLfondoprincipal.setBounds(0, 0, 1250, 720);
        JPmenu = new JPanel();
        JPmenu.setBackground(new Color(118,139,125));
        JPmenu.setBorder(new LineBorder(Azul));

        //labels
        JLcompras = new JLabel("Compras");
        JLcompras.setForeground(Azul);
        JLcompras.setFont(fuentenormal);

        JBcompras = new JButton(Icompras);
        JBcompras.setContentAreaFilled(false);
        JBcompras.setBorderPainted(false);
        JBcompras.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Icompras = new ImageIcon("compras.png");
        ImageIcon a = new ImageIcon(Icompras.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBcompras.setIcon(a);

        JLventas = new JLabel("Ventas");
        JLventas.setForeground(Naranja);
        JLventas.setFont(fuentenormal);

        JBventas = new JButton(Iventas);
        JBventas.setContentAreaFilled(false);
        JBventas.setBorderPainted(false);
        JBventas.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Iventas = new ImageIcon("ventas.png");
        ImageIcon b = new ImageIcon(Iventas.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBventas.setIcon(b);

        JLClientes = new JLabel("Clientes");
        JLClientes.setForeground(Azul);
        JLClientes.setFont(fuentenormal);

        JBclientes = new JButton(Icliente);
        JBclientes.setContentAreaFilled(false);
        JBclientes.setBorderPainted(false);
        JBclientes.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Icliente = new ImageIcon("clientes.png");
        ImageIcon c = new ImageIcon(Icliente.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBclientes.setIcon(c);

        JLproveedores = new JLabel("Proveedores");
        JLproveedores.setForeground(Naranja);
        JLproveedores.setFont(fuentenormal);

        JBproveedores = new JButton(Iproveedores);
        JBproveedores.setContentAreaFilled(false);
        JBproveedores.setBorderPainted(false);
        JBproveedores.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Iproveedores = new ImageIcon("proveedor.png");
        ImageIcon d = new ImageIcon(Iproveedores.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBproveedores.setIcon(d);

        JLinventario = new JLabel("Inventario");
        JLinventario.setForeground(Azul);
        JLinventario.setFont(fuentenormal);

        JBinventario = new JButton(Iinventario);
        JBinventario.setContentAreaFilled(false);
        JBinventario.setBorderPainted(false);
        JBinventario.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Iinventario = new ImageIcon("inventario.png");
        ImageIcon f = new ImageIcon(Iinventario.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBinventario.setIcon(f);

        JLinformev = new JLabel("Informe Ventas");
        JLinformev.setForeground(Azul);
        JLinformev.setFont(fuentenormal);

        JBinformev = new JButton(Iinformev);
        JBinformev.setContentAreaFilled(false);
        JBinformev.setBorderPainted(false);
        JBinformev.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Iinformev = new ImageIcon("informeventas.png");
        ImageIcon g = new ImageIcon(Iinformev.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBinformev.setIcon(g);

        JLinformec = new JLabel("Informe Compras");
        JLinformec.setForeground(Naranja);
        JLinformec.setFont(fuentenormal);

        JBinformec = new JButton(Iinformec);
        JBinformec.setContentAreaFilled(false);
        JBinformec.setBorderPainted(false);
        JBinformec.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Iinformec = new ImageIcon("informecompras.png");
        ImageIcon h = new ImageIcon(Iinformec.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBinformec.setIcon(h);

        JLcerrarsesion = new JLabel("Cerrar sesión");
        JLcerrarsesion.setForeground(Azul);
        JLcerrarsesion.setFont(fuentenormal);

        JBcerrarsesion = new JButton(Icerrarsesion);
        JBcerrarsesion.setContentAreaFilled(false);
        JBcerrarsesion.setBorderPainted(false);
        JBcerrarsesion.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Icerrarsesion = new ImageIcon("close.png");
        ImageIcon i = new ImageIcon(Icerrarsesion.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
        JBcerrarsesion.setIcon(i);

        JBminimizar = new JButton(Iminimizar);
        JBminimizar.setContentAreaFilled(false);
        JBminimizar.setBorderPainted(false);
        JBminimizar.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Iminimizar = new ImageIcon("minimizarn.png");
        ImageIcon j = new ImageIcon(Iminimizar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        JBminimizar.setIcon(j);

        JBcerrar = new JButton(Icerrar);
        JBcerrar.setContentAreaFilled(false);
        JBcerrar.setBorderPainted(false);
        JBcerrar.setToolTipText("ESTA OPCION MINIMIZA EL PROGRAMA");
        Icerrar = new ImageIcon("cerrarn.png");
        ImageIcon k = new ImageIcon(Icerrar.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        JBcerrar.setIcon(k);
        JPmenu.setLayout(null);
        
                volver = new JButton(VolverI);
        volver.setContentAreaFilled(false);
        volver.setBorderPainted(false);
        volver.setToolTipText("ESTA OPCION NOS REGRESA AL MENÚ");
        VolverI = new ImageIcon("volver.png");
        ImageIcon de = new ImageIcon(VolverI.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_DEFAULT));
        volver.setIcon(de);
        volver.setBounds(1100, 670, 35, 35);

        JLmenu = new JLabel("MENÚ");
        JLmenu.setForeground(Azul);
        JLmenu.setFont(fuentetitulo);

        JPmenu.setBounds(0, 0, 1250, 720);
        JLcompras.setBounds(140, 300, 150, 35);
        JLinventario.setBounds(600, 300, 200, 35);
        JLventas.setBounds(1050, 300, 150, 35);

        JLinformec.setBounds(100, 550, 350, 35);
        JLClientes.setBounds(450, 550, 150, 35);
        JLproveedores.setBounds(720, 550, 200, 35);
        JLinformev.setBounds(1000, 550, 350, 35);
        JLcerrarsesion.setBounds(30, 750, 300, 35);

        JBcompras.setBounds(140, 180, 100, 100);
        JBinventario.setBounds(600, 180, 100, 100);
        JBventas.setBounds(1020, 180, 100, 100);

        JBinformec.setBounds(140, 430, 100, 100);
        JBclientes.setBounds(440, 430, 100, 100);
        JBproveedores.setBounds(730, 430, 100, 100);
        JBinformev.setBounds(1040, 430, 100, 100);
        JLmenu.setBounds(550, 10, 250, 100);

        JBminimizar.setBounds(1140, 10, 35, 35);
        JBcerrar.setBounds(1190, 10, 35, 35);
        JBcerrarsesion.setBounds(0, 0, 100, 100);
        JPmenu.add(JLcompras);
        JPmenu.add(JLventas);
        JPmenu.add(JLinventario);

        JPmenu.add(JLinformec);
        JPmenu.add(JLinformev);
        JPmenu.add(JLClientes);
        JPmenu.add(JLproveedores);

        JPmenu.add(JBcompras);
        JPmenu.add(JBventas);
        JPmenu.add(JBinventario);

        JPmenu.add(JBclientes);
        JPmenu.add(JLcerrarsesion);
        JPmenu.add(JBclientes);
        JPmenu.add(JBproveedores);

        JPmenu.add(JBinformev);
        JPmenu.add(JBinformec);
        JPmenu.add(JLmenu);
               JPmenu.add(volver);

        JPmenu.add(JBminimizar);
        JPmenu.add(JBcerrar);
        JPmenu.add(JBcerrar);
        JPmenu.add(JLfondoprincipal);

//        JPmenu.add(JBcerrarsesion);
        this.add(JPmenu);

        this.setUndecorated(true);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Azul);
        setVisible(true);

        setDefaultCloseOperation(3);
    }
}
