/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Nicolas Machado
 * 
 * Panel del menu del CRUD con botones
 */
public class PanelMenu extends JPanel {

    /**
     * Arreglo de botones
     */
    private JButton bot[];
  

    /**
     * Metodo constructor
     * <b>pre</b> La existencia de los atributos <br>
     * <b>post</b> La ventana es creada <br>
     */
    public PanelMenu() {
        bot = new JButton[6];
        
        setPreferredSize(new Dimension(700, 720));
        setLayout(null);
        setBackground(Color.BLUE);
        setOpaque(false);

        inicializarComponentes();

        setVisible(true);
    }

    /**
     * Metodo para inicializar los atributos
     * <b>pre</b> Los atributos y el espacio suficiente para agregarlos <br>
     * <b>post</b> Los atributos son inicializados y anadidos <br>
     */
    private void inicializarComponentes() {
  
        
        for (int i = 0; i < bot.length; i++) {
            bot[i] = new JButton("Boton " + i);
            bot[i].setActionCommand("boton" + i);
            bot[i].setOpaque(false);
            bot[i].setFocusable(false);


            bot[i].setForeground(Color.BLACK);
            bot[i].setBorder(null);

            add(bot[i]);
        }
        bot[0].setBounds(80, 150, 200, 40);
        bot[0].setText("Agregar");

        bot[1].setBounds(80, 220, 200, 40);
        bot[1].setText("Eliminar");

        bot[2].setBounds(80, 290, 200, 40);
        bot[2].setText("Modificar");

        bot[3].setBounds(80, 360, 200, 40);
        bot[3].setText("Buscar");

        bot[4].setBounds(80, 430, 200, 40);
        bot[4].setText("Ver");
       
        bot[5].setBounds(80, 500, 200, 40);
        bot[5].setText("Salir");

    

    }

    /**
     * Obtiene todos los botones del arreglo
     * @return the bot
     */
    public JButton[] getBot() {
        return bot;
    }

    /**
     * Asigna caracteristicas a los botones
     * @param bot the bot to set
     */
    public void setBot(JButton[] bot) {
        this.bot = bot;
    }

    
   

}
