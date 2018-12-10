package oooooooo;
import java.util.Scanner;
import java.util.ArrayList;
public class what_does_the_fox_say {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int ö = scn.nextInt();
		for (int x = 0; x<ö; x++) {
			scn.nextLine();
			String s = " "+scn.nextLine();
			ArrayList<String> go = new ArrayList<String>();
			while (true) {
				String kom = scn.nextLine();	
				if (kom.contains("what does")) {
					break;
				}
				go.add(kom);
			}
			for (String goat : go) {
				int l = 0;
				for (int x2 = 0; x2<goat.length(); x2++) {
					if (goat.charAt(x2)==' ') {
						l++;
					}
					if (l==2) {
						l=x2;
						break;
					}
				}
				goat = goat.substring(l, goat.length());
				while (s.contains(goat)) {
					int io = s.indexOf(goat);
					int goatlength = goat.length();
					s = s.substring(0, io)+s.substring(io+goatlength, s.length());
				}
			}
			System.out.println(s);
		}
		
	}

}
