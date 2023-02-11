package co.edu.unbosque.model;
/**
 * Clase de excepcion para evitar numeros negativos y/o mayores a 120 en la edad
 *
 * @author Nicolas
 * 
 */
public class Edad_Exception extends Exception {
	  /**
     * Metodo constructor con su respectivo super
     */
    public Edad_Exception() {
		super();
	}

    /**
     * Metodo constructor con su respectivo super
     * <b>post</b> Muestra el mensaje en caso del error<br>
     * @param mensaje El mensaje a mostrar
     */
	public Edad_Exception(String mensaje) {
		super(mensaje);
	}
}
