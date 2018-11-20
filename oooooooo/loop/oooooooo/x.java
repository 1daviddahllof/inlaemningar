package oooooooo;
import java.util.Scanner;
public class x {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		double i1 = scn.nextDouble();
		double out = 0;
		while(i1!=0) {
			out+=i1;
			i1=scn.nextDouble();
		}
		System.out.println(out);

	}
}