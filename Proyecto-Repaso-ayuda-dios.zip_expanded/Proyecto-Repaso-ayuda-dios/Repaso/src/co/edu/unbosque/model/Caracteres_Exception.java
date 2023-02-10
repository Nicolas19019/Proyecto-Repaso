package co.edu.unbosque.model;

public class Caracteres_Exception extends Exception {
	  /**
     * Metodo constructor con su respectivo super
     */
    public Caracteres_Exception() {
		super();
	}

    /**
     * Metodo constructor con su respectivo super
     * <b>post</b> Muestra el mensaje en caso del error<br>
     * @param mensaje El mensaje a mostrar
     */
	public Caracteres_Exception(String mensaje) {
		super(mensaje);
	}
}
