package oooooooo;

import java.util.Scanner;

public class gissa {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int random = 0;
		System.out.println("vill du inte testa supersvåra 1 till 1000 challenge?");
		System.out.println("(ja), (nej)");

// här hittar vi ett random tiotal och ental och lägger ihop dom för att skapa
// en int från 0 till 99

		String svar = scn.nextLine();
		while (true) {
			if (svar.equals("ja")) {
				random = (int) (Math.random() * 1000);
				System.out.println("oj villken våghäst du är");
				break;
			}
			
// här kommer ett random hundratal
			
			else if (svar.equals("nej")) {
				random = (int) (Math.random() * 100);
				break;
			}
		}
		random++;

//tidigare var  random 0 till 99 eller 0 till 999 så vi lägger till 1 för att jag vill

		System.out.println("hur många försök skaru ha?");
		int försök = scn.nextInt();
		System.out.println("gissa talet din jävel");
		do {
			System.out.println("försök som är kvar: " + försök);
			int gissningen = scn.nextInt();

// här kommer en gissning

			if (gissningen > random) {
				System.out.println("för högt");
			} else if (gissningen < random) {
				System.out.println("för lågt");
			} else {
				System.out.println("nämen grattis på dig då, det var " + random);
				break;
			}
// här jämförs gissningen om den är större än mindre än eller lika med random
// om gissningen är lika med random skriver den ett grattis och tar sig ur loopen
			
			försök--;

// efter varje iteration blir försök mindre och om försök nåt 0 innan gissningen 
// är random så slutar loopen

		} while (försök != 0);
		if (försök == 0) {
			System.out.println("nämen vad synd att dina försök tog slut");
		}

// om försök nådde 0 får du ett speciellt meddelande för förlorare

		scn.close();
	}

}