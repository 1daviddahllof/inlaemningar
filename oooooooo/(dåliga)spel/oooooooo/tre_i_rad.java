package oooooooo;

import java.util.Scanner;

public class tre_i_rad {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] c = new char[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				c[x][y] = 'Z';
			}
		}
//	här fyller vi alla positionerna med T, för tom
		
		System.out.println("T|T|T 1 2 3");
		System.out.println("_|_|_ ");
		System.out.println("T|T|T 4 5 6");
		System.out.println("_|_|_");
		System.out.println("T|T|T 7 8 9");

		while (true) {
// spelet fortsätter tills det når en break längre ner
			
			int inx, iny;
			boolean odd;
		
			while (true) {
// denna loopen når en break om imputen motsvarar en position på spelet som 
// är T, för tom
				
				inx = scn.nextInt();
				odd = false;
				if (inx%2 != 0) {
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
				}
				else {
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
			
			boolean row = true;
			for (int x = 0; x<3; x++) {
				if (c[x][iny] != 'O') {
					row = false;
					break;
				}
			}
			if (row) {
				System.out.println("du är en vinnare eller nåt");
				break;
			}
// om row är sann betyder det att datorn inte hittade något annat än ett O på
// den horisontella axeln där du placerade O:et och du vinner
			
			row = true;
			for (int y = 0; y<3; y++) {
				if (c[inx][y] != 'O') {
					row = false;
					break;
				}
			}
			if (row) {
				System.out.println("du är en vinnare eller nåt");
				break;
			}
// här händer samma sak fast för vertikala axeln
			
			if (odd) {
// om talet är udda betyder det att det spelaren har valt en plats som kan vinna
// diagonalt
				
				int count = 0;
				for (int x = 1; x<3; x++) {
					if (iny+x<3 && inx+x<3) {
						if (c[inx+x][iny+x]=='O') {
							count++;
						}
					}
					if (iny-x>=0 && inx-x>=0) {
						if (c[inx-x][iny-x]=='O') {
							count++;
						}
					}
				}
				if (count == 2) {
					System.out.println("du är en vinnare eller nåt");
					break;
				}
				count = 0;
				for (int x = 1; x<3; x++) {
					if (inx+x<3 && iny-x>=0) {
						if (c[inx+x][iny-x]=='O') {
							count++;
						}
					}
					if (inx-x>=0 && iny+x<3) {
						if (c[inx-x][iny+x]=='O') {
							count++;
						}
					}
				}
				if (count == 2) {
					System.out.println("du är en vinnare eller nåt");
					break;
				}
			}
			boolean all = true;
			for (int x = 0; x<3; x++) {
				for (int y = 0; y<3; y++) {
					if (c[x][y] == 'T') {
						all = false;
						break;
					}
				}
			}
			if (all) {
				System.out.println("nu blev det lika");
				break;
			}
			int rx, ry;
			do {
				rx = (int) (Math.random()*3);
				ry = (int) (Math.random()*3);
			} while (c[rx][ry]!='T');
			int X = rx+1;
			int ryt = ry;
			while (ryt>0) {
				ryt--;
				X+=3;
			}
			odd = false;
			if (X%2 != 0) {
				odd = true;
			}
			c[rx][ry] = 'X';
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					System.out.print(c[x][y]);
				}
				System.out.println();
			}
			System.out.println();
			row = true;
			for (int x = 0; x<3; x++) {
				if (c[x][ry] != 'X') {
					row = false;
					break;
				}
			}
			if (row) {
				System.out.println("du är så dålig att det är bättre att slumpa");
				break;
			}
			row = true;
			for (int y = 0; y<3; y++) {
				if (c[rx][y] != 'X') {
					row = false;
					break;
				}
			}
			if (row) {
				System.out.println("du är så dålig att det är bättre att slumpa");
				break;
			}
			if (odd) {
				int count = 0;
				for (int x = 1; x<3; x++) {
					if (ry+x<3 && rx+x<3) {
						if (c[rx+x][ry+x]=='X') {
							count++;
						}
					}
					if (ry-x>=0 && rx-x>=0) {
						if (c[rx-x][ry-x]=='X') {
							count++;
						}
					}
				}
				if (count == 2) {
					System.out.println("du är så dålig att det är bättre att slumpa");
					break;
				}
				count = 0;
				for (int x = 1; x<3; x++) {
					if (rx+x<3 && ry-x>=0) {
						if (c[rx+x][ry-x]=='X') {
							count++;
						}
					}
					if (rx-x>=0 && ry+x<3) {
						if (c[rx-x][ry+x]=='X') {
							count++;
						}
					}
				}
				if (count == 2) {
					System.out.println("du är så dålig att det är bättre att slumpa");
					break;
				}
			}
		}
	}

}