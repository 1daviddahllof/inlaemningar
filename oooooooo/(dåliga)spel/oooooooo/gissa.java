package oooooooo;

import java.util.Scanner;

public class gissa {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int random = 0;
		System.out.println("vill du inte testa supersv�ra 1 till 1000 challenge?");
		System.out.println("(ja), (nej)");

// h�r hittar vi ett random tiotal och ental och l�gger ihop dom f�r att skapa
// en int fr�n 0 till 99

		String svar = scn.nextLine();
		while (true) {
			if (svar.equals("ja")) {
				random = (int) (Math.random() * 1000);
				System.out.println("oj villken v�gh�st du �r");
				break;
			}
			
// h�r kommer ett random hundratal
			
			else if (svar.equals("nej")) {
				random = (int) (Math.random() * 100);
				break;
			}
		}
		random++;

//tidigare var  random 0 till 99 eller 0 till 999 s� vi l�gger till 1 f�r att jag vill

		System.out.println("hur m�nga f�rs�k skaru ha?");
		int f�rs�k = scn.nextInt();
		System.out.println("gissa talet din j�vel");
		do {
			System.out.println("f�rs�k som �r kvar: " + f�rs�k);
			int gissningen = scn.nextInt();

// h�r kommer en gissning

			if (gissningen > random) {
				System.out.println("f�r h�gt");
			} else if (gissningen < random) {
				System.out.println("f�r l�gt");
			} else {
				System.out.println("n�men grattis p� dig d�, det var " + random);
				break;
			}
// h�r j�mf�rs gissningen om den �r st�rre �n mindre �n eller lika med random
// om gissningen �r lika med random skriver den ett grattis och tar sig ur loopen
			
			f�rs�k--;

// efter varje iteration blir f�rs�k mindre och om f�rs�k n�t 0 innan gissningen 
// �r random s� slutar loopen

		} while (f�rs�k != 0);
		if (f�rs�k == 0) {
			System.out.println("n�men vad synd att dina f�rs�k tog slut");
		}

// om f�rs�k n�dde 0 f�r du ett speciellt meddelande f�r f�rlorare

		scn.close();
	}

}