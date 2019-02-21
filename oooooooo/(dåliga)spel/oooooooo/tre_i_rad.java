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
//	här fyller vi alla positionerna med T, för tom

		System.out.println("T|T|T 1 2 3");
		System.out.println("_|_|_ ");
		System.out.println("T|T|T 4 5 6");
		System.out.println("_|_|_");
		System.out.println("T|T|T 7 8 9");

		int count = 0;
		while (true) {
			
// spelet fortsätter tills det når en break längre ner

			int inx, iny;
			boolean odd;

			while (true) {
// denna loopen når en break om imputen motsvarar en position på spelet som 
// är T, för tom

				inx = scn.nextInt();
				odd = false;
				if (inx % 2 != 0) {
					odd = true;
				}
// vi kommer att behöva veta om talet är udda senare

				iny = 0;
				while (inx > 3) {
					inx -= 3;
					iny++;
				}
				inx--;
// här blir inputsiffran tvår kordinater som motsvarar positionen som spelaren
// valde

				if (c[inx][iny] == 'T') {
					break;
				} else {
					System.out.println("den finns redan, ta någon annan");
				}
// om denna position är tom så stoppar loopen annars ger den dig ett 
// felmedelande och börjar om

			}
			c[inx][iny] = 'O';
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					System.out.print(c[x][y]);
				}
				System.out.println();
			}
			System.out.println();
// nu placeras ett O på rätt plats och en aktuell spelplan visas

			if (tre(c, odd, inx, iny, 'O')) {
				System.out.println("du är en dålig vinnare");
				break;
			}

// tre är en metod längst ner i koden som hitter tre i rad			

			count++;
			System.out.println(count);
			if (count == 5) {
				System.out.println("nu vann ingen");
				break;
			}
			
// här slutar spelet om planen är fylld
			
			int rx, ry;
			do {
				rx = (int) (Math.random() * 3);
				ry = (int) (Math.random() * 3);
			} while (c[rx][ry] != 'T');
// här hittar vi slumpmässiga kordinater och börjar om om platsen inte är tom

			c[rx][ry] = 'X';
			int X = rx + 1;
			int ryt = ry;
			while (ryt > 0) {
				ryt--;
				X += 3;
			}
			odd = false;
// jag undrar hur nödvändigt det var att se om vi ska testa för
// diagonal vinst på detta sätt, så här men aja

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
				System.out.println("du är så dålig att det är bättre att slumpa");
				break;
			}
			
			
		}
	}

	public static boolean tre(char[][] c, boolean odd, int x, int y, char find) {

		// om row är sann betyder det att datorn inte hittade något annat än ett O på
		// den horisontella axeln där du placerade O:et och du vinner

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

		// här händer samma sak fast för vertikala axeln

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

// om talet är udda är det möjligt en diagonal vinst möjlig

		if (odd) {

// Om vi lägger till ett tal på x och y eller tar bort talet fån x och y får vi
// en position som ligger diagonalt till punkten x, y,
// i detta fallet är y axeln baklänges och därför blir denna diagonal från
// vänstra hörnet högst upp till högra hörnet längst ner.
// Vi glömmer att räkna O:et som vi redan vet om och testar om dom andra också är
// O om den hittar två betyder det att det är tre i rad

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

			// här är samma sak men med den paralella diagonalen

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