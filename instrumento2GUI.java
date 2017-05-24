import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class instrumento2GUI extends instrumentoGUI{
    // Seleção das duas frequencias de corte, freqCorte1 e freqCorte2
    instrumento2GUI(){
        this.setLayout( new GridLayout(3,0) );
        
        JPanel p1 = new JPanel();
        JLabel MOSTRADORFreq1 = constroiRotulo("Frequência 1:  ");
        JTextField entFreq1 = new JTextField( 3 );
        
        p1.add(MOSTRADORFreq1);
        p1.add(entFreq1);
        
        JPanel p2 = new JPanel();
        JLabel MOSTRADORFreq2 = constroiRotulo("Frequência 2:  ");
        JTextField entFreq2 = new JTextField( 3 );
        
        p2.add(MOSTRADORFreq2);
        p2.add(entFreq2);
        
        JButton botaoTOCAR = constroiBotao("Tocar");
        
        this.add( p1 );
        this.add( p2 );
        this.add( botaoTOCAR );
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
    }
}
