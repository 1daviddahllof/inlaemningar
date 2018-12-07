package oooooooo;
import java.util.Scanner;

public class metod {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		
		System.out.println(sjorovare(scn.nextLine()));
		System.out.println(count(scn.nextLine(), scn.nextLine().charAt(0)));
		System.out.println(reverse(scn.nextLine()));
		System.out.println(volume(scn.nextDouble()));
		scn.close();
		}
		
	
		public static double volume(double radius) {
			double volume = 4/3*Math.PI*Math.pow(radius, 3);
			return volume;
			}
		public static String reverse(String str) {
			int fort = str.length();
			String ut = "";
			for (int x = 0;x<fort;x++) {
				ut = ut+str.charAt(fort-x-1);
			}
			return ut;
		}
		public static int count(String str, char c) {
			int out=0;
			for (int x=0;x<str.length();x++) {
				if (str.charAt(x)==c) {
					out = out+1;
				}
			}
			return out;
		}
		public static String sjorovare(String str) {
			for (int x=0;x<str.length();x++) {
				if (str.charAt(x)=='b' || str.charAt(x)=='c' || str.charAt(x)=='d' || str.charAt(x)=='f' || str.charAt(x)=='g' || str.charAt(x)=='h' || str.charAt(x)=='j' || str.charAt(x)=='k' || str.charAt(x)=='l' || str.charAt(x)=='m' || str.charAt(x)=='n' || str.charAt(x)=='p' || str.charAt(x)=='q' || str.charAt(x)=='r' || str.charAt(x)=='s' || str.charAt(x)=='t' || str.charAt(x)=='v' || str.charAt(x)=='x' || str.charAt(x)=='y' || str.charAt(x)=='z' ){
					str = str.substring(0, x+1)+"o"+str.charAt(x)+str.substring(x+1);
					x=x+2;
				}
				
			}
			return str;
		}
	}
