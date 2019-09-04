package oooooooo;
import java.util.Scanner;
public class array {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] cosa  = new int[3];
		for (int i = 0; i < 3; i++) {
			cosa[i] = scn.nextInt();
		}
		int repuesta = 0;
		for (int i = 0; i < cosa.length; i++) {
			repuesta += cosa[i];
		}
		System.out.print(repuesta);
	}

}
