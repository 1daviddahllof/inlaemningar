package oooooooo;

public class animáles {
	public static void main(String[] args) {
		
		
		
	}
}
abstract class Animál {
	 abstract Comida[] gusto();
	 void eat(Comida comida) {
		 Comida[] gusto = gusto();
		 for (int i = 0; i < gusto.length; i++) {
			 if (gusto[i].getClass() == comida.getClass()) {
				 System.out.print("me gusta ");
				 return;
			 }
		 }
		 System.out.print("no me gusta ");
	 }
	
}
class León extends Animál{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {};
		return gusto;
	}
}

class Conejo extends Animál{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {};
		return gusto;
	}
}
class Humano extends Animál{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {};
		return gusto;
	}
 }

abstract class Comida {
}
class Carne extends Comida{
	class Filete {
		
	}
	Filete filete;
}
class Vegetal extends Comida{
class Zanahoria {
		
	}

}