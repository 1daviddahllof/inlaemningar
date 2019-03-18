package oooooooo;

import java.util.ArrayList;
import java.util.Scanner;

public class STACKS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		ArrayList<Integer> st = new ArrayList<Integer>();
		for (int x = 0; x < N; x++) {
			st.add(scn.nextInt());
		}
		ArrayList<ArrayList<Integer>> actions = new ArrayList<ArrayList<Integer>>();
		for (int x = 1; x <= 3; x++) {
			ArrayList<Integer> thing = new ArrayList<Integer>();
			thing.add(x);
			actions.add(thing);
		}
		int moves = 0;
		while (true) {
			moves++;
			int opsie = actions.size();
			for (int x = 0; x < opsie; x++) {
				for (int z = 1; z <= 3; z++) {
					ArrayList<Integer> t = actions.get(0);
					t.add(z);
					actions.add(t);
				}
				actions.remove(0);
			}
			
		}
	}
}
