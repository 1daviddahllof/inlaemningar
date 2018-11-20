package oooooooo;
import java.util.Scanner;
public class saken_origins {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		System.out.println("hur många rader?");
		int rad = scn.nextInt();
		int bredd = rad*2-1;
		for (int x = 1; x<rad+1; x++) {
			for (int y = 0;y<(bredd-(x-1)*2-1)/2;y++) {
				System.out.print(" ");
			}
			for (int y = x;y>0;y--) {
				System.out.print("x"+" ");
			}
			System.out.println();
		}

	}

}
