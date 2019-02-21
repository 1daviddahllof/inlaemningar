package oooooooo;

import java.util.Scanner;

public class tre_i_rad {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] c = new char[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				c[x][y] = 'T';
			}
		}
//	h�r fyller vi alla positionerna med T, f�r tom

		System.out.println("T|T|T 1 2 3");
		System.out.println("_|_|_ ");
		System.out.println("T|T|T 4 5 6");
		System.out.println("_|_|_");
		System.out.println("T|T|T 7 8 9");

		int count = 0;
		while (true) {
			
// spelet forts�tter tills det n�r en break l�ngre ner

			int inx, iny;
			boolean odd;

			while (true) {
// denna loopen n�r en break om imputen motsvarar en position p� spelet som 
// �r T, f�r tom

				inx = scn.nextInt();
				odd = false;
				if (inx % 2 != 0) {
					odd = true;
				}
// vi kommer att beh�va veta om talet �r udda senare

				iny = 0;
				while (inx > 3) {
					inx -= 3;
					iny++;
				}
				inx--;
// h�r blir inputsiffran tv�r kordinater som motsvarar positionen som spelaren
// valde

				if (c[inx][iny] == 'T') {
					break;
				} else {
					System.out.println("den finns redan, ta n�gon annan");
				}
// om denna position �r tom s� stoppar loopen annars ger den dig ett 
// felmedelande och b�rjar om

			}
			c[inx][iny] = 'O';
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					System.out.print(c[x][y]);
				}
				System.out.println();
			}
			System.out.println();
// nu placeras ett O p� r�tt plats och en aktuell spelplan visas

			if (tre(c, odd, inx, iny, 'O')) {
				System.out.println("du �r en d�lig vinnare");
				break;
			}

// tre �r en metod l�ngst ner i koden som hitter tre i rad			

			count++;
			System.out.println(count);
			if (count == 5) {
				System.out.println("nu vann ingen");
				break;
			}
			
// h�r slutar spelet om planen �r fylld
			
			int rx, ry;
			do {
				rx = (int) (Math.random() * 3);
				ry = (int) (Math.random() * 3);
			} while (c[rx][ry] != 'T');
// h�r hittar vi slumpm�ssiga kordinater och b�rjar om om platsen inte �r tom

			c[rx][ry] = 'X';
			int X = rx + 1;
			int ryt = ry;
			while (ryt > 0) {
				ryt--;
				X += 3;
			}
			odd = false;
// jag undrar hur n�dv�ndigt det var att se om vi ska testa f�r
// diagonal vinst p� detta s�tt, s� h�r men aja

			if (X % 2 != 0) {
				odd = true;
			}
			char find = 'X';
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					System.out.print(c[x][y]);
				}
				System.out.println();
			}
			System.out.println();

			if (tre(c, odd, rx, ry, find)) {
				System.out.println("du �r s� d�lig att det �r b�ttre att slumpa");
				break;
			}
			
			
		}
	}

	public static boolean tre(char[][] c, boolean odd, int x, int y, char find) {

		// om row �r sann betyder det att datorn inte hittade n�got annat �n ett O p�
		// den horisontella axeln d�r du placerade O:et och du vinner

		boolean row = true;
		for (int x2 = 0; x2 < 3; x2++) {
			if (c[x2][y] != find) {
				row = false;
				break;
			}
		}
		if (row) {
			return true;
		}

		// h�r h�nder samma sak fast f�r vertikala axeln

		row = true;
		for (int y2 = 0; y2 < 3; y2++) {
			if (c[x][y2] != find) {
				row = false;
				break;
			}
		}
		if (row) {
			return true;
		}

// om talet �r udda �r det m�jligt en diagonal vinst m�jlig

		if (odd) {

// Om vi l�gger till ett tal p� x och y eller tar bort talet f�n x och y f�r vi
// en position som ligger diagonalt till punkten x, y,
// i detta fallet �r y axeln bakl�nges och d�rf�r blir denna diagonal fr�n
// v�nstra h�rnet h�gst upp till h�gra h�rnet l�ngst ner.
// Vi gl�mmer att r�kna O:et som vi redan vet om och testar om dom andra ocks� �r
// O om den hittar tv� betyder det att det �r tre i rad

			int count = 0;
			for (int x2 = 1; x2 < 3; x2++) {
				if (y + x2 < 3 && x + x2 < 3) {
					if (c[x + x2][y + x2] == find) {
						count++;
					}
				}
				if (y - x2 >= 0 && x - x2 >= 0) {
					if (c[x - x2][y - x2] == find) {
						count++;
					}
				}
			}
			if (count == 2) {
				return true;
			}

			// h�r �r samma sak men med den paralella diagonalen

			count = 0;
			for (int x2 = 1; x2 < 3; x2++) {
				if (x + x2 < 3 && y - x2 >= 0) {
					if (c[x + x2][y - x2] == find) {
						count++;
					}
				}
				if (x - x2 >= 0 && y + x2 < 3) {
					if (c[x - x2][y + x2] == find) {
						count++;
					}
				}
			}
			if (count == 2) {
				return true;
			}
		}
		return false;
	}
}