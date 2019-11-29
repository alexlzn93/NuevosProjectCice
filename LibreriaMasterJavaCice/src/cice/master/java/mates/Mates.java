package cice.master.java.mates;

public final class Mates {

	public static double raizCuadrada(double numero) {
		return Math.sqrt(numero);
	}
	
	public static float raizCuadrada(float numero) {
		return (float)Math.sqrt(numero);
	}
	
	public static int doble(int numero) {
		return numero * 2;
	}
	
	public static long doble(long numero) {
		return numero * 2;
	}
	
	public static double doble(double numero) {
		return numero * 2;
	}
	
	public static float doble(float numero) {
		return numero * 2;
	}
	
	public static int triple(int numero) {
		return numero * 3;
	}
	
	public static long triple(long numero) {
		return numero * 3;
	}
	
	public static double triple(double numero) {
		return numero * 3;
	}
	
	public static float triple(float numero) {
		return numero * 3;
	}
	
	public static int cubo(int numero) {
		return elevar(numero, 3);
	}
	
	public static long cubo(long numero) {
		return elevar(numero, 3L);
	}
	
	public static double cubo(double numero) {
		return elevar(numero, 3D);
	}
	
	public static float cubo(float numero) {
		return elevar(numero, 3F);
	}
	
	public static int elevar(int base, int exponente) {
		return (int)Math.pow(base, exponente);
	}
	
	public static long elevar(long base, long exponente) {
		return (long)Math.pow((double)base, (double)exponente);
	}
	
	public static double elevar(double base, double exponente) {
		return Math.pow(base, exponente);
	}
	
	public static float elevar(float base, float exponente) {
		return (float)Math.pow(base, exponente);
	}

	public static int potencia(int exponente) {
		return 1 << exponente;
	}
	
	public static long potencia(long exponente) {
		return 1L << exponente;
	}
	
	public static long factorial(long number) {
		if (number < 2L) {
			return 1L;
		}
		return factorialAux(number, 1L);
	}

	private static long factorialAux(long number, long base) {
		if (number < 1L) {
			return base;
		}
		return factorialAux(number - 1L, base * number);
	}

	public static int factorial(int number) {
		if (number < 2) {
			return 1;
		}
		return factorialAux(number, 1);
	}

	private static int factorialAux(int number, int base) {
		if (number < 1) {
			return base;
		}
		return factorialAux(number - 1, base * number);
	}
	
}
