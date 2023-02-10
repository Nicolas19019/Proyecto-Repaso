package co.edu.unbosque.model;

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
