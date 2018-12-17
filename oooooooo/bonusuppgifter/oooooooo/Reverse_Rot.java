package oooooooo;
import java.util.Scanner;
public class Reverse_Rot {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		String abcd = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
		while (true) {
			int N = scn.nextInt();
			if (N==0) {
				break;
			}
			String secret = scn.next();
			int l = secret.length();
			String ut = "";
			for (int x = 0;x<l;x++) {
				ut = ut+secret.charAt(l-x-1);
			}
			String stronk = "";
			for (int x = 0; x<l; x++) {
				char t = ut.charAt(x);
				int index = abcd.indexOf(t)+N;
				while (index>=abcd.length()) {
					index-=abcd.length();
				}
				stronk+=abcd.charAt(index);
			}
			System.out.println(stronk);
		}

	}

}
