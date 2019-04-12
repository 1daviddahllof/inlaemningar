package oooooooo;

import java.util.Scanner;

public class vafan {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		String o = "";
		do {
		o = scn.nextLine();
		if (hängande_av_gubbe.answer(o)) {
			continue;
		} else {
			break;
		}
		
		} while (true);
		System.out.println(hängande_av_gubbe.answer(o));
	}

}
