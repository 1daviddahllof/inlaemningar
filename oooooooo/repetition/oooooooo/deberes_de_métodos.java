package oooooooo;

import java.util.Arrays;

public class deberes_de_m�todos {
	static int suma = 0;
	public static int la_suma(int[] n�meros) {
		if (n�meros.length > 0) {
			suma += n�meros[0];
			n�meros = Arrays.copyOfRange(n�meros, 1, n�meros.length);
			la_suma(n�meros);
		}
		return suma;
	}

}
