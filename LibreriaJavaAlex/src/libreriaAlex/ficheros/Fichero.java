package libreriaAlex.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//Clase que contiene unos metodos para lectura de ficheros y guardarlos en local
public final class Fichero {

	public static String leerArchivoTexto(File nombreArchivo) {
		BufferedReader archivo = null;
		StringBuilder texto = new StringBuilder("");
		try {
			archivo = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			while ((linea = archivo.readLine()) != null) {
				texto.append(linea + " ");
			}
			archivo.close();
		} catch (IOException ioe) {
		}
		return texto.toString();
	}

	public static String leerArchivoTexto(String nombreArchivo) {
		return leerArchivoTexto(new File(nombreArchivo));
	}

	public static void mostrArchivoTexto(File nombreArchivo) {
		BufferedReader archivo = null;
		try {
			archivo = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			while ((linea = archivo.readLine()) != null) {
				System.out.println(linea + " ");
			}
			archivo.close();
		} catch (IOException ioe) {
		}

	}

	public static void mostrArchivoTexto(String nombreArchivo) {

		mostrArchivoTexto(new File(nombreArchivo));
	}

	// me va a devolver el texto pero en una coleccion

	public static ArrayList<String> leerArchivoTextoLista(File nombreArchivo) {
		BufferedReader archivo = null;
		ArrayList<String> lista = new ArrayList<String>();

		try {
			archivo = new BufferedReader(new FileReader(nombreArchivo));
			String linea = "";
			while (linea != null) {
				linea = archivo.readLine();
				if (linea != null) {
					lista.add(linea);
				}
			}
			archivo.close();
		} catch (IOException ioe) {
		}
		return lista;

	}

	public static ArrayList<String> leerArchivoTextoLista(String nombreArchivo) {
		return leerArchivoTextoLista(new File(nombreArchivo));
	}

	
	
	public static void guardarTexto(ArrayList<String> lista, String nombreArchivo) {

		try {

			PrintWriter archivo = new PrintWriter(new FileWriter(nombreArchivo));
			for (String elemento : lista) {
				archivo.println(elemento);//Aqui se llama al metodo toString de la clase 
			}
			archivo.close();
		} catch (IOException e) {
		}

		
	}
	
			
//	llamamos a la clase generica GUARDAR en vez de hacer lo que las 3 anteriores
//	vemos que tiene menos codigo que antes porque se le da un String y solo hay que instanciar la clase parametrizada y llamar
	public static void guardarTexto2(ArrayList<String> lista, String nombreArchivo) {
		Guardar<String> guardar= new Guardar<String>();
		guardar.guardarLista(lista, nombreArchivo);// este es el unico metodo que tiene
		
	}
	
	}
