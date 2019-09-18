package oooooooo;

import java.util.ArrayList;
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
	
	public static Object[] objectos(Object... fin) {
		ArrayList<Object> cosas = new ArrayList<Object>();
		for(Object cosa : fin) {
			cosas.add(cosa);
		}
		return cosas.toArray();
	}
	public static void anagramas(String palabra) {
		
	}
}
class caja {
	Object[] matrizDeObjectos;
	public caja(Object... fin) {
		// jag kan inte hitta ett sätt att använda objectos metoden här så jag kopierade in den istället som du ser
		ArrayList<Object> cosas = new ArrayList<Object>();
		for(Object cosa : fin) {
			cosas.add(cosa);
		}
		this.matrizDeObjectos = cosas.toArray();
	}
	
	public boolean comparador(caja cajaUno, caja cajaDos) {
		for (int i = 0; i < cajaUno.matrizDeObjectos.length; i++) {
			for (int i2 = 0; i2 < cajaDos.matrizDeObjectos.length; i2++) {
				if (cajaUno.matrizDeObjectos[i].getClass().equals(cajaDos.matrizDeObjectos[i2].getClass())) {
					return true;
				}
			}
		}
		return false;
	}	
}
	



