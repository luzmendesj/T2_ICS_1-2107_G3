import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class unidadeHPanel extends JPanel{
    
    private int h;
    private float ganho;
    
    unidadeHPanel( int num, instrumento1 instru1 ){
        h = 0;
        ganho = 0f;
        
        this.setLayout( new GridLayout(3,0) );
        
        //JLabel rotulo = new JLabel( "Unidade " + num, SwingConstants.CENTER );
        JLabel rotulo = util.constroiRotulo( "Unidade "+num );
        entradaFloatPanel entH = harmonicoFloatPanel( num, instru1 );
        entradaFloatPanel entGanho = ganhoFloatPanel( num, instru1 );
        
        this.add(rotulo);
        this.add(entH);
        this.add(entGanho);
    }
    
    public entradaFloatPanel harmonicoFloatPanel( int num, instrumento1 instru1 ){
        entradaFloatPanel ent = new entradaFloatPanel( "Harmônico: ", 0, 20, 0, 1 );
        
        deslisadorFloat slider = ent.getSlider();
        JTextField text = ent.getText();
        DecimalFormat df = ent.getDF();
        
        slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                // Evento
                text.setText( df.format( slider.getValorEscala() ) );
                
                // Mudar parâmetro em instru1
                instru1.setHarmonico( num, slider.getValorEscala() );
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
                    
                    instru1.setHarmonico( num, Float.parseFloat(typed) );
                }
            }
        );
        
        return ent;
    }
    
    public entradaFloatPanel ganhoFloatPanel( int num, instrumento1 instru1 ){
        return ganhoFloatPanel( "Ganho ", num, instru1 );
    }
    
    public entradaFloatPanel ganhoFloatPanel( String rot, int num, instrumento1 instru1 ){
        entradaFloatPanel ent = new entradaFloatPanel( rot, 0, 30000, 0, 1000 );
        
        deslisadorFloat slider = ent.getSlider();
        JTextField text = ent.getText();
        DecimalFormat df = ent.getDF();
        
        slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                // Evento
                text.setText( df.format( slider.getValorEscala() ) );
                
                // Mudar parâmetro em instru1
                instru1.setGanho( num, slider.getValorEscala() );
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
                    
                    instru1.setGanho( num, Float.parseFloat(typed) );
                }
            }
        );
        
        return ent;
    }
    
    public int getH(){
        return h;
    }
    public void setH( int h ){
        this.h = h;
    }
    
    public float getGanho(){
        return ganho;
    }
    public void setGanho( float ganho ){
        this.ganho = ganho;
    }
    
}
