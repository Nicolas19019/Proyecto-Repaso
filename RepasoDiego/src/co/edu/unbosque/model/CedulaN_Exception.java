package co.edu.unbosque.model;
/**
 * Clase de excepcion para evitar numeros negativos en la cedula
 *
 * @author Nicolas
 * 
 */
public class CedulaN_Exception extends Exception {
	  /**
     * Metodo constructor con su respectivo super
     */
    public CedulaN_Exception() {
		super();
	}

    /**
     * Metodo constructor con su respectivo super
     * <b>post</b> Muestra el mensaje en caso del error<br>
     * @param mensaje El mensaje a mostrar
     */
	public CedulaN_Exception(String mensaje) {
		super(mensaje);
	}
}
