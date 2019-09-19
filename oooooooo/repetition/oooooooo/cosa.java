package oooooooo;

import java.util.Scanner;

public class cosa {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String tres = "tres";
		while (true) {
			tres = deberes_de_métodos.reverse(tres);
			System.out.print(tres);
			
			if (sc.next().equals("no")) {
				break;
			}
		}
	}

}

