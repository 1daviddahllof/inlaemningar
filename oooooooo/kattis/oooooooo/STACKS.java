package oooooooo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class STACKS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// här läses positionerna av lådorna in
		int N = scn.nextInt();
		ArrayList<Integer> st = new ArrayList<Integer>();
		st.add(2);
		st.add(-1);
		for (int x = 1; x <= N; x++) {
			st.add(scn.nextInt());
		}

		ArrayList<ArrayList<Integer>> actions = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Boolean>> act = new ArrayList<ArrayList<Boolean>>();
		ArrayList<Boolean> s = new ArrayList<Boolean>(Collections.nCopies(3, false));
		act.add(s);
		actions.add(st);
		int moves = 0;

		// jag använde den mycket smarta metoden att bara testa varje steg
		// funkar bara när det inte behövs många drag, eftersom de möjliga steg
		// som testas växer exponensiellt
		search: while (true) {
			moves++;
		//	moves räknar iterationer och en iteration representerar ett steg
			int opsie = actions.size();
			for (int x = 0; x < opsie; x++) {
		// här går vi igenom alla index i arraylistan actions
		// actions är de positionerna som actions kan ha nu
				ArrayList<Integer> sn = new ArrayList<Integer>();
				sn.addAll(actions.get(0));
				ArrayList<Boolean> snot = new ArrayList<Boolean>();
				snot.addAll(act.get(0));
				int end = sn.size(), in = sn.get(0), fl = sn.get(1);
				boolean actiona = snot.get(0), actionb = snot.get(1), actionc = snot.get(2);
				
		// för varje action finns det en till arraylist som bestämmer om ett steg
		// är onödigt att testa
		// actiona är att kranen tar eller ger en låda
				if (!actiona) {
					ArrayList<Boolean> snot2 = new ArrayList<Boolean>(Collections.nCopies(3, false));
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
		// jag använder en kopia av  actions.get(0) eller (sn), sn2 som vi ändrar
		// och sedan lägger till i actions
					sn2.addAll(sn);
					
					if (in == end) {
					
						sn2.add(1);
						sn2.set(1, -1);
						snot2.set(0, true);
						actions.add(sn2);
						act.add(snot2);
		// I actionc har jag försäkrat att om positionen av kranen (sn.get(0)) är lika
		// med storleken är fl ett, fl är -1 om kranen är tom och 1 om den håller en låda
		// detta betyder att om vi kör actiona can vin skapa en ny position i sn och ge
		// den värdet 1

					} else if (!(fl == -1 && sn.get(in) < 1)) {
		// ifsatsen ser till att vi inte tar en låda om antalet lådor är noll
		// annars tar vi eller lägger till en låda beroende på fl, och ändrar fl i
		// sn2
						sn2.set(in, sn2.get(in) + fl);
						sn2.set(1, fl * -1);
						snot2.set(0, true);
						actions.add(sn2);
						act.add(snot2);
		
					}
		// om sn2 är balanserad slutar programmet
					if (finish(sn2)) {
						break search;
					}
				}
				if (!actionb) {
					if (in != 2) {
		// actionb flyttar kranen till vänster om kranen inte redan är längst
		// till vänster
						ArrayList<Boolean> snot2 = new ArrayList<Boolean>(Collections.nCopies(3, false));
						ArrayList<Integer> sn2 = new ArrayList<Integer>();
						sn2.addAll(sn);
						sn2.set(0, in - 1);
						snot2.set(2, true);
						actions.add(sn2);
						act.add(snot2);
					}
				}
				if (!actionc) {
		// actionc flyttar kranen till höger om kranen inte är ett steg till höger
		// om lådorna eller över lådan längst till höger och utan en låda
					ArrayList<Boolean> snot2 = new ArrayList<Boolean>(Collections.nCopies(3, false));
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
					sn2.addAll(sn);
					if (in >= end - 1) {
						if (in != end) {
							if (fl == 1) {
								sn2.set(0, in + 1);
								snot2.set(1, true);
								actions.add(sn2);
								act.add(snot2);
							}
						}
					} else {
						sn2.set(0, in + 1);
						snot2.set(1, true);
						actions.add(sn2);
						act.add(snot2);
					}
				}
		// för att inte datorn ska sprängas tar vi bort actions.get(0) så att den
		// inte testar samma sak varje gång
				actions.remove(0);
				act.remove(0);
			}

		}
		System.out.println(moves);
	}

	public static boolean finish(ArrayList<Integer> now) {
		if (now.get(1) == 1) {
			return false;
		}
	// kranen får inte ha en låda om den är klar
		int last = now.size() - 1;
		if (now.get(last) == 0) {
			now.remove(last);
			last--;
		}
	// nollor längst till höger räknas som tomma
	// det kan högst vara en eftersom vi gör det här efter varje actiona
		boolean done = true;
		int that = now.get(2);
		for (int u = 3; u <= last; u++) {
			if (now.get(u) != that) {
				done = false;
				break;
			}
		}
	// om alla värden inte är samma är vi inte klara
		
		return done;
	}
	
}
