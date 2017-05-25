import javax.swing.*;
import java.awt.*;

public class instrumento1GUI extends instrumentoGUI{
    // Seleção dos parametros das unidades-h ( ganho, h, lambda ) + ganho total
    instrumento1GUI(){
        Color corBG = new Color(230, 240, 255);
        
        unidadeHPanel p1b = new unidadeHPanel( 1 );
        p1b.setBackground(corBG);
        p1b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        unidadeHPanel p2b = new unidadeHPanel( 2 );
        p2b.setBackground(corBG);
        p2b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        unidadeHPanel p3b = new unidadeHPanel( 3 );
        p3b.setBackground(corBG);
        p3b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        this.setBackground(corBG);
        
        this.add(p1b);
        this.add(p2b);
        this.add(p3b);
    }
    
    /*
        // inicializar os botões
        
        entradaUniH1.setEnabled(true);
        entradaUniH2.setEnabled(true);
        entradaUniH3.setEnabled(true);
        entradaFreq.setEnabled(true);

        Color corBG = new Color(230, 240, 255);
        JPanel p1 = new JPanel();
        p1.setBackground(corBG);
        JPanel p2 = new JPanel();
        p2.setBackground(corBG);
        JPanel p3 = new JPanel();
        p3.setBackground(corBG);
        JPanel p4 = new JPanel();
        p4.setBackground(corBG);

        // fazer os ActionListeners para os botões
        entradaUniH1.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    teste1.tocar();
                }
            }
        );
        
        entradaUniH2.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    teste2.tocar();
                }
            }
        );
        
        entradaUniH3.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    
                }
            }
        );
        
        entradaFreq.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    
                }
            }
        );

        p1.add( MOSTRADORUniH1 );
        p1.add( entradaUniH1 );
        
        p2.add( MOSTRADORUniH2 );
        p2.add( entradaUniH2 );
        
        p3.add( MOSTRADORUniH3 );
        p3.add( entradaUniH3 );
        
        p4.add( MOSTRADORFreq );
        p4.add( entradaFreq );
        
        
        unidadeHPanel p1b = new unidadeHPanel( 1 );
        p1b.setBackground(corBG);
        p1b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        unidadeHPanel p2b = new unidadeHPanel( 2 );
        p2b.setBackground(corBG);
        p2b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        unidadeHPanel p3b = new unidadeHPanel( 3 );
        p3b.setBackground(corBG);
        p3b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        JPanel p1c = new JPanel();
        p1c.setBackground(corBG);
        
        p1c.add(p1b);
        p1c.add(p2b);
        p1c.add(p3b);
    */
}
