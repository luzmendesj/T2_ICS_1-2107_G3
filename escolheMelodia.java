import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class escolheMelodia extends instrumentoGUI {
	
    JPanel pan1; 
    instrumento1 inst1;
    instrumento2 inst2;
	 
    escolheMelodia( instrumento1 inst1, instrumento2 inst2 ){
        
        this.inst1 = inst1;
        this.inst2 = inst2;
        
        JPanel pan2 = new JPanel();
       
        JPanel invisivel = new JPanel();
        invisivel.setOpaque(false);
        
        pan1 = new JPanel();  
                
        JButton b = new JButton("Tocar");  
        b.setBounds(200,100,75,20);
        
        String melodia[]={"Escolher Melodia","fraseparacorneingles","m23a","m25","m9_la_menor", 
                    "segundamenor_trombone", "tercamaior2_harpa"};        
        JComboBox cb = new JComboBox(melodia);    
        cb.setBounds(50, 50,150,20);    
        pan1.add(cb);  
	
        pan2.add( pan1 );
        pan2.add(b);
        
        this.setLayout( new BorderLayout() );
        this.add( invisivel, BorderLayout.NORTH );
        this.add( pan2, BorderLayout.CENTER );
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       

                String data = (String) cb.getItemAt(cb.getSelectedIndex());  
                
                if( data.equals( melodia[0] ) == false ){
                    inst1.setMelodia( data );
                }

            }  
        });
    }

}
