package oooooooo;
import java.util.Scanner;
public class tres {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] palabras = hacerlo();
		decirlo(palabras);
	}
	
	public static String[] hacerlo(){
		Scanner scn = new Scanner(System.in);
		String[] palabras = new String[3];
		for (int i = 0; i < 3; i++) {
			palabras[i] = scn.next();
		}
		return palabras;
	}
	public static void decirlo(String[] palabras){
		for (int i = 2; i >= 0; i--) {
			for (int i2 = palabras[i].length() - 1; i2 >= 0; i2--) {
				System.out.print(palabras[i].charAt(i2));
			}
			System.out.println();
		}
	}
}
