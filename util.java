
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paulo
 */
public class util {
    static Color corBG = new Color(230, 240, 255);
    static Color corTitulo = new Color(180, 190, 255);
    
    static final public JLabel constroiRotulo(String texto) {
        JLabel rotulo = new JLabel( texto, SwingConstants.CENTER );
        Color corTxt = new Color(60, 30, 100);
        
        rotulo.setFont( new Font("Serif", Font.PLAIN, 18) );
        rotulo.setForeground(corTxt);
        
        return rotulo;
    }
}
