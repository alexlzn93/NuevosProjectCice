package webflaticon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import libreriaAlex.base.Base;
import libreriaAlex.ficheros.Fichero;
import libreriaAlex.ficheros.Guardar;
import libreriaAlex.net.Net;

public class Imagenes {
	public static void main(String []a) {
		String html= Net.getHtml("https://flaticon.es"); //getHtml me descarga una url en formato texto (metodo de la clase Net)
		String nombre= "C:\\Users\\Alex\\Desktop\\CURSO DE JAVA\\enlaceimagenes.txt";
		try {
		PrintWriter archivoImagenes = new PrintWriter(new FileWriter(nombre));
		
		System.out.println(html);
		for(String imagen :getEnlaces(html,"src='")) {
			archivoImagenes.println(imagen);
			
			}
		archivoImagenes.close();
		}catch(IOException ioe) {
			
		}
		
		
		
		Fichero.leerArchivoTexto(nombre);
		Net.getWebArchivo(html, nombre);
		//guardar el fichero con los enlaces de las imagenes en un array y recorrerlo con un bucle
		//aqui esta el fallo me falta
		
		
		
		
	}
	

	// metodo para que una vez leida la url y pasada a un String me reemplaze las
	// comillas dobles " por simples ' y busque
	static List<String> getEnlaces(String html, String buscar) {
		List<String> enlaces = new ArrayList<String>();
		html = html.replaceAll("\"", "'"); // reemplaza la doble " por esto " ' " comilla simple

		int posicion = html.indexOf(buscar);
		// <img src='http://imagen.gif'><p>parrafo</p> (Siempre todas las imagenes van a
		// empezar con img
		while (posicion != -1) {
			String enlace = html.substring(posicion + buscar.length()); // enlace contrendra
																		// http://imagen.gif'><p>parrafo</p>
			enlace = enlace.substring(0, enlace.indexOf("'")); // empeiza en 0 que sera http://imagen.gif hasta q
																// encuentre la ultima '
			if (enlace.endsWith("png") || (enlace.endsWith("jpg"))) { // si termina endwith con png y jpg lo añade a la
																		// List(interfaz de ArrayList)

				enlaces.add(enlace);
			}

			html = html.substring(posicion + buscar.length());
			posicion = html.indexOf(buscar);
		}
		return enlaces;

	}
	// lectura de archivos a nivel BITS
	// (Internet a local)
	public static void getWebArchivo(String enlaceWeb, File nombreArchivo) { 
		System.out.println("Descargando: " + enlaceWeb);
		try { // puede haber una excepcion que sea que la url sea incorrecta
			URL url = new URL(enlaceWeb); // creada la url

			HttpURLConnection urlConexion = (HttpURLConnection) url.openConnection(); // .openConecction establece la
																						// conexion
			urlConexion.addRequestProperty("User-Agent", Base.USER_AGENT); // addRequestProperty quien solicita el
																			// recurso

			urlConexion.setReadTimeout(Base.RETARDO_MILISEGUNDOS); // define el tiempo de la llamada para intentar
																	// conectar
			urlConexion.connect(); // me conecto
			InputStream documento = urlConexion.getInputStream(); // getinputStream lo lee y lo guarda en un inputStream
																	// y se lee a nivel bits
			FileOutputStream guardar = new FileOutputStream(nombreArchivo); // FileOutputStream lectura de archivo en
																			// formato binario bits
			byte[] array = new byte[Base.BYTES]; // creo un array de bits lotes de 65536 bits 64kbyte
			int leido = 0;
			while ((leido = documento.read(array)) > 0) { // read leo bits a bits y cuando no lee mas devuelve un -1
				guardar.write(array, 0, leido); // escrito una vez leido los guarda
				guardar.flush(); // vaciado vaciar el buffer
			}
			documento.close();
			guardar.close();
		} catch (Exception ioe) {
		}
	}

}
