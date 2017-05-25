import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class instrumento1GUI extends instrumentoGUI{
    // Seleção dos parametros das unidades-h ( ganho, h, lambda ) + ganho total
    private final instrumento1 instru1;
    
    instrumento1GUI(){
        this.setLayout( new BorderLayout() );
        
        instru1 = new instrumento1();
        
        unidadeHPanel p1b = new unidadeHPanel( 1, instru1 );
        p1b.setBackground(util.corTitulo);
        p1b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        unidadeHPanel p2b = new unidadeHPanel( 2, instru1 );
        p2b.setBackground(util.corTitulo);
        p2b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        unidadeHPanel p3b = new unidadeHPanel( 3, instru1 );
        p3b.setBackground(util.corTitulo);
        p3b.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        JPanel p1 = new JPanel();
        p1.setBackground(util.corBG);
        
        p1.add(p1b);
        p1.add(p2b);
        p1.add(p3b);
        
        JPanel invisivel = new JPanel();
        invisivel.setOpaque(false);
        
        JButton botaoTocar = constroiBotao( "\u25b6", 20 );
        botaoTocar.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    instru1.tocar();
                }
            }
        );
        
        JPanel g = new JPanel( new GridLayout(2,0) );
        entradaFloatPanel ganhoAmpl = p1b.ganhoFloatPanel( "Ganho (Amplitude): ", 4, instru1 );
        ganhoAmpl.setBackground(util.corBG);
        entradaFloatPanel ganhoTotal = p1b.ganhoFloatPanel( "Ganho (Total): ", 0, instru1 );
        ganhoTotal.setBackground(util.corBG);
        g.add( ganhoAmpl );
        g.add( ganhoTotal );
        
        JPanel p2 = new JPanel(  );
        p2.add( g );
        p2.add( botaoTocar );
        p2.setBackground(util.corBG);
        
        this.add( p1, BorderLayout.NORTH );
        this.add( p2, BorderLayout.CENTER );
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
    }
    
    instrumento1 getInstrumento1(){
        return instru1;
    }
}
