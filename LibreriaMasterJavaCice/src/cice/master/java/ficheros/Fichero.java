package cice.master.java.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import cice.master.java.Base;

public final class Fichero {

	public static void crearDirectorio(String rutaDirectorio) {
		File directorio = new File(rutaDirectorio);
		if (!directorio.exists()) {
			directorio.mkdirs();
		}
	}

	public static String leerTextoArchivo(String nombreArchivo) {
		return leerTextoArchivo(new File(nombreArchivo));
	}

	public static String leerTextoArchivo(File nombreArchivo) {
		StringBuilder texto = new StringBuilder("");
		try {
			BufferedReader archivo = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			while ((linea = archivo.readLine()) != null) texto.append(linea + " ");
			archivo.close();
		} catch (IOException ioe) {
			texto = new StringBuilder("");
		}
		return texto.toString().trim();
	}

	public static List<String> leerTextoArchivoLista(String nombreArchivo) {
		return leerTextoArchivoLista(new File(nombreArchivo));
	}
	
	public static List<String> leerTextoArchivoLista(File nombreArchivo) {
		List<String> lista = new ArrayList<String>();
		try {
			BufferedReader archivo = new BufferedReader(new FileReader(nombreArchivo));
			String linea;
			while ((linea = archivo.readLine()) != null) lista.add(linea);
			archivo.close();
		} catch (IOException ioe) {
			lista = new ArrayList<String>();
		}
		return lista;
	}
	
	public static void guardarTextoArchivo(String nombreArchivo, String texto) {
		guardarTextoArchivo(new File(nombreArchivo), texto);
	}

	public static void guardarTextoArchivo(File nombreArchivo, String texto) {
		try {
			PrintWriter archivo = new PrintWriter(new FileWriter(nombreArchivo));
			archivo.println(texto);
			archivo.flush();
			archivo.close();
		} catch (Exception e) {
		}
	}
	
	public static void guardarListaTexto(String nombreArchivo, List<String> lista) {
		guardarListaTexto(new File(nombreArchivo), lista);
	}
	
	public static void guardarListaTexto(File nombreArchivo, List<String> lista) {
		try {
			PrintWriter archivo = new PrintWriter(new FileWriter(nombreArchivo));
			for (String linea : lista) archivo.println(linea);
			archivo.flush();
			archivo.close();
		} catch (Exception e) {
		}
	}
	
	public static void copiarArchivo(String archivoOrigen, String archivoDestino) {
		copiarArchivo(new File(archivoOrigen), new File(archivoDestino));
	}

	public static void copiarArchivo(File archivoOrigen, File archivoDestino) {
		try {
			FileInputStream origen = new FileInputStream(archivoOrigen);
			FileOutputStream destino = new FileOutputStream(archivoDestino);
			byte[] bytesLectura = new byte[Base.BYTES];
			int bytesLeidos = 0;
			while ((bytesLeidos = origen.read(bytesLectura)) > 0) {
				destino.write(bytesLectura, 0, bytesLeidos);
				destino.flush();
			}
			origen.close();
			destino.close();
		} catch (IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!");
		}
	}

}
