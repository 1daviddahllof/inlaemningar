package oooooooo;

import java.util.ArrayList;
import java.util.Arrays;

public class deberes_de_m�todos {

	public static int laSuma(int[] n�meros) {
		int fin = n�meros.length - 1;
		if (fin == 0) {
			return n�meros[0];
		}
		return laSuma(Arrays.copyOf(n�meros, n�meros.length - 1)) + n�meros[fin];
	}

	public static String atr�s(String cuerda) {
		if ((null == cuerda) || (cuerda.length() <= 1)) {
			return cuerda;
		}
		return atr�s(cuerda.substring(1)) + cuerda.charAt(0);
	}

	public static Object[] objectos(Object... fin) {
		ArrayList<Object> cosas = new ArrayList<Object>();
		for (Object cosa : fin) {
			cosas.add(cosa);
		}
		return cosas.toArray();
	}

//detta tog alltf�r l�nge f�r mig att lista ut
	public static void anagramas(String cuerda, String empeza) {
// l�mna bara empeza tom. Om du skriver n�got d�r kommer den stringen ligga i b�rjan av varje printad string
		if (cuerda.length() != 0) {
			for (int iterador = 0; iterador < cuerda.length(); iterador++) {
				anagramas(cuerda.substring(0, iterador) + cuerda.substring(iterador + 1),
						empeza + cuerda.charAt(iterador));
			}
		} else {
			System.out.println(empeza);
		}
	}
}

class caja {
	Object[] matrizDeObjectos;

	public caja(Object... fin) {
		// h�r har vi kopierad kod f�r att jag inte kommer p� n�got annat s�tt
		ArrayList<Object> algo = new ArrayList<Object>();
		for (Object ejemplo : fin) {
			algo.add(ejemplo);
		}
		this.matrizDeObjectos = algo.toArray();
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
