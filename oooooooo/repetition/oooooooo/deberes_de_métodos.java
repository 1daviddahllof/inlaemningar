package oooooooo;

import java.util.Arrays;

public class deberes_de_métodos {
	
	static int suma = 0;
	public static int laSuma(int[] números) {
		if (números.length > 0) {
			suma += números[0];
			números = Arrays.copyOfRange(números, 1, números.length);
			laSuma(números);
		}
		return suma;
	}
	
	static String atrás = "";
	public static String Cuerda(String cuerda) {
		int longitud = cuerda.length();
		if (longitud > 0) {
			atrás = cuerda.charAt(0) + atrás;
			cuerda = cuerda.substring(1, longitud);
			Cuerda(cuerda);
		}
		return atrás;
	}
}
