package oooooooo;

public class animáles {
	public static void main(String[] args) {
		Conejo conejo = new Conejo();
		conejo.eat(new Vegetal());
		Humano humano = new Humano();
		humano.eat(new Vegetal());
		humano.eat(new Carne());
		
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
		Comida[] gusto = {new Carne()};
		return gusto;
	}
}

class Conejo extends Animál{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {new Vegetal()};
		return gusto;
	}
}
class Humano extends Animál{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {new Vegetal(), new Carne()};
		return gusto;
	}
 }

abstract class Comida {
}
class Carne extends Comida{
	class Algo extends Comida {
	}
}
class Vegetal extends Comida{
}