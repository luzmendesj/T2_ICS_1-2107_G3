import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.text.DecimalFormat;

public class entradaFloatPanel extends JPanel{
    String rotulo;
    int min;
    int max;
    int valInic;
    int escala;
    
    final DecimalFormat df;
    final deslisadorFloat slider;
    final JTextField text;
    
    entradaFloatPanel( String rotulo, int min, int max, int valInic, int escala ){
        super();
        
        // inicia variáveis
        this.rotulo = rotulo;
        this.min = min;
        this.max = max;
        this.valInic = valInic;
        this.escala = escala;
        
        //inicia componentes da interface
        JLabel r1 = util.constroiRotulo( rotulo );
        //deslisadorFloat desl = new deslisadorFloat( min, max, intervalo, escala );
        
        final JPanel p = new JPanel();
        p.setLayout( new GridLayout(2,0) );
        
        df = new DecimalFormat("0.###");
        text = new JTextField(20);
        text.setText( df.format( valInic/(escala * 1.0) ) );
        slider = new deslisadorFloat( min, max, valInic, escala );
        
        /*
        slider.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                // Event
                text.setText( df.format( slider.getValorEscala() ) );
            }
        });
        
        text.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    String typed = text.getText();
                    slider.setValue(0);
                    if(!typed.matches("\\d+(\\.\\d*)?")) {
                        return;
                    }
                    float value = Float.parseFloat(typed) * slider.escala;
                    slider.setValue((int)value);
                }
            }
        );
        */
        
        p.add(text);
        p.add(slider);
        
        this.add(r1);
        this.add(p);
    }
    
    /*
    final DecimalFormat df;
    final deslisadorFloat slider;
    final JTextField text;
    */
    
    DecimalFormat getDF(){
        return df;
    }
    deslisadorFloat getSlider(){
        return slider;
    }
    JTextField getText(){
        return text;
    }
}
