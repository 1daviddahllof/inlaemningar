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

	public static String reverse(String str) {
	    if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    return reverse(str.substring(1)) + str.charAt(0);
	}

	public static Object[] objectos(Object... fin) {
		ArrayList<Object> cosas = new ArrayList<Object>();
		for (Object cosa : fin) {
			cosas.add(cosa);
		}
		return cosas.toArray();
	}

	static ArrayList<String> anagramas = new ArrayList<String>();

	public static void anagramas(String palabra) {

	}

	public static int métodoFactorialDeMierda(int entreda) {
		int diosMío = 1;
		while (entreda > 1) {
			diosMío *= entreda;
			entreda--;
		}
		return diosMío;
	}
}

class caja {
	Object[] matrizDeObjectos;

	public caja(Object... fin) {
		// jag kan inte hitta ett sätt att använda objectos metoden här så jag kopierade
		// in den istället som du ser
		ArrayList<Object> cosas = new ArrayList<Object>();
		for (Object cosa : fin) {
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
