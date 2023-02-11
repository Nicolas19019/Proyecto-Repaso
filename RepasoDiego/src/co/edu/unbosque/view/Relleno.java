package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Cristian Gomez
 * @author Nicolas Machado
 * @author Katherine Patino
 * Panel para pner relleno
 */
public class Relleno extends JPanel{

    /**
     * Una etiqueta de espacios
     */
    private JLabel label;

    /**
     * Metodo constructor
     * <b>pre</b> La existencia de atributos<br>
     * <b>post</b> El relleno es implementado en el panel<br>
     */
    public Relleno() {
        setLayout(new GridLayout());
        label = new JLabel("                                                                                                                                                  ");
        setOpaque(false);


        add(label);

    }
    
}
