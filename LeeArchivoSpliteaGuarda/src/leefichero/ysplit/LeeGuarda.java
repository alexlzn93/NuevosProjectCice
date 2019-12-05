package leefichero.ysplit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LeeGuarda {

	public static ArrayList<String> leerArchivo(String archivo){
		
			ArrayList<String>lineasArchivo= new ArrayList<String>();
			BufferedReader archi = null;
			int lineas=0;
			try {
				archi = new BufferedReader(new FileReader(archivo));
				String linea="";
				while(linea  != null) {
					linea= archi.readLine();
					if(linea !=null) {
						lineasArchivo.add(linea);
						//no se que hacer con esta linea leida del texto
					}
				}
				archi.close();
				
				
			} catch (IOException ioe) {

			}
			return lineasArchivo;
		}
	public static void guardarArchivo(ArrayList<String>lista,String nombreArchivo) { //metodo que recibe un arraylist y un String
		try {
			PrintWriter salida= new PrintWriter(new FileWriter(nombreArchivo));//guarda una coleccion y la escribe en un nuevo archivo(nombreArchivo)
			for (String linea: lista) {
				salida.println(linea);
			}salida.close();
		}catch(IOException ioe){
			
		}
	}
				
			
			
			
		
	}

