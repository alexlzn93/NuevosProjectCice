package libreriaAlex.cadenas;

public final class Cadenas {

	public static String padString(char caracter,String texto, int ancho) {
		
		if(texto==null) return "";
		if(ancho<-1) return "";
			texto=texto.trim();
			int digitos =texto.length();
			
		
		if(digitos>ancho) 	return texto;
		int caracteres=ancho -digitos;
		StringBuilder cadena=new StringBuilder("");
		for (int i=0;i<caracteres;i++) 
			cadena.append(caracter);
			
		
		
		return cadena.toString()+texto;//no funciona y creo que el problema esta aqui que no saaca lo que deberia
	}
	
	
	
	public static String invertir(String texto) {
		
		return new StringBuilder(texto).reverse().toString();
		
	}
	
	public static int contar(String texto, String palabra) {
		
		int apariciones=0;
		int posicion= texto.indexOf(palabra); //indexOf busca una palabra en un texto si no la encuentra devuelve un -1
		while(posicion!=-1) {
			apariciones++;
			texto=texto.substring(posicion + palabra.length());
			posicion=texto.indexOf(palabra);
			
		}
		
		return apariciones;
		
	}
	
	
}
