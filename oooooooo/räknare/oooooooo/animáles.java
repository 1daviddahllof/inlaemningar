package oooooooo;

public class anim�les {
	public static void main(String[] args) {
		
		
		
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
		Comida[] gusto = {};
		return gusto;
	}
}

class Conejo extends Anim�l{
	@Override
	Comida[] gusto() {
		Comida[] gusto = {};
		return gusto;
	}
}
class Humano extends Anim�l{
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