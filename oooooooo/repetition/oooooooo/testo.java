package oooooooo;

public class testo {

	public static void main(String[] args) {
		persona alguien = new persona(2, "Carlos");
		persona otro = new persona(2, "juan");
		System.out.print(quien_tiene_mas_años(alguien, otro));
	}
	public static String quien_tiene_mas_años(persona n1, persona n2) {
		if (n1.edad > n2.edad) {
			return n1.nombre;
		} else if(n2.edad == n1.edad) {
			return "tienen lo mismo edad";
		} else {
			return n2.nombre;
		}
	}
}
