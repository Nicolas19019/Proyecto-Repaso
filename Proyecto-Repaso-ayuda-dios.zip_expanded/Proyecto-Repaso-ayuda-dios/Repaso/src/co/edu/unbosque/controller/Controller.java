/**
 * 
 */
package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.CandidatoDTO;
import co.edu.unbosque.model.Caracteres_Exception;

import co.edu.unbosque.model.Letras_Exception;

import co.edu.unbosque.model.persistence.Archivo;

import co.edu.unbosque.model.persistence.CandidatosDAO;

import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.View;

/**
 * 
 * @author Nicolas Machado
 */
public class Controller implements ActionListener {

	/**
	 * Atributo con el CRUD de candidatos
	 */
	private CandidatosDAO candidatoDAO;

	/**
	 * DTO de candidatos de tipo ArrayList
	 */
	private ArrayList<CandidatoDTO> candidatos;

	/**
	 * Archivo para guardar informacion de los candidatos
	 */
	private Archivo archivo;

	/**
	 * Ventana principal del programa
	 */
	private VentanaPrincipal ventana;

	/**
	 * Ventanas emergentes del programa
	 */
	private View vista;

	/**
	 * Metodo constructor <b> pre </b> Implementar las funcionalidaades del programa
	 * <br>
	 * <b> post </b> El programa funciona <br>
	 */
	public Controller() {

		ventana = new VentanaPrincipal();
		botoncitos();

		archivo = new Archivo();

		candidatoDAO = new CandidatosDAO(archivo);

		candidatos = new ArrayList<CandidatoDTO>();
		candidatos = archivo.leerArchivo();

		vista = new View();

	}

	/**
	 * Asigna los oyentes a los botones <b> pre </b> La existencia de los botones
	 * <br>
	 * <b> post </b> Los botones tienen acciones <br>
	 */
	private void botoncitos() {

		for (int i = 0; i < ventana.getPMenu().getBot().length; i++) {
			ventana.getPMenu().getBot()[i].addActionListener(this);

		}
	}



	/**
 * @return the candidatos
 */
public ArrayList<CandidatoDTO> getCandidatos() {
	return candidatos;
}

/**
 * @param candidatos the candidatos to set
 */
public void setCandidatos(ArrayList<CandidatoDTO> candidatos) {
	this.candidatos = candidatos;
}

	/**
	 * Define las acciones de los botones <b> pre </b> Los botones deben tener
	 * acciones detectadas <br>
	 * <b> post </b> Los botones tienen sus acciones especificadas <br>
	 */
	@Override
	public void actionPerformed(ActionEvent x) {
		String cmd = x.getActionCommand();

		switch (cmd) {

		case "boton0":

			 Agregar();
             ventana.getPI().getTextArea().setText(candidatoDAO.mostrarCandidatos());
             ventana.getPI().repaint();

			break;

		case "boton1":

				switchEliminar();
			
				break;
		case "boton2":

				switchModificar();
	
			ventana.getPI().repaint();
			break;


		case "boton3":
			
			Buscar();
			ventana.getPI().repaint();

			break;

		case "boton4":
	
			ventana.getPI().getTextArea().setText(candidatoDAO.mostrarCandidatos());
			break;

		case "boton5":

			if (vista.confirm("Quieres salir?") == JOptionPane.YES_OPTION) {
				ventana.dispose();
				System.exit(0);
			}
			break;
		}
	}

	/**
	 * El usuario escoje que desea agregar <b> pre </b> Los metodos del CRUD
	 * existentes <br>
	 * <b> post </b> Los candidatos son agregados <br>
	 */
	public void Agregar() {

			try {
				if (candidatoDAO.agregarCandidatos(vista.read("Ingrese el nombre del candidato"),
						vista.read("Ingrese el Apellido del contacto"), vista.read("Ingrese la edad del candidato"),
						vista.read("ingrese el cargo del contacto"),vista.read("ingrese la cedula del candidato"), candidatos) == true) {

					vista.show("El candidato se agrego con exito");
				} else {
					vista.show("El candidato ya existe");
				}

			} catch (Caracteres_Exception e) {
				vista.show(e.getMessage());
			} catch (Letras_Exception e) {
				vista.show(e.getMessage());
			}

		
	}

