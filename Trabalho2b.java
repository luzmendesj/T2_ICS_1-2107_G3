import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.plaf.metal.*;

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
        
        JPanel imgPanel = new ImgPanel();
        
        imgPanel.add(componentes, BorderLayout.CENTER);
        frame.setContentPane(imgPanel);
        logo = new javax.swing.ImageIcon(getClass().getResource("logo.png"));
        frame.setIconImage(logo.getImage());

        //Display the window.
        frame.pack();
        frame.setSize(1100, 740);
        frame.setVisible(true);
    }
    
    class ImgPanel extends JPanel {
    	Image img = new ImageIcon(getClass().getResource("background.png")).getImage();
    	
    	public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, 1100, 720, this);
        }
    }
    
    public Component criaComponentes() {
        JPanel painel = new JPanel();
        painel.setLayout( new BoxLayout( painel, BoxLayout.Y_AXIS ) );
        // JPanel painel = new JPanel(new GridLayout(3, 0));

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimensao = tk.getScreenSize();

        logo = new javax.swing.ImageIcon(getClass().getResource("logo.png"));
        setIconImage(logo.getImage());

        int posX = (dimensao.width / 2) - (this.getWidth() / 2);
        int posY = (dimensao.height / 2) - (this.getHeight() / 2);

        this.setLocation(posX, posY);
        this.setResizable(true);
        
        // INSTRUMENTO A
        instrumento1GUI inst1 = new instrumento1GUI();
        
        // INSTRUMENTO B
        instrumento2GUI inst2 = new instrumento2GUI();
        
        // ESCOLHER MÚSICA
        escolheMelodia escM = new escolheMelodia( inst1.getInstrumento1(), inst2.getInstrumento2() );
        
        // PAINEL
        painel.add(escM);
        painel.add(inst1);
        painel.add(inst2);
        
        return painel;
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
