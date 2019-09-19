package oooooooo;

import java.util.ArrayList;
import java.util.Arrays;

public class deberes_de_métodos {

	

	public static int laSuma(int[] números) {
		int fin = números.length - 1;
		if (fin == 0) {
			return números[0];
		}
		return laSuma(Arrays.copyOf(números, números.length - 1)) + números[fin];
	}

	public static String atrás(String cuerda) {
	    if ((null == cuerda) || (cuerda.length() <= 1)) {
	        return cuerda;
	    }
	    return atrás(cuerda.substring(1)) + cuerda.charAt(0);
	}

	public static Object[] objectos(Object... fin) {
		ArrayList<Object> cosas = new ArrayList<Object>();
		for (Object cosa : fin) {
			cosas.add(cosa);
		}
		return cosas.toArray();
	}

	public static void anagramas(String palabra) {
		ArrayList<String> anagramas = new ArrayList<String>();
		if (anagramas )
		
		for (int iterador = 0; iterador < anagramas.size(); iterador++) {
			System.out.print(anagramas.get(iterador));
		}
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
