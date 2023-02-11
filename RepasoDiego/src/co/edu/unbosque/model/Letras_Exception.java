package co.edu.unbosque.model;
/**
 * Clase de excepcion para evitar Letras en los datos numericos
 *
 * @author Nicolas
 * 
 */

public class Letras_Exception extends Exception{
	  /**
     * Metodo constructor con su respectivo super
     */
    public Letras_Exception() {
		super();
	}

    /**
     * Metodo constructor con su respectivo super
     * <b>post</b> Muestra el mensaje en caso del error<br>
     * @param mensaje El mensaje a mostrar
     */
	public Letras_Exception(String mensaje) {
		super(mensaje);
	}
}
