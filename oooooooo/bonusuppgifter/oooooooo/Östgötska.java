package oooooooo;
import java.util.Scanner;
public class Östgötska {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		double wordcount = 0;
		double ae = 0;
		String t = scn.nextLine();
		while (t.contains(" ")) {
			if (t.contains("ae")) {
				ae++;
				}
			wordcount++;
			t = t.substring(t.indexOf(" ")+1, t.length());
		}
		
		
		Double p = ae/wordcount;
		if (p>=0.4) {
			System.out.println("dae ae ju traeligt va");
		}
		else {
			System.out.println("haer talar vi rikssvenska");
		}
		scn.close();
	}

}
