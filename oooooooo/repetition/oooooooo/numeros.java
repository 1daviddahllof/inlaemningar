package oooooooo;

import java.util.Scanner;

public class numeros {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int elnumero = scn.nextInt();
		maneraEstrango:
		while(true) {
			for (int i = 2; i < elnumero; i++) {
				if (elnumero%i == 0) {
					System.out.print("falso");
					break maneraEstrango;
				}
			}
			System.out.print("verdad");
			break maneraEstrango;
		}
		
	}

}
