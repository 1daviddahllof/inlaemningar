package oooooooo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class STACKS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// h�r l�ses positionerna av l�dorna in
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

		// jag anv�nde den mycket smarta metoden att bara testa varje steg
		// funkar bara n�r det inte beh�vs m�nga drag, eftersom de m�jliga steg
		// som testas v�xer exponensiellt
		search: while (true) {
			moves++;
		//	moves r�knar iterationer och en iteration representerar ett steg
			int opsie = actions.size();
			for (int x = 0; x < opsie; x++) {
		// h�r g�r vi igenom alla index i arraylistan actions
		// actions �r de positionerna som actions kan ha nu
				ArrayList<Integer> sn = new ArrayList<Integer>();
				sn.addAll(actions.get(0));
				ArrayList<Boolean> snot = new ArrayList<Boolean>();
				snot.addAll(act.get(0));
				int end = sn.size(), in = sn.get(0), fl = sn.get(1);
				boolean actiona = snot.get(0), actionb = snot.get(1), actionc = snot.get(2);
				
		// f�r varje action finns det en till arraylist som best�mmer om ett steg
		// �r on�digt att testa
		// actiona �r att kranen tar eller ger en l�da
				if (!actiona) {
					ArrayList<Boolean> snot2 = new ArrayList<Boolean>(Collections.nCopies(3, false));
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
		// jag anv�nder en kopia av  actions.get(0) eller (sn), sn2 som vi �ndrar
		// och sedan l�gger till i actions
					sn2.addAll(sn);
					
					if (in == end) {
					
						sn2.add(1);
						sn2.set(1, -1);
						snot2.set(0, true);
						actions.add(sn2);
						act.add(snot2);
		// I actionc har jag f�rs�krat att om positionen av kranen (sn.get(0)) �r lika
		// med storleken �r fl ett, fl �r -1 om kranen �r tom och 1 om den h�ller en l�da
		// detta betyder att om vi k�r actiona can vin skapa en ny position i sn och ge
		// den v�rdet 1

					} else if (!(fl == -1 && sn.get(in) < 1)) {
		// ifsatsen ser till att vi inte tar en l�da om antalet l�dor �r noll
		// annars tar vi eller l�gger till en l�da beroende p� fl, och �ndrar fl i
		// sn2
						sn2.set(in, sn2.get(in) + fl);
						sn2.set(1, fl * -1);
						snot2.set(0, true);
						actions.add(sn2);
						act.add(snot2);
		
					}
		// om sn2 �r balanserad slutar programmet
					if (finish(sn2)) {
						break search;
					}
				}
				if (!actionb) {
					if (in != 2) {
		// actionb flyttar kranen till v�nster om kranen inte redan �r l�ngst
		// till v�nster
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
		// actionc flyttar kranen till h�ger om kranen inte �r ett steg till h�ger
		// om l�dorna eller �ver l�dan l�ngst till h�ger och utan en l�da
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
		// f�r att inte datorn ska spr�ngas tar vi bort actions.get(0) s� att den
		// inte testar samma sak varje g�ng
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
	// kranen f�r inte ha en l�da om den �r klar
		int last = now.size() - 1;
		if (now.get(last) == 0) {
			now.remove(last);
			last--;
		}
	// nollor l�ngst till h�ger r�knas som tomma
	// det kan h�gst vara en eftersom vi g�r det h�r efter varje actiona
		boolean done = true;
		int that = now.get(2);
		for (int u = 3; u <= last; u++) {
			if (now.get(u) != that) {
				done = false;
				break;
			}
		}
	// om alla v�rden inte �r samma �r vi inte klara
		
		return done;
	}
	
}
