package oooooooo;

import java.util.Arrays;

public class deberes_de_m�todos {
	
	static int suma = 0;
	public static int laSuma(int[] n�meros) {
		if (n�meros.length > 0) {
			suma += n�meros[0];
			n�meros = Arrays.copyOfRange(n�meros, 1, n�meros.length);
			laSuma(n�meros);
		}
		return suma;
	}
	
	static String atr�s = "";
	public static String Cuerda(String cuerda) {
		int longitud = cuerda.length();
		if (longitud > 0) {
			atr�s = cuerda.charAt(0) + atr�s;
			cuerda = cuerda.substring(1, longitud);
			Cuerda(cuerda);
		}
		return atr�s;
	}
}
