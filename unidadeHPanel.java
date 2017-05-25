import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.*;

public class unidadeHPanel extends JPanel{
    
    private int h;
    private float lambda;
    private float ganho;
    
    unidadeHPanel( int num ){
        h = 0;
        lambda = 0f;
        ganho = 0f;
        
        this.setLayout( new GridLayout(4,0) );
        
        //JLabel rotulo = new JLabel( "Unidade " + num, SwingConstants.CENTER );
        JLabel rotulo = util.constroiRotulo( "Unidade "+num );
        entradaFloatPanel entH = new entradaFloatPanel( "Harmônico: ", 0, 100, 0, 1000 );
        entradaFloatPanel entGanho = new entradaFloatPanel( "Ganho ", 0, 100, 0, 1000 );
        entradaFloatPanel entLambda = new entradaFloatPanel( "Lambda ", 0, 100, 0, 1000 );
        
        this.add(rotulo);
        this.add(entH);
        this.add(entGanho);
        this.add(entLambda);
    }
    
    public int getH(){
        return h;
    }
    public void setH( int h ){
        this.h = h;
    }
    
    public float getLambda(){
        return lambda;
    }
    public void setLambda( float lambda ){
        this.lambda = lambda;
    }
    
    public float getGanho(){
        return ganho;
    }
    public void setGanho( float ganho ){
        this.ganho = ganho;
    }
    
}
