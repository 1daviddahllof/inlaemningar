package oooooooo;

import java.util.Scanner;

public class el_menor {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("damelos");
		int[] losDos = new int[2];
		for(int i = 0; i < 2; i++) {
			losDos[i] = scn.nextInt();
		}
		if (losDos[0] > losDos[1]) {
			System.out.print(losDos[0]);
		} else {
			System.out.print(losDos[1]);
		}

	}

}
