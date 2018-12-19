package oooooooo;
import java.util.Scanner;
import java.util.ArrayList;
public class kitten_IN_a_tree {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int cat = scn.nextInt();
		ArrayList<ArrayList<Integer>> branchings = new ArrayList<ArrayList<Integer>>();
		scn.nextLine();
		while (true) {
			String in = scn.nextLine();
			if (in.charAt(0)=='-') {
				break;
			}
			ArrayList<Integer> branch = new ArrayList<Integer>();
			while (in.contains(" ")) {
				int i = in.indexOf(" ");
				branch.add(Integer.parseInt(in.substring(0, i)));
				in = in.substring(i+1);
			}
			branch.add(Integer.parseInt(in.substring(0)));
			branchings.add(branch);
		}
		System.out.print(cat+" ");
		while (true) {
			boolean sluta = true;
			for (int x = 0; x<branchings.size(); x++) {
				if (branchings.get(x).contains(cat)){
					if (branchings.get(x).indexOf(cat) != 0) {
						System.out.print(branchings.get(x).get(0)+" ");
						cat = branchings.get(x).get(0);
						sluta = false;
					}
				}
			}
			if (sluta) {
				break;
			}
		}
		scn.close();
	}

}
