import javax.swing.*;
import java.awt.GridLayout;

public class instrumento1GUI extends instrumentoGUI{
    // Seleção dos parametros das unidades-h ( ganho, h, lambda ) + ganho total
    instrumento1GUI(){
        this.setLayout( new GridLayout(2,0) );
        
        JLabel MOSTRADORFreq = constroiRotulo("TESTE 1");
        JButton entradaFreq = constroiBotao("Frequencia");
        this.add( MOSTRADORFreq );
        this.add( entradaFreq );
    }
}
