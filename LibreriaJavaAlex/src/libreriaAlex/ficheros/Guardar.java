package libreriaAlex.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Guardar <Tipo>{

	
		public  void guardarLista(ArrayList<Tipo> lista, String nombreArchivo) {
		try {

			PrintWriter archivo = new PrintWriter(new FileWriter(nombreArchivo));
			for (Tipo elemento : lista) {
				archivo.println(elemento);
			}
			archivo.close();
		} catch (IOException e) {
		}

		
		
	}
	
	
	
}
