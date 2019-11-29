package libreriaAlex.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import libreriaAlex.base.Base;
//Clase para conectarnos a la web y descargar archivos
public class Net {

	public static void getWebArchivo(String enlaceWeb, String nombreArchivo) {
		getWebArchivo(enlaceWeb, new File(nombreArchivo));
	}

	public static void getWebArchivo(String enlaceWeb, File nombreArchivo) { //
		System.out.println("Descargando: " + enlaceWeb);
		try { // puede haber una excepcion que sea que la url sea incorrecta
			URL url = new URL(enlaceWeb); // creada la url
			// if (url.getProtocol().equals("https"))
			// activarSocketSSL();
			HttpURLConnection urlConexion = (HttpURLConnection) url.openConnection(); // .openConecction abrir la
																						// conexion
			urlConexion.addRequestProperty("User-Agent", Base.USER_AGENT); // addRequestProperty quien solicita el
																			// recurso
			urlConexion.setReadTimeout(Base.RETARDO_MILISEGUNDOS);
			urlConexion.connect();
			InputStream documento = urlConexion.getInputStream();
			FileOutputStream guardar = new FileOutputStream(nombreArchivo);
			byte[] array = new byte[Base.BYTES];
			int leido = 0;
			while ((leido = documento.read(array)) > 0) {
				guardar.write(array, 0, leido);
				guardar.flush();
			}
			documento.close();
			guardar.close();
		} catch (Exception ioe) {
		}
	}

	public static String getHtml(String enlaceWeb) {  //las url que nos conectemos nos va a devolver un archivo de texto
		StringBuilder texto = new StringBuilder(""); //contenedor de cadenas String 
		try {
			URL url = new URL(enlaceWeb); //enlace que escribimos en el navegador

			URLConnection urlConexion = url.openConnection(); //abro la conexion con la web 
			
			urlConexion.connect(); //nos conectamos
			BufferedReader pagina = new BufferedReader(new InputStreamReader(urlConexion.getInputStream()), Base.BYTES); //leo el archivo aunque este en internet
			String linea;
			while ((linea = pagina.readLine()) != null) //leer linea a linea del documento
				texto.append(linea);
			pagina.close();
		} catch (Exception e) {
		}
		return texto.toString();
	}
	static List<String> getEnlaces(String html,String buscar){
		List<String> enlaces = new ArrayList<String>();
		html= html.replaceAll("\"", "'"); //reemplaza la doble "  por esto " ' " comilla simple
		
		int posicion = html.indexOf(buscar); 
		//<img src='http://imagen.gif'><p>parrafo</p> (Siempre todas las imagenes van a empezar con img
		while(posicion !=-1) {
			String enlace= html.substring(posicion + buscar.length()); //enlace contrendra http://imagen.gif'><p>parrafo</p>
			enlace= enlace.substring(0,enlace.indexOf("'")); //empeiza en 0 que sera http://imagen.gif hasta q encuentre la ultima '
			enlaces.add(enlace);
			html=html.substring(posicion + buscar.length());
			posicion=html.indexOf(buscar);
		}
		return enlaces;
		
	}

}
