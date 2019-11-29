package cice.master.java.cadenas;

public final class Cadenas {

	public static boolean esVocal(char caracter) {
		boolean es = false;
		switch(caracter) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'á':
		case 'é':
		case 'í':
		case 'ó':
		case 'ú':
		case 'ü':
			es = true;
			break;
		}
		return es;
	}
	
	public static int getVocales(String texto) {
		int vocales = 0;
		for (char caracter : texto.toCharArray()) {
			if (esVocal(caracter)) vocales++;
		}
		return vocales;
	}
	
	public static int getConsonantes(String texto) {
		int consonantes = 0;
		for (char caracter : texto.toCharArray()) {
			if (!esVocal(caracter)) consonantes++;
		}
		return consonantes;
	}
	
	public static String Capitalizar(String texto) {
		return texto.toUpperCase().charAt(0) + texto.toLowerCase().substring(1);
	}
	
	public static String padCeros(int numero, int ancho) {
		return padString('0', String.valueOf(numero), ancho);
	}

	public static String padCeros(String numero, int ancho) {
		return padString('0', numero, ancho);
	}

	public static String padString(char caracter, String texto, int ancho) {
		if (texto == null)
			return "";
		if (ancho < 1)
			return "";
		texto = texto.trim();
		int digitos = texto.length();
		if (digitos == ancho)
			return texto;
		if (digitos > ancho)
			return texto;
		int caracteres = ancho - digitos;
		String cadena = "";
		for (int i = 0; i < caracteres; i++)
			cadena += caracter;
		return cadena + texto;
	}

	public static String padCerosRight(int numero, int ancho) {
		return padStringRight('0', String.valueOf(numero), ancho);
	}

	public static String padCerosRight(String numero, int ancho) {
		return padStringRight('0', numero, ancho);
	}

	public static String padStringRight(char caracter, String texto, int ancho) {
		if (texto == null)
			return "";
		if (ancho < 1)
			return "";
		texto = texto.trim();
		int digitos = texto.length();
		if (digitos == ancho)
			return texto;
		if (digitos > ancho)
			return texto;
		int caracteres = ancho - digitos;
		String cadena = "";
		for (int i = 0; i < caracteres; i++)
			cadena += caracter;
		return texto + cadena;
	}

	public static char getLetraNIF(int dni) {
		String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
		return caracteres.charAt(dni % 23);
	}

	public static String getNIF(int dni) {
		return String.valueOf(dni) + getLetraNIF(dni);
	}
	
}
