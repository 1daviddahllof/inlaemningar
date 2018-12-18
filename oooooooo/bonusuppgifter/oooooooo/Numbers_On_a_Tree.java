package oooooooo;
import java.util.Scanner;
import static java.lang.Math.toIntExact;
public class Numbers_On_a_Tree {

	public static void main(String[] args) {
		Scanner scn  =  new Scanner(System.in);
		int H = scn.nextInt();
		String path = scn.next();
		int n = 1;
		for (double x = 1; x<=H; x++) {
			n+=toIntExact(Math.round(Math.pow(2, x)));
		}
		System.out.println(n);
		scn.close();
	}

}
