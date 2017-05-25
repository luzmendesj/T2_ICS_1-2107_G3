import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.text.DecimalFormat;

public class instrumento2GUI extends instrumentoGUI{
    // Seleção das duas frequencias de corte, freqCorte1 e freqCorte2
    private final instrumento2 instru2;
    
    instrumento2GUI(){
        JPanel p = new JPanel();
        
        instru2 = new instrumento2();
        
        JPanel p1 = criaRuidoPanel( 1, 0, 10000, 0, 100 );
        
        JPanel p2 = criaRuidoPanel( 2, 0, 10000, 0, 1000 );
        
        JPanel p3 = new JPanel();
        JButton botaoTocar = constroiBotao( "\u25b6", 20 );
        botaoTocar.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    instru2.tocar();
                }
            }
        );
        
        JPanel invisivel = new JPanel();
        invisivel.setOpaque(false);
        
        p3.add(invisivel);
        p3.add(botaoTocar);
        p3.setBackground(util.corBG);
        
        p.add( p1 );
        p.add( p2 );
        p.setBackground(util.corBG);
        
        this.setLayout( new BorderLayout() );
        this.add( p, BorderLayout.CENTER );
        this.add( p3, BorderLayout.SOUTH );
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
    }
    
    JPanel criaRuidoPanel( int num, int min, int max, int val, int escala ){
        JPanel p1 = new JPanel( new GridLayout(2,0) );
        JLabel rot1 = util.constroiRotulo( "Ruído 1" );
        
        entradaFloatPanel freq1 = new entradaFloatPanel( "Frequência: ", min, max, val, escala );
        
        p1.add( rot1 );
        p1.add( freq1 );
        
        deslisadorFloat slider = freq1.getSlider();
        JTextField text = freq1.getText();
        DecimalFormat df = freq1.getDF();
        
        slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                // Evento
                text.setText( df.format( slider.getValorEscala() ) );
                
                // Mudar parâmetro em instru2
                instru2.setFreqCorte( num, slider.getValorEscala() );
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
                    float valor = Float.parseFloat(typed) * slider.escala;
                    slider.setValue((int)valor);
                    
                    instru2.setFreqCorte( num, Float.parseFloat(typed) );
                }
            }
        );
        
        p1.setBorder(BorderFactory.createLineBorder(Color.blue));
        p1.setBackground(util.corTitulo);
        
        return p1;
    }
    
    instrumento2 getInstrumento2(){
        return instru2;
    }
}
