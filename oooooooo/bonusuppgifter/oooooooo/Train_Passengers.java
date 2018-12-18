package oooooooo;
import java.util.Scanner;
public class Train_Passengers {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int C = scn.nextInt();
		int n = scn.nextInt();
		int w = 0;
		boolean possible = true;
		for (int x = 0; x<n; x++) {
			int left = scn.nextInt();
			int enter = scn.nextInt();
			int wait = scn.nextInt();
			if (w-left<0) {
				possible = false;
				break;
			}
			w-=left;
			if (enter+w>C) {
				possible = false;
				break;
			}
			w+=enter;
			if (w<C && wait>0) {
				possible = false;
				break;
			}
		}
		scn.close();
		if (!possible) {
			System.out.println("impossible");
		}
		else if (w>0) {
			System.out.println("impossible");
		}
		else {
			System.out.println("possible");
		}
	}

}
