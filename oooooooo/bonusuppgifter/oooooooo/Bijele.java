package oooooooo;
import java.util.Scanner;
public class Bijele {

	public static void main(String[] args) {
		Scanner scn=new Scanner (System.in);
		int[] s = {1, 1, 2, 2, 2, 8};
		for (int x = 0; x<6; x++) {
			System.out.print(s[x]-scn.nextInt()+" "); 
		}
		scn.close();
	}

}
