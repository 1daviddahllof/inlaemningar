package oooooooo;
import java.util.Scanner;
public class been_everywhere {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		for (int p = scn.nextInt(); p>0; p--) {
			while (!scn.hasNextInt()) {
				scn.nextLine();
			}
			int nl = scn.nextInt();
			String[] lo = new String[nl];
			for (int x = 0; x<nl; x++) {
				lo[x]=scn.next();
				scn.nextLine();
			}
			String[] unika = new String[nl];
			int svar = 0;
			for (int x = 0; x<nl; x++) {
				boolean ja = true;
				for (int y = 0; y<svar; y++) {
					if (unika[y].equals(lo[x])) {
						ja = false;
					}
				}
				if (ja) {
					unika[svar]=lo[x];
					svar++;
				}
			}
			System.out.println(svar);
		}
		scn.close();
	}
}