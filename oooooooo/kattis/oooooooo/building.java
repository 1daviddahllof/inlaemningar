package oooooooo;

import java.util.ArrayList;
import java.util.Scanner;

public class building {

	public static void main(String[] args) {

		// koden l�ser np rader
		// om det st�r namn entered och om denna person redan finns i "in" s� skriver
		// den ANOMALY
		// annars l�gger den till namn i "in"
		// om det st�r namn exited utan att namn finns i "in" skrivs ANOMALY ut

		Scanner scn = new Scanner(System.in);
		int np = scn.nextInt();

		ArrayList<String> in = new ArrayList<String>();
		for (int x = 0; x < np; x++) {
			System.out.println();
			String name = scn.next();
			String ina = scn.next();
			if (ina.equals("exit")) {
				System.out.print(name + " exited");
				if (in.contains(name)) {
					in.remove(in.indexOf(name));
				} else {
					System.out.print(" (ANOMALY)");
				}
			} else {
				System.out.print(name + " entered");
				if (in.contains(name)) {
					System.out.print(" (ANOMALY)");
				} else {
					in.add(name);
				}
			}
		}

	}

}
