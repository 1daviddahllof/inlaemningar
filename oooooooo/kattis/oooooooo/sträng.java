package oooooooo;

import java.util.ArrayList;
import java.util.Scanner;

public class str�ng {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		ArrayList<String> po = new ArrayList<String>();

// x i den f�rsta loopen �r l�ngden av stringen som testas
// y i den andra loopen �r startpunkten p� den string som testas
// x b�rjar litet och sen h�js, s� att vi hittar de minsta stringarna som funkar f�rst
		for (int x = 1; x <= s.length(); x++) {
			for (int y = 0; y <= s.length() - x; y++) {
				String maybe = s.substring(y, y + x);
				String temp = s;
				while (temp.contains(maybe)) {
					temp = temp.replaceAll(maybe, "");
// om stringen "maybe" finns i stringen tar vi bort den tills det inte finns n�gon maybe i stringen
// om vi inte har n�gon char kvar vet vi att maybe kan skapa stringen s

					if (temp.length() == 0) {
						po.add(maybe);
					}
				}
			}
			if (po.size() > 0) {
				break;
			}
		}
		

// po har alla m�jliga svar och d�rf�r sorterar vi dom i alfabetsordning och tar
// det f�rsta i fall vi m�ste v�lja mellan flera svar.
// Jag �r inte s�ker p� hur det kan vara m�jligt att det finns mer �n ett svar
//  men det st�r att man ska gj�ra s� h�r
		java.util.Collections.sort(po);
		System.out.println(po.get(0));

		scn.close();
	}
}
