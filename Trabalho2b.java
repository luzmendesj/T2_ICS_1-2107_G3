import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

import java.text.DecimalFormat;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Trabalho2b extends JFrame {

    private String diretorio = System.getProperty("user.dir");
    private Container painel = getContentPane();

    private ImageIcon logo = null;
    
    // Estilo "Metal", "System", "Motif" ou "GTK"
    final static String ESTILO = "Metal";
    // Para o estilo "Metal", duas opções de tema: "DefaultMetal" ou "Ocean"
    final static String TEMA = "Ocean";
    
    final JButton entradaUniH1          = constroiBotao("Unidade-H 1");
    final JButton entradaUniH2          = constroiBotao("Unidade-H 2");
    final JButton entradaUniH3          = constroiBotao("Unidade-H 3");
    final JButton entradaFreq           = constroiBotao("Frequencia");
    
    final JLabel MOSTRADORUniH1         = constroiRotulo("Unidade-H 1: ");
    final JLabel MOSTRADORUniH2         = constroiRotulo("Unidade-H 2: ");
    final JLabel MOSTRADORUniH3         = constroiRotulo("Unidade-H 3: ");
    final JLabel MOSTRADORFreq          = constroiRotulo("Frequencia: ");
    
    instrumento1 teste1 = new instrumento1();
    instrumento2 teste2 = new instrumento2();
    
    public static void main(String[] args) {
        Trabalho2b gui = new Trabalho2b();
    }
    
    private Trabalho2b() {
        // Aplica o estilo definido no código
        iniciaEstilo();
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Cria janela
        JFrame frame = new JFrame("Trabalho 1 - Introdução a Computação Sônica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component componentes = criaComponentes();
        frame.getContentPane().add(componentes, BorderLayout.CENTER);

        /*
        Component sliderVolume = criaComponentes();
        frame.getContentPane().add(sliderVolume, BorderLayout.EAST);
        */

        logo = new javax.swing.ImageIcon(getClass().getResource("logo.png"));
        frame.setIconImage(logo.getImage());

        //Display the window.
        frame.pack();
        frame.setSize(1100, 1000);
        frame.setVisible(true);
    }
    
    public Component criaComponentes() {
        
        JPanel painel = new JPanel(new GridLayout(3, 0));

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimensao = tk.getScreenSize();

        logo = new javax.swing.ImageIcon(getClass().getResource("logo.png"));
        setIconImage(logo.getImage());

        int posX = (dimensao.width / 2) - (this.getWidth() / 2);
        int posY = (dimensao.height / 2) - (this.getHeight() / 2);

        this.setLocation(posX, posY);
        this.setResizable(true);
        
        // ESCOLHER MÚSICA
        // escolhaMusicaGUI escM = new escolhaMusicaGUI();
        
        // INSTRUMENTO A
        instrumento1GUI inst1 = new instrumento1GUI();
        
        // INSTRUMENTO B
        instrumento2GUI inst2 = new instrumento2GUI();
        
        // PAINEL
        //painel.add(escM);
        painel.add(inst1);
        painel.add(inst2);
        
        return painel;
    }
    
    public JLabel constroiRotulo(String texto) {
        JLabel rotulo = new JLabel( texto );
        Color corTxt = new Color(60, 30, 100);
        
        rotulo.setFont( new Font("Serif", Font.PLAIN, 18) );
        rotulo.setForeground(corTxt);
        
        return rotulo;
    }
    
    public JButton constroiBotao(String legenda) {
    // usa 9 como o tamanho de fonte default.
        return constroiBotao(legenda, 9);
    }

    public JButton constroiBotao(String legenda, float tamanho) {
        JButton botao = new JButton(legenda);
        botao.setMargin(new Insets(3, 3, 3, 3));
        botao.setFocusable(false);
        botao.setFont(botao.getFont().deriveFont(Font.PLAIN));
        botao.setFont(botao.getFont().deriveFont(tamanho));
        return botao;
    }
    
    private static void iniciaEstilo() {
        String strEstilo = null;

        if (ESTILO != null) {
            if (ESTILO.equals("Metal")) {
              // strEstilo = UIManager.getCrossPlatformLookAndFeelClassName();
              //  an alternative way to set the Metal L&F is to replace the
              // previous line with:
              strEstilo = "javax.swing.plaf.metal.MetalLookAndFeel";
            }

            else if (ESTILO.equals("System")) {
                strEstilo = UIManager.getSystemLookAndFeelClassName();
            }

            else if (ESTILO.equals("Motif")) {
                strEstilo = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            }

            else if (ESTILO.equals("GTK")) {
                strEstilo = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            }

            else {
                System.err.println("Unexpected value of ESTILO specified: "
                                   + ESTILO);
                strEstilo = UIManager.getCrossPlatformLookAndFeelClassName();
            }

            try {
                UIManager.setLookAndFeel(strEstilo);

                // If L&F = "Metal", set the theme
                if (ESTILO.equals("Metal")) {
                  if (TEMA.equals("DefaultMetal"))
                     MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
                  else //if (TEMA.equals("Ocean"))
                     MetalLookAndFeel.setCurrentTheme(new OceanTheme());

                  UIManager.setLookAndFeel(new MetalLookAndFeel());
                }
            }
            catch (ClassNotFoundException e) {
                System.err.println("Couldn't find class for specified look and feel:"
                                   + strEstilo);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            }

            catch (UnsupportedLookAndFeelException e) {
                System.err.println("Can't use the specified look and feel ("
                                   + strEstilo
                                   + ") on this platform.");
                System.err.println("Using the default look and feel.");
            }

            catch (Exception e) {
                System.err.println("Couldn't get specified look and feel ("
                                   + strEstilo
                                   + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }
}
