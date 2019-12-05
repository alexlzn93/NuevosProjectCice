package leefichero.ysplit;

import java.util.ArrayList;

//leo el archivo, creo una nueva coleccion ArrayList, la instancio y spliteo para despues guardarla en otro archivo ya spliteado
public class Splitea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//le digo donde esta el archivo a leer ruta de los archivos
		String archivo="C:\\Users\\Alex\\Desktop\\GestionLibros\\categorias.txt";
		String archivoGuardar="C:\\Users\\Alex\\Downloads\\datasets\\categoriassplit.txt";
		
		//una vez leido lo guardo en una coleccion arraylist que se llama separa
		ArrayList<String> separa= LeeGuarda.leerArchivo(archivo);
		ArrayList<String> nueva= new ArrayList<String>();//instancio un nuevo arraylist para almacenar los datos spliteados
		//recorro la colecion(ArrayList separa) con un bucle for each
		for(String linea: separa) {
			String[] campo=linea.split("\\|");
			nueva.add(campo[0]+"-"+ campo[1]+"-" + campo[2]+"-"+ campo[3]+"-"+ campo[4]+"-"+ campo[5]+"-"+ campo[6]);
		}
		LeeGuarda.guardarArchivo(nueva, archivoGuardar); //metodo para guardar los datos de la coleccion nueva y ruta del archivo donde se desea escribir
		
	}

}
