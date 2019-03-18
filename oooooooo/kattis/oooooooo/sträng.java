package oooooooo;

import java.util.ArrayList;
import java.util.Scanner;

public class sträng {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		ArrayList<String> po = new ArrayList<String>();

// x i den första loopen är längden av stringen som testas
// y i den andra loopen är startpunkten på den string som testas
// x börjar litet och sen höjs, så att vi hittar de minsta stringarna som funkar först
		for (int x = 1; x <= s.length(); x++) {
			for (int y = 0; y <= s.length() - x; y++) {
				String maybe = s.substring(y, y + x);
				String temp = s;
				while (temp.contains(maybe)) {
					temp = temp.replaceAll(maybe, "");
// om stringen "maybe" finns i stringen tar vi bort den tills det inte finns någon maybe i stringen
// om vi inte har någon char kvar vet vi att maybe kan skapa stringen s

					if (temp.length() == 0) {
						po.add(maybe);
					}
				}
			}
			if (po.size() > 0) {
				break;
			}
		}
		

// po har alla möjliga svar och därför sorterar vi dom i alfabetsordning och tar
// det första i fall vi måste välja mellan flera svar.
// Jag är inte säker på hur det kan vara möjligt att det finns mer än ett svar
//  men det står att man ska gjöra så här
		java.util.Collections.sort(po);
		System.out.println(po.get(0));

		scn.close();
	}
}
