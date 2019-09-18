package oooooooo;

import java.util.Arrays;

public class deberes_de_métodos {
	static int suma = 0;
	public static int la_suma(int[] números) {
		if (números.length > 0) {
			suma += números[0];
			números = Arrays.copyOfRange(números, 1, números.length);
			la_suma(números);
		}
		return suma;
	}

}
