package oooooooo;

import java.util.ArrayList;
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

	public static int m�todoFactorialDeMierda(int entreda) {
		int diosM�o = 1;
		while (entreda > 1) {
			diosM�o *= entreda;
			entreda--;
		}
		return diosM�o;
	}
}

class caja {
	Object[] matrizDeObjectos;

	public caja(Object... fin) {
		// jag kan inte hitta ett s�tt att anv�nda objectos metoden h�r s� jag kopierade
		// in den ist�llet som du ser
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
