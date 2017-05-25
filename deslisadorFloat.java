import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;

public class deslisadorFloat extends JSlider{
    float escala;

    public deslisadorFloat(int min, int max, int valor, int escala) {
        super(min, max, valor);
        this.escala = escala;
    }

    public float getValorEscala() {
        return ( (float) super.getValue() ) / this.escala;
    }
}
