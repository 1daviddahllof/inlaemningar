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
			System.out.print(palabras[i] + " ");
		}
	}
}
