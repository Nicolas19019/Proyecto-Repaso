package co.edu.unbosque.view;

import javax.swing.JOptionPane;

/**
 * @author Cristian Gomez
 * @author Nicolas Machado
 * @author Katherine Patino
 * Clase encargada de los mensajes emergentes
 */
public class View {


    /**
     * Metodo para leer un dato dado por el usuario
     * <b>pre</b> El dato ingresado tiene que ser una cadena de texto <br>
     * <b>post</b> Guarda el dato en una variable <br>
     * @param mensajitolindo El mensaje a mostrar para el usuario
     * @return El dato ingresado
     */
    public String read(String mensajitolindo) {
        String msj = JOptionPane.showInputDialog("<html> <p style = \"font-family:Comic Sans MS\">" + mensajitolindo);
        return msj;
    }

    /**
     * Metodo para una ventana emergente con opciones "si" y "no"
     * @param mensajitolindo Mensaje a mostrar al usuario
     * @return La opcion elegida
     */
    public int confirm(String mensajitolindo) {
        int msj = JOptionPane.showConfirmDialog(null, "<html> <p style = \"font-family:Comic Sans MS\">" + mensajitolindo,
                                                "Salir?", JOptionPane.YES_NO_OPTION);
        return msj;
    }

    /**
     * Metodo que muestra un mensaje al usuario
     * @param mensaje El mensaje que se va a mostrar
     */
    public void show(String mensaje) {
        JOptionPane.showMessageDialog(null, "<html> <p style = \"font-family:Comic Sans MS\">" + mensaje);
    }

}
