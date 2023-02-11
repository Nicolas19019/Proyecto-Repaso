package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * @author Nicolas Machado
 * 
 * Clase DTO de candidatos
 */

public class CandidatoDTO implements Serializable {
	
	/**
	 * 
	 * Version del serializado esattico ID
	 */
	private static final long serialVersionUID = 6940216144169125581L;
	
	 /**
     * Datos del candidato como el nombre, apellido, el cedula, cargo y la edad
     */
	private String nombre, apellido, cedula, cargo, edad;

	  /**
     * Metodo constructor
     *  pre  La existencia de atributos 
     * post  Los atributos son inicializados correctamente 
     * @param nombre El nombre inicial
     * @param apellido El apellido inicial
     * @param edad la edad inicial
     * @param cargo El cargo inicial
     * @param cedula La cedula inicial
     */
	
	public CandidatoDTO(String nombre, String apellido, String edad, String cargo, String cedula) {
		this.apellido = apellido;
		this.cargo = cargo;
		this.cedula = cedula;
		this.edad = edad;
		this.nombre = nombre;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "El nombre del candidato es: " + nombre + "\n" + "El apellido del candidato es: " + apellido + "\n"
				+ "La cedula del candidato es: " + cedula + "\n" + "El cargo del candidato es: " + cargo + "\n"
				+ "La edad del candidato es: " + edad;
	}

}
