package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.CandidatoDTO;

/**
 * Claase de archivo de tipo .dat para los candidatos

 * @author Nicolas Machado

 */
public class Archivo {

    /**
     * Atributo para la salida de informacion
     */
    private ObjectInputStream entrada;
    
    /**
     * Atributo para la entrada de informacion
     */
    private ObjectOutputStream salida;

    /**
     * El archivo de destino
     */
    private File archivo = new File("Data/Candidatos.dat");

    /**
     * Metodo constructor
     * <b>pre</b> La existencia del archivo <br>
     * <b>post</b> Archivo inicilizado y/o creado<br>
     */
    public Archivo() {
        if (archivo.exists()) {

        } else {
            try {
                archivo.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                try {
					archivo.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }
    }

    /**
     * Metodo que escribe en el archivo seleccionado
     * <b>pre</b> La existencia del archivo <br>
     * <b>post</b> El archivo es escrito con la informacion deseada <br>
     * @param contactos La informacion de contactos que se desea escribir
     */
    public void escribirEnArchivo(ArrayList<CandidatoDTO> candidato) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            salida.writeObject(candidato);
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo para leer el archivo selecionado
     * <b>pre</b> La existencia del archivo <br>
     * <b>post</b> El archivo leido y cargado <br>
     * @return La informacion del archivo
     */
    public ArrayList<CandidatoDTO> leerArchivo() {
        ArrayList<CandidatoDTO> contactos = new ArrayList<CandidatoDTO>();
        if (archivo.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(archivo));
                contactos = (ArrayList<CandidatoDTO>) entrada.readObject();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return contactos;
    }

    /**
     * Obtiene la herramienta de entrada
     * @return the entrada
     */
    public ObjectInputStream getEntrada() {
        return entrada;
    }

    /**
     * Asigna la entrada
     * @param entrada the entrada to set
     */
    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    /**
     * Obtiene la herramienta de ssalida
     * @return the salida
     */
    public ObjectOutputStream getSalida() {
        return salida;
    }

    /**
     * Asigna la salida
     * @param salida the salida to set
     */
    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }

    /**
     * Obtiene el archivo
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * Asigna el archivo
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

   

}
