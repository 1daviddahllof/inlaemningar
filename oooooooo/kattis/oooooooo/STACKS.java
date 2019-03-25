package oooooooo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class STACKS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		ArrayList<Integer> st = new ArrayList<Integer>();
		st.add(2);
		st.add(-1);
		for (int x = 1; x <= N; x++) {
			st.add(scn.nextInt());
		}

		ArrayList<ArrayList<Integer>> actions = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Boolean>> act = new ArrayList<ArrayList<Boolean>>();
		ArrayList<Boolean> s = new ArrayList<Boolean>();
		s.add(false);
		s.add(false);
		s.add(false);
		act.add(s);
		actions.add(st);
		int moves = 0;

		search: while (true) {
			moves++;
		//	scn.nextLine();
			int opsie = actions.size();
			for (int x = 0; x < opsie; x++) {
				
				ArrayList<Integer> sn = new ArrayList<Integer>();
				sn.addAll(actions.get(0));
				ArrayList<Boolean> snot = new ArrayList<Boolean>();
				snot.addAll(act.get(0));
				int end = sn.size(), in = sn.get(0), fl = sn.get(1);
				boolean actiona = snot.get(0), actionb = snot.get(1), actionc = snot.get(2);

				if (!actiona) {
					ArrayList<Boolean> snot2 = new ArrayList<Boolean>(Collections.nCopies(3, false));
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
					sn2.addAll(sn);
					
					if (in == end) {
					
						sn2.add(1);
						sn2.set(1, -1);
						snot2.set(0, true);
						actions.add(sn2);
						act.add(snot2);


					} else if (!(fl == -1 && sn.get(in) < 1)) {
					
						sn2.set(in, sn2.get(in) + fl);
						sn2.set(1, fl * -1);
						snot2.set(0, true);
						actions.add(sn2);
						act.add(snot2);
		
					}
					if (finish(sn2)) {
						break search;
					}
				}
				if (!actionb) {
					if (in != 2) {
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
		int last = now.size() - 1;
		if (now.get(last) == 0) {
			now.remove(last);
			last--;
		}
		boolean done = true;
		int that = now.get(2);
		for (int u = 3; u <= last; u++) {
			if (now.get(u) != that) {
				done = false;
				break;
			}
		}
		
		return done;
	}
	
}
