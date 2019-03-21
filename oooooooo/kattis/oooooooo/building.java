package oooooooo;

import java.util.ArrayList;
import java.util.Scanner;

public class building {

	public static void main(String[] args) {

		// koden läser np rader
		// om det står namn entered och om denna person redan finns i "in" så skriver
		// den ANOMALY
		// annars lägger den till namn i "in"
		// om det står namn exited utan att namn finns i "in" skrivs ANOMALY ut

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
