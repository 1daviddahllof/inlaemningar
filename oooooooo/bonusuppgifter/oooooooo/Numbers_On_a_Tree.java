package oooooooo;
import java.util.Scanner;
import static java.lang.Math.toIntExact;
public class Numbers_On_a_Tree {

	public static void main(String[] args) {
		Scanner scn  =  new Scanner(System.in);
		String as = scn.nextLine();
		int H = Character.getNumericValue(as.charAt(0));
		int n = 0;
		for (double x = 0; x<=H; x++) {
			n+=toIntExact(Math.round(Math.pow(2, x)));
		}
		int fn = 1;
		int svr = n;
		if (as.length()>2) {
			String path = as.substring(2);
			System.out.println(path);
			for (int x = 0; x<path.length();x++) {
				int L = toIntExact(Math.round(Math.pow(2, x+1)));
				int[] row = new int[L];
				for (int x2 = 1; x2<=L; x2++) {
					row[x2-1]=n-x2;
				}
				char p = path.charAt(x);
				if (p=='L') {
					fn*=2;
				 	fn-=1;
				}
				else if (p=='R') {
					fn*=2;
				}
				svr = row[fn-1];
				n-=L;
			}
		}
		scn.close();
		System.out.println(svr);
	}

}
