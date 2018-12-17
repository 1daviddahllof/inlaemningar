package oooooooo;
import java.util.Scanner;
public class Speed_Limit {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		while (true) {
			int n = scn.nextInt();
			if (n<0) {
				break;
			}
			int out = 0;
			int h = 0;
			for (int x = 0; x<n; x++) {
				int s = scn.nextInt();
				int t = scn.nextInt();

				out+=s*(t-h);
				h=t;
			}
			
			System.out.println(out+" miles");
		}
		scn.close();
	}

}
