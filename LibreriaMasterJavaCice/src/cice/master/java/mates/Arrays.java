package cice.master.java.mates;

public final class Arrays {

	public static int getSumatorio(int[] numeros) {
		int sumatorio = 0;
		for (int numero : numeros) {
			sumatorio += numero;
		}
		return sumatorio;
	}
	
	public static long getSumatorio(long[] numeros) {
		long sumatorio = 0L;
		for (long numero : numeros) {
			sumatorio += numero;
		}
		return sumatorio;
	}
	
	public static double getSumatorio(double[] numeros) {
		double sumatorio = 0.0;
		for (double numero : numeros) {
			sumatorio += numero;
		}
		return sumatorio;
	}
	
	public static float getSumatorio(float[] numeros) {
		float sumatorio = 0.0F;
		for (float numero : numeros) {
			sumatorio += numero;
		}
		return sumatorio;
	}
	
	public static int getProducto(int[] numeros) {
		int producto = 1;
		for (int numero : numeros) {
			producto *= numero;
		}
		return producto;
	}
	
	public static long getProducto(long[] numeros) {
		long producto = 1L;
		for (long numero : numeros) {
			producto *= numero;
		}
		return producto;
	}
	
	public static double getProducto(double[] numeros) {
		double producto = 1.0;
		for (double numero : numeros) {
			producto *= numero;
		}
		return producto;
	}
	
	public static float getProducto(float[] numeros) {
		float producto = 1.0F;
		for (float numero : numeros) {
			producto *= numero;
		}
		return producto;
	}
	
	public static int getMayor(int[] numeros) {
		int mayor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		return mayor;
	}
	
	public static long getMayor(long[] numeros) {
		long mayor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		return mayor;
	}
	
	public static double getMayor(double[] numeros) {
		double mayor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		return mayor;
	}
	
	public static float getMayor(float[] numeros) {
		float mayor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		return mayor;
	}
	
	public static int getMenor(int[] numeros) {
		int menor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		return menor;
	}
	
	public static long getMenor(long[] numeros) {
		long menor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		return menor;
	}
	
	public static double getMenor(double[] numeros) {
		double menor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		return menor;
	}
	
	public static float getMenor(float[] numeros) {
		float menor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] < menor) {
				menor = numeros[i];
			}
		}
		return menor;
	}

	public static int[] ordenarMayor(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] < numeros[k]) {
					int valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
	public static long[] ordenarMayor(long[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] < numeros[k]) {
					long valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
	public static double[] ordenarMayor(double[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] < numeros[k]) {
					double valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
	public static float[] ordenarMayor(float[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] < numeros[k]) {
					float valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
	public static int[] ordenarMenor(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] > numeros[k]) {
					int valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
	public static long[] ordenarMenor(long[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] > numeros[k]) {
					long valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
	public static double[] ordenarMenor(double[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] > numeros[k]) {
					double valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
	public static float[] ordenarMenor(float[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int k = i + 1; k < numeros.length; k++) {
				if (numeros[i] > numeros[k]) {
					float valor = numeros[i];
					numeros[i] = numeros[k];
					numeros[k] = valor;
				}
			}
		}
		return numeros;
	}
	
}