	/**
	 * Metodo para modificar candidatos <b> pre </b> Los metodos del CRUD existentes
	 * <br>
	 * <b> post </b> candidatos son modificados <br>
	 */
	private void switchModificar() {

		int msj = Integer.parseInt(
				vista.read("Que informacion de los candidatos deseas modificar? \n\n1. Nombre \n2. Edad \n3. Apellido  \n4. cedula  \n5. cargo"));
		switch (msj) {

		case 1:
			try {
				String nombre = vista.read("Ingrese el nombre a editar");
				String nombre2 = vista.read("Ingrese el nuevo nombre");
				for (int i = 0; i < candidatos.size(); i++) {
					
					if (nombre.equals(candidatos.get(i).getNombre())) {
						System.out.println("hay mas de uno iguañ");
						
					}else {
						
						candidatoDAO.modificarNombre(nombre, nombre2, candidatos);
						
						vista.show("El nombre se modifico correctamente, presione ver para visualizar los cambios");
					}
					
				}
			} catch (Caracteres_Exception e) {
				vista.show(e.getMessage());
			}
			break;

		case 2:
			try {
				String edad = vista.read("Ingrela edad a editar");
				String edad2 = vista.read("Ingrese la nueva edad");

				candidatoDAO.modificarEdad(edad, edad2, candidatos);

				vista.show("La edad se modifico correctamente, presione ver para visualizar los cambios");
			} catch (Letras_Exception e) {
				vista.show(e.getMessage());
			}
			break;

		case 3:
			try {
				String apellido = vista.read("Ingrese Apellido a editar");
				String apellido2 = vista.read("Ingrese el nuevo apellido");
				candidatoDAO.modificarApellido(apellido, apellido2, candidatos);

				vista.show("El correo se modifico correctamente, presione ver para visualizar los cambios");
			} catch (Caracteres_Exception e) {
				vista.show(e.getMessage());
			}
			break;
		case 4:
			try {
				String cedula = vista.read("Ingrese Apellido a editar");
				String cedula2 = vista.read("Ingrese el nuevo apellido");
				candidatoDAO.modificarCedula(cedula, cedula2, candidatos);

				vista.show("La cedula se modifico correctamente, presione ver para visualizar los cambios");
			} catch (Letras_Exception e) {
				vista.show(e.getMessage());
			}
			break;
		case 5:
			try {
				String cargo = vista.read("Ingrese cargo a editar");
				String cargo2 = vista.read("Ingrese el nuevo cargo");
				candidatoDAO.modificarCargo(cargo, cargo2, candidatos);

				vista.show("La cedula se modifico correctamente, presione ver para visualizar los cambios");
			} catch (Caracteres_Exception e) {
				vista.show(e.getMessage());
			}
			break;
		}
		
		
	}

	

	/**
	 * Metodo para eliminar candidatos <b> pre </b> Los metodos del CRUD existentes <br>
	 * <b> post </b> candidatos son eliminados <br>
	 */
	private void switchEliminar() {

		
			String cedula = vista.read("Ingrese la cedula del candidato que desea eliminar");

			candidatoDAO.eliminar(cedula, candidatos);

			vista.show("Eliminado satisfactoriamente!, presione ver para visualizar los cambios");

			
	}



	/**
	 * Metodo para buscar candidatos <b> pre </b> Los metodos del CRUD existentes <br>
	 * <b> post </b> Se encuantra al candidato solicitado <br>
	 */

	private void Buscar() {
		
	String cedula = vista.read("Ingrese la cedula :)");
	ventana.getPI().getTextArea().setText(candidatoDAO.buscarCedula(cedula, candidatos).toString());

			
	}

}
