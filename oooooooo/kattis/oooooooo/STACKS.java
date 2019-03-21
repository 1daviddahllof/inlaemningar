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
		actions.add(st);
		int moves = 0;
	    search: while (true) {
	    	String o = scn.nextLine();
	    	if (o.equals("1")) {
	    		break;
	    	}
			moves++;
			int opsie = actions.size();
			for (int x = 0; x < opsie; x++) {
				for (int g = 0; g < actions.get(0).size(); g++) {
					System.out.print(actions.get(0).get(g) + " ");
				}
				System.out.println();
				System.out.println();
				
				ArrayList<Integer> sn = new ArrayList<Integer>();
				sn.addAll(actions.get(0));
				int end = sn.size(), in = sn.get(0), fl = sn.get(1);
				
				if (in == end) {
					sn.add(1);
					sn.set(1, -1);
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
					sn2.addAll(sn);
					actions.add(sn2);
					
				}
				else if (!(fl == -1 && sn.get(in) < 1)) {
					sn.set(in, sn.get(in) + fl);
					sn.set(1, fl * -1);
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
					sn2.addAll(sn);
					actions.add(sn2);
					
				}
				if (finish(sn)) {
					break search;
				}
				for (int g = 0; g < sn.size(); g++) {
					System.out.print(sn.get(g) + " ");
				}
				System.out.println();
				sn.clear();
				sn.addAll(actions.get(0));
				
				if (in != 2) {
					sn.set(0, in - 1);
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
					
					sn2.addAll(sn);
					actions.add(sn2);
					
				}
				for (int g = 0; g < sn.size(); g++) {
					System.out.print(sn.get(g) + " ");
				}
				System.out.println();
				sn.clear();
				sn.addAll(actions.get(0));
				
				if (in >= end - 1) {
					if (in != end) {
						if (fl == 1) {
							sn.set(0, in + 1);
							ArrayList<Integer> sn2 = new ArrayList<Integer>();
							
							sn2.addAll(sn);
							actions.add(sn2);
							
						}
					}
				} else {
					sn.set(0, in + 1);
					ArrayList<Integer> sn2 = new ArrayList<Integer>();
					
					sn2.addAll(sn);
					actions.add(sn2);
					
				}
				for (int g = 0; g < sn.size(); g++) {
					System.out.print(sn.get(g) + " ");
				}
				System.out.println();
				actions.remove(0);
				
			}
			
		}
		System.out.println(moves);
	}

	public static boolean finish(ArrayList<Integer> now) {
		boolean done = true;
		int that = 0;
		int x = 2;
		while (that == 0) {
			that = now.get(x);
			x++;
		}
		if (now.get(1) == 1) {
			return false;
		}
		for (int u = 3; u < now.size(); u++) {
			if (now.get(u) != that && now.get(u) != 0) {
				done = false;
				break;
			}
		}
		return done;
	}
}
