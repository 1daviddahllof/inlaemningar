package oooooooo;

public class anim�les {
	public static void main(String[] args) {
		Conejo conejo = new Conejo();
		conejo.eat(new Vegetal());
		Humano humano = new Humano();
		humano.eat(new Vegetal());
		humano.eat(new Carne());
		
	}
}
abstract class Anim�l {
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
class Le�n extends Anim�l{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {new Carne()};
		return gusto;
	}
}

class Conejo extends Anim�l{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {new Vegetal()};
		return gusto;
	}
}
class Humano extends Anim�l{
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