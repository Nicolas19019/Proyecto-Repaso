/**
 * 
 */
package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unbosque.model.CandidatoDTO;
import co.edu.unbosque.model.Caracteres_Exception;
import co.edu.unbosque.model.Letras_Exception;

/**
 * Clase Candidatos donde se encuentra el CRUD
 * 
 * @author Nicolas Machado
 */

public class CandidatosDAO {

	/**
	 * Archivo donde se guardara la informacion
	 */
	private Archivo archivo;

	/**
	 * Metodo constructor <b> pre </b> La existencia de los atributos<br>
	 * <b> post </b> Atributos inicializados correctamente<br>
	 * 
	 * @param archivo El dato inicial para archivo
	 */
	public CandidatosDAO(Archivo archivo) {
		this.archivo = archivo;

	}

	/**
	 * Metodo para mostrar los candidatos del archivo <b> pre </b> La existencia del
	 * archivo <br>
	 * <b> post </b> Muestra los candidatos guardados en el archivo <br>
	 * 
	 * @return La informacion del archivo
	 */
	public String mostrarCandidatos() {
		ArrayList<CandidatoDTO> candidatos = archivo.leerArchivo();
		String tempText = "";

		for (int i = 0; i < candidatos.size(); i++) {
			tempText = tempText.concat(candidatos.get(i).toString()) + "\n\n";
		}

		return tempText;
	}

	/**
	 * Metodo para buscar un candidato por la cedula <b> pre </b> La lista no debe
	 * estar vacia <br>
	 * <b> post </b> El candidato es encontrado <br>
	 * 
	 * @param Cedula     la cedula que se busca
	 * @param candidatos La lista a buscar
	 * @return La informacion del candidato encontrado
	 */
	public CandidatoDTO buscarCedula(String cedula, ArrayList<CandidatoDTO> candidatos) {

		CandidatoDTO encontrado = null;

		if (!candidatos.isEmpty()) {
			for (int i = 0; i < candidatos.size(); i++) {
				if (candidatos.get(i).getCedula().equals(cedula)) {
					encontrado = candidatos.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}

	/**
	 * Metodo para buscar un candidato por el Nombre <b> pre </b> La lista no debe
	 * estar vacia <br>
	 * <b> post </b> El candidato es encontrado <br>
	 * 
	 * @param Nombre el nombre que se busca
	 * @param candidatos La lista a buscar
	 * @return La informacion del candidato encontrado
	 */
	
	public CandidatoDTO buscarNombre(String Nombre, ArrayList<CandidatoDTO> candidatos) {

		CandidatoDTO encontrado = null;

		if (!candidatos.isEmpty()) {
			for (int i = 0; i < candidatos.size(); i++) {
				if (candidatos.get(i).getNombre().equals(Nombre)) {
					encontrado = candidatos.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}
	
	/**
	 * Metodo para buscar un candidato por el cargo <b> pre </b> La lista no debe
	 * estar vacia <br>
	 * <b> post </b> El candidato es encontrado <br>
	 * 
	 * @param Cargo el cargo que se busca
	 * @param candidatos La lista a buscar
	 * @return La informacion del candidato encontrado
	 */

	public CandidatoDTO buscarCargo(String Cargo, ArrayList<CandidatoDTO> candidatos) {

		CandidatoDTO encontrado = null;

		if (!candidatos.isEmpty()) {
			for (int i = 0; i < candidatos.size(); i++) {
				if (candidatos.get(i).getCargo().equals(Cargo)) {
					encontrado = candidatos.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}

	/**
	 * Metodo para buscar un candidato por el Apellido <b> pre </b> La lista no debe
	 * estar vacia <br>
	 * <b> post </b> El candidato es encontrado <br>
	 * 
	 * @param Apellido el Apellido que se busca
	 * @param candidatos La lista a buscar
	 * @return La informacion del candidato encontrado
	 */
	
	public CandidatoDTO buscarApellido(String Apellido, ArrayList<CandidatoDTO> candidatos) {

		CandidatoDTO encontrado = null;

		if (!candidatos.isEmpty()) {
			for (int i = 0; i < candidatos.size(); i++) {
				if (candidatos.get(i).getApellido().equals(Apellido)) {
					encontrado = candidatos.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}

	
	/**
	 * Metodo para buscar un candidato por la edad <b> pre </b> La lista no debe
	 * estar vacia <br>
	 * <b> post </b> El candidato es encontrado <br>
	 * 
	 * @param edad la edad que se busca
	 * @param candidatos La lista a buscar
	 * @return La informacion del candidato encontrado
	 */
	
	public CandidatoDTO buscarEdad(String Edad, ArrayList<CandidatoDTO> candidatos) {

		CandidatoDTO encontrado = null;

		if (!candidatos.isEmpty()) {
			for (int i = 0; i < candidatos.size(); i++) {
				if (candidatos.get(i).getEdad().equals(Edad)) {
					encontrado = candidatos.get(i);
					return encontrado;
				}
			}
		}
		return encontrado;
	}


	/**
	 * Metodo para agregar un nuevo contacto <b> pre </b> El candidato no debe ser
	 * repetido <br>
	 * <b> post </b> El nuevo contacto es agregado a la lista<br>
	 * 
	 * @param Nombre    El nombre a agregar
	 * @param Edad  la edad a agregar
	 * @param cargo    El cargo a agregar
	 * @param cedula      La cedula a agregar
	 * @param candidatos La lista donde se agrega el candidato
	 * @return Un valor de verdad que indica si el candidato fue agregado
	 * @throws Caracteres_Exception Excepcion que no permite que hayan algo distinto
	 *                              a letras y caracteres especiales
	 * @throws Letras_Exception     Excepcion que no permite el ingrso de algo
	 *                              distinto a numeros
	 */
	public boolean agregarCandidatos(String Nombre, String apellido, String edad, String cargo, String cedula,
			ArrayList<CandidatoDTO> candidatos) throws Caracteres_Exception, Letras_Exception {

		String n = "";
		String a = "";
		String e = "";
		String car = "";
		String c = "";

		for (int i = 0; i < Nombre.length(); i++) {

			if (Character.isLetter(Nombre.charAt(i)) || Nombre.charAt(i) == ' ') {

				n = Nombre;

			} else {
				throw new Caracteres_Exception("No ingresar caracteres especiales, ni numeros en el nombre");
			}
		}

		for (int i = 0; i < cargo.length(); i++) {

			if (Character.isLetter(cargo.charAt(i)) || cargo.charAt(i) == ' ') {

				car = cargo;

			} else {
				throw new Caracteres_Exception("No ingresar caracteres especiales, ni numeros en el cargo");
			}
		}

		for (int i = 0; i < apellido.length(); i++) {

			if (Character.isLetter(apellido.charAt(i)) || apellido.charAt(i) == ' ') {

				a = apellido;

			} else {
				throw new Caracteres_Exception("No ingresar caracteres especiales, ni numeros en el apellido");
			}
		}

		for (int i = 0; i < edad.length(); i++) {

			if (Character.isLetter(edad.charAt(i)) == false && edad.charAt(i) == ' ' && i > 1) {

				e = edad;

			} else {
				throw new Letras_Exception("No ingresar letras en la edad");
			}
		}

		for (int i = 0; i < cedula.length(); i++) {

			if (Character.isLetter(cedula.charAt(i)) == false && cedula.charAt(i) == ' ' && i > 9) {

				c = cedula;

			} else {
				throw new Caracteres_Exception("No ingresar letras en la cedula");
			}
		}

		CandidatoDTO nuevo = new CandidatoDTO(n, a, e, car, c);

		if (buscarCedula(cedula, candidatos) == null || buscarEdad(edad, candidatos) == null
				|| buscarNombre(Nombre, candidatos) == null) {

			candidatos.add(nuevo);
			archivo.escribirEnArchivo(candidatos);

			return true;

		} else {
			return false;
		}

	}

	/**
	 * Metodo para eliminar por la cedula <b> pre </b> La existencia del candidato
	 * <br>
	 * <b> post </b> El candidato es eliminado <br>
	 * 
	 * @param cedula     El nombre por el que se va a buscar
	 * @param candidatos La lista de donde se va a eliminar el contacto
	 * @return Un valor de verdad que indica si el contacto fue eliminado
	 */
	public boolean eliminar(String cedula, ArrayList<CandidatoDTO> candidatos) {

		try {
			CandidatoDTO bus = buscarCedula(cedula, candidatos);
			candidatos.remove(bus);
			archivo.getArchivo().delete();
			archivo.getArchivo().createNewFile();
			archivo.escribirEnArchivo(candidatos);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Metodo para modificar el nombre de un contacto por la busqueda del mismo <b>
	 * pre </b> La existencia del candidato <br>
	 * <b> post </b> El nombre es modificado <br>
	 * 
	 * @param nombre     El nombre por el que se va a buscar
	 * @param nombre2    El nombre por el que se va a modificar
	 * @param candidatos La lista de donde se va a modificar
	 * @return Un valor de verdad que indica si se modifico la informacion deseada
	 * @throws Caracteres_Exception Excepcion que no permite que hayan algo distinto
	 *                              a letras
	 */
	public boolean modificarNombre(String Nombre, String Nombre2, ArrayList<CandidatoDTO> candidatos)
			throws Caracteres_Exception {
		try {

			if (!Nombre2.matches("[a-zA-Z][a-zA-Z ]*")) {
				throw new Caracteres_Exception("No ingresar caracteres especiales en el nombre");
			} else {
				CandidatoDTO bus = buscarNombre(Nombre, candidatos);
				bus.setNombre(Nombre2);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirEnArchivo(candidatos);

				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Metodo para modificar la Edad de un candidato por la busqueda del mismo <b>
	 * pre </b> La existencia del contacto <br>
	 * <b> post </b> la Edad es modificado <br>
	 * 
	 * @param Edad       la Edad por el que se va a buscar
	 * @param Edad2      la Edad por el que se va amodificar
	 * @param candidatos La lista de donde se va a modificar
	 * @return Un valor de verdad que indica si se modifico la informacion deseada
	 * @throws Letras_Exception Excepcion que no permite el ingrso de algo distinto
	 *                          a numeros
	 */
	public boolean modificarEdad(String Edad, String Edad2, ArrayList<CandidatoDTO> candidatos)
			throws Letras_Exception {

		try {

			if (!Edad2.matches("[0-9]*")) {
				throw new Letras_Exception("No poner letras en el telefono");
			} else {
				CandidatoDTO bus = buscarEdad(Edad, candidatos);
				bus.setEdad(Edad2);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirEnArchivo(candidatos);

				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Metodo para modificar el nombre de un contacto por la busqueda del mismo <b>
	 * pre </b> La existencia del candidato <br>
	 * <b> post </b> El Cargo es modificado <br>
	 * 
	 * @param Cargo      El Cargo por el que se va a buscar
	 * @param Cargo2     El Cargo por el que se va a modificar
	 * @param candidatos La lista de donde se va a modificar
	 * @return Un valor de verdad que indica si se modifico la informacion deseada
	 * @throws Caracteres_Exception Excepcion que no permite que hayan algo distinto
	 *                              a letras
	 */
	public boolean modificarCargo(String cargo, String cargo2, ArrayList<CandidatoDTO> candidatos)
			throws Caracteres_Exception {
		try {

			if (!cargo2.matches("[a-zA-Z][a-zA-Z ]*")) {
				throw new Caracteres_Exception("No ingresar caracteres especiales en el nombre");
			} else {
				CandidatoDTO bus = buscarNombre(cargo, candidatos);
				bus.setNombre(cargo2);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirEnArchivo(candidatos);

				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Metodo para modificar el Apellido de un candidato por la busqueda del mismo
	 * <b> pre </b> La existencia del candidato <br>
	 * <b> post </b> El Apellido es modificado <br>
	 * 
	 * @param Apellido  El Apellido por el que se va a buscar
	 * @param Apellido2 El Apellido por el que se va amodificar
	 * @param contactos La lista de donde se va a modificar
	 * @return Un valor de verdad que indica si se modifico la informacion deseada
	 * @throws Caracteres_Exception Excepcion que no permite que hayan algo distinto
	 *                              a letras
	 */
	public boolean modificarApellido(String Apellido, String Apellido2, ArrayList<CandidatoDTO> candidatos)
			throws Caracteres_Exception {
		try {

			if (!Apellido2.matches("[a-zA-Z][a-zA-Z ]*")) {
				throw new Caracteres_Exception("No ingresar caracteres especiales en el nombre");
			} else {
				CandidatoDTO bus = buscarApellido(Apellido, candidatos);
				bus.setNombre(Apellido2);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirEnArchivo(candidatos);

				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Metodo para modificar la cedula de un candidato por la busqueda del mismo <b>
	 * pre </b> La existencia del contacto <br>
	 * <b> post </b> La cedula es modificado <br>
	 * 
	 * @param cedula     La cedula por el que se va a buscar
	 * @param cedula2    La cedula por el que se va amodificar
	 * @param candidatos La lista de donde se va a modificar
	 * @return Un valor de verdad que indica si se modifico la informacion deseada
	 * @throws Letras_Exception Excepcion que no permite el ingrso de algo distinto
	 *                          a numeros
	 */
	public boolean modificarCedula(String cedula, String cedula2, ArrayList<CandidatoDTO> candidatos)
			throws Letras_Exception {

		try {

			if (!cedula2.matches("[0-9]*")) {
				throw new Letras_Exception("No poner letras en el telefono");
			} else {
				CandidatoDTO bus = buscarCedula(cedula, candidatos);
				bus.setEdad(cedula2);
				archivo.getArchivo().delete();
				archivo.getArchivo().createNewFile();
				archivo.escribirEnArchivo(candidatos);

				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
