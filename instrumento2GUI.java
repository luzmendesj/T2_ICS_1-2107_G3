import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;

public class instrumento2GUI extends instrumentoGUI{
    // Seleção das duas frequencias de corte, freqCorte1 e freqCorte2
    instrumento2GUI(){
        
        /*
        JPanel p1 = new JPanel();
        JLabel MOSTRADORFreq1 = util.constroiRotulo("Frequência 1:  ");
        JTextField entFreq1 = new JTextField( 3 );
        
        p1.add(MOSTRADORFreq1);
        p1.add(entFreq1);
        */
        JPanel p = new JPanel();
        
        entradaFloatPanel freq1 = new entradaFloatPanel( "Frequencia 1: ", 0, 100, 0, 1000 );
        entradaFloatPanel freq2 = new entradaFloatPanel( "Frequencia 2: ", 0, 100, 0, 1000 );
        
        JPanel p3 = new JPanel();
        JButton botaoTOCAR = constroiBotao("Tocar");
        JPanel invisivel = new JPanel();
        invisivel.setOpaque(false);
        
        p3.add(botaoTOCAR);
        p3.add(invisivel);
        
        p.add( freq1 );
        p.add( freq2 );
        p.add( p3 );
        
        this.setLayout( new BorderLayout() );
        this.add( invisivel, BorderLayout.NORTH );
        this.add( p, BorderLayout.CENTER );
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
    }
}
