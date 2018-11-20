package oooooooo;
import java.util.Scanner;
public class sak_the_revengence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("en integer tack");
		int t = scn.nextInt();
		for (int x = 1; x<=t; x++) {
			for (int y = x; y>0; y--) {
				System.out.print("x");
			}
			System.out.println();
		}
	}

}
