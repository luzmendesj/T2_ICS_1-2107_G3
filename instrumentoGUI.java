import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.*;

public class instrumentoGUI extends JPanel{
    public JLabel constroiRotulo(String texto) {
        JLabel rotulo = new JLabel( texto );
        Color corTxt = new Color(60, 30, 100);
        
        rotulo.setFont( new Font("SansSerif", Font.PLAIN, 18) );
        rotulo.setForeground(corTxt);
        
        return rotulo;
    }
    
    public JButton constroiBotao(String legenda) {
    // usa 9 como o tamanho de fonte default.
        return constroiBotao(legenda, 12);
    }

    public JButton constroiBotao(String legenda, float tamanho) {
        JButton botao = new JButton(legenda);
        botao.setMargin(new Insets(3, 3, 3, 3));
        botao.setFocusable(false);
        botao.setFont(botao.getFont().deriveFont(Font.PLAIN));
        botao.setFont(botao.getFont().deriveFont(tamanho));
        return botao;
    }
}