package oooooooo;

public class fibonacci {

	public static void main(String[] args) {
		m�todo();
	}
	private static void m�todo() {
		int[] cuenta = {1, 1};
		for (int i = 0; i < 50; i++) {
			int provisoria = cuenta[1];
			cuenta[1] = provisoria + cuenta[0];
			cuenta[0] = provisoria;
		}
		double numero = cuenta[1]/cuenta[0];
		System.out.print(numero);
	}
}
