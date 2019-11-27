package oooooooo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class main extends Application {
	TextFieldDeN�meros texto = new TextFieldDeN�meros();
	static boolean ERROR = false;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("t�tulo");
		primaryStage.show();
		primaryStage.setScene(new Scene(cr�aTodo(primaryStage), 400, 300));
	}

// initierar andra metoder som skapar en borderpane och en gridpane f�r att l�gga i en ny group som returnas.
	Group cr�aTodo(Stage primaryStage) {
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(texto);
		borderpane.relocate(120, 20);
		GridPane cuadr�cula = cr�aCuadr�cula1();

		return new Group(borderpane, cuadr�cula);
	}

// Skapar och ger attributer till en cuadr�cula och k�r metod som l�gger till knappar och sedan returnas den
	GridPane cr�aCuadr�cula1() {
		GridPane cuadr�cula = new GridPane();
		botondes(cuadr�cula);
		cuadr�cula.setHgap(40);
		cuadr�cula.setVgap(10);
		cuadr�cula.relocate(40, 60);
		return cuadr�cula;
	}

// Tar en gridpane och l�gger till knapparna med hj�lp av cr�aBot�n metoden
	void botondes(GridPane cuadr�cula) {
		Bot�n b7 = cr�aBot�n('7', new Escribirlo().c('7'));
		Bot�n b8 = cr�aBot�n('8', new Escribirlo().c('8'));
		Bot�n b9 = cr�aBot�n('9', new Escribirlo().c('9'));
		Bot�n ba = cr�aBot�n('+', new EscribirloDos().c('+'));
		Bot�n bc = cr�aBot�n('C', new Reiniciar());
		cuadr�cula.addRow(0, b7, b8, b9, ba, bc);

		Bot�n b4 = cr�aBot�n('4', new Escribirlo().c('4'));
		Bot�n b5 = cr�aBot�n('5', new Escribirlo().c('5'));
		Bot�n b6 = cr�aBot�n('6', new Escribirlo().c('6'));
		Bot�n bs = cr�aBot�n('-', new EscribirloDos().c('-'));
		Bot�n bcl = cr�aBot�n('(', new EscribirloCuatro().c('('));
		cuadr�cula.addRow(1, b4, b5, b6, bs, bcl);

		Bot�n b1 = cr�aBot�n('1', new Escribirlo().c('1'));
		Bot�n b2 = cr�aBot�n('2', new Escribirlo().c('2'));
		Bot�n b3 = cr�aBot�n('3', new Escribirlo().c('3'));
		Bot�n bm = cr�aBot�n('*', new EscribirloDos().c('*'));
		Bot�n bco = cr�aBot�n(')', new EscribirloCinco().c(')'));
		cuadr�cula.addRow(2, b1, b2, b3, bm, bco);

		Bot�n b0 = cr�aBot�n('0', new Escribirlo().c('0'));
		Bot�n bp = cr�aBot�n('.', new EscribirloTres().c('.'));
		Bot�n be = cr�aBot�n('=', new be());
		Bot�n bd = cr�aBot�n('/', new EscribirloDos().c('/'));
		cuadr�cula.addRow(3, b0, bp, be, bd);
	}

// Skapar en knapp med symbolen c och funktionen acci�n
	Bot�n cr�aBot�n(char c, Acci�nDelBot�n acci�n) {
		Bot�n b = new Bot�n();
		b.setText(Character.toString(c));
		b.setOnAction(Application -> {
			acci�n.hacerlo();
		});
		return b;
	}

//  Tar bord eventuella operationer p� slutet av texten som kan strula till det och k�r sedan 
//	metoder som tar texten och spottar ut ett svar villket l�ggs till i texto
	void RESPONDAME() {
		String pregunta = texto.getText();
		if (("" + pregunta.charAt(pregunta.length() - 1)).matches("[+-/*]*")) {
			pregunta = pregunta.substring(0, pregunta.length() - 1);
		}

		ArrayList<ArrayList<ArrayList<Operaci�n>>> �rbol = new ArrayList<ArrayList<ArrayList<Operaci�n>>>();
		cr�a�rbol(�rbol, pregunta, 0);
		EJECUTAR(�rbol);
		if (ERROR) {
			texto.setText("ERROR");
		} else {
			texto.setText("" + �rbol.get(0).get(0).get(0).operar(0, 0));
		}
	}

// Skapar ett tr�d (�rbol) av ArrayList<Operaci�n>
// En arrayList<Operaci�n> kan ber�knas till en double och en Arriba() �r platsh�llare till en annan
// arrayList<Operaci�n> som ska ber�knas f�rst och har en h�gre index i �rbol

	void cr�a�rbol(ArrayList<ArrayList<ArrayList<Operaci�n>>> �rbol, String tempPregunta, int altura) {
		if (altura >= �rbol.size()) {
			�rbol.add(new ArrayList<ArrayList<Operaci�n>>());
		}
		if (tempPregunta.length() == 0) {
			return;
		}
		int proximaAbierta = tempPregunta.indexOf('(');
		int proximaCerrada = tempPregunta.indexOf(')');

		ArrayList<Operaci�n> k = new ArrayList<Operaci�n>();
		if (proximaAbierta == proximaCerrada) {
			k.addAll(new Operaci�nDeTexto(tempPregunta).operaciones);
			�rbol.get(altura).add(k);
		} else if (proximaAbierta < proximaCerrada && proximaAbierta != -1) {
			k.addAll(new Operaci�nDeTexto(tempPregunta.substring(0, proximaAbierta)).operaciones);
			k.add(new Arriba());
			�rbol.get(altura).add(k);
			cr�a�rbol(�rbol, tempPregunta.substring(proximaAbierta + 1), altura + 1);
		} else {
			k.addAll(new Operaci�nDeTexto(tempPregunta.substring(0, proximaCerrada)).operaciones);
			�rbol.get(altura).add(k);
			cr�a�rbol(�rbol, tempPregunta.substring(proximaCerrada + 1), altura - 1);
		}
	}
	
// Ber�knar varje <ArrayList<Operaci�n>> med hj�lp av calcular metoden. Om en altura() hittas byts den ut mot en
// double som ber�knades innan fr�n en ArrayList<Operaci�n>, int contarArriba h�ller reda p� var i den ArrayList<ArrayList<Operaci�n>>
// som ligger ett index h�gre som den kan hitta r�tt ArrayList<Operaci�n>

	void EJECUTAR(ArrayList<ArrayList<ArrayList<Operaci�n>>> �rbol) {

		for (int i = �rbol.size() - 1; i >= 0; i--) {

			int contarArriba = 0;
			for (int i2 = 0; i2 + 1 < �rbol.get(i).size(); i2++) {
				if (�rbol.get(i).get(i2).get(�rbol.get(i).get(i2).size() - 1).getClass()
						.equals(new Arriba().getClass())) {
					�rbol.get(i).get(i2).set(�rbol.get(i).get(i2).size() - 1,
							new Doble().darValor(�rbol.get(i + 1).get(contarArriba).get(0).operar(0, 0)));
					�rbol.get(i).get(i2).addAll(�rbol.get(i).get(i2 + 1));
					�rbol.get(i).remove(i2 + 1);
					i2--;
					contarArriba++;
				}
			}
			if (�rbol.get(i).get(�rbol.get(i).size() - 1).get(�rbol.get(i).get(�rbol.get(i).size() - 1).size() - 1)
					.getClass().equals(new Arriba().getClass())) {
				�rbol.get(i).get(�rbol.get(i).size() - 1).set(�rbol.get(i).get(�rbol.get(i).size() - 1).size() - 1,
						new Doble().darValor(�rbol.get(i + 1).get(contarArriba).get(0).operar(0, 0)));
			}
			for (int i2 = 0; i2 < �rbol.get(i).size(); i2++) {
				ArrayList<Operaci�n> corta = new ArrayList<Operaci�n>();
				corta.add(new Doble().darValor(calcular(�rbol.get(i).get(i2))));
				�rbol.get(i).set(i2, corta);
			}
		}
	}
	
// H�mtar en ArrayList<Operaci�n> och spottar ut en double.
// Anv�nder sig av metoder som letar efter divisioner, multiplikationer, additioner och subtraktioner och tar
// De gr�nsande talen(Doble) f�r att skapa en ny Doble som ers�tter dem
	double calcular(ArrayList<Operaci�n> operaciones) {
		operaciones = Divici�n(operaciones);
		operaciones = Multiplicaci�n(operaciones);
		operaciones = adici�nYSustracci�n(operaciones);
		return operaciones.get(0).operar(0, 0);
	}

	ArrayList<Operaci�n> Divici�n(ArrayList<Operaci�n> operaciones) {
		for (int i = 0; i < operaciones.size(); i++) {
			if (operaciones.get(i).getClass().equals(new Divisi�n().getClass())) {
				operaciones = acci�n(operaciones, i);
				i -= 2;
			}
		}
		return operaciones;
	}

	ArrayList<Operaci�n> Multiplicaci�n(ArrayList<Operaci�n> operaciones) {
		for (int i = 0; i < operaciones.size(); i++) {
			if (operaciones.get(i).getClass().equals(new Multiplicaci�n().getClass())) {
				operaciones = acci�n(operaciones, i);
				i -= 2;
			}
		}
		return operaciones;
	}

	ArrayList<Operaci�n> adici�nYSustracci�n(ArrayList<Operaci�n> operaciones) {
		for (int i = 0; i < operaciones.size(); i++) {
			if (operaciones.get(i).getClass().equals(new Adici�n().getClass())
					|| operaciones.get(i).getClass().equals(new Sustracci�n().getClass())) {
				operaciones = acci�n(operaciones, i);
				i -= 2;
			}
		}
		return operaciones;
	}

	ArrayList<Operaci�n> acci�n(ArrayList<Operaci�n> operaciones, int i) {
		operaciones.set(i, new Doble().darValor(
				operaciones.get(i).operar(operaciones.get(i - 1).operar(0, 0), operaciones.get(i + 1).operar(0, 0))));
		operaciones.remove(i - 1);
		operaciones.remove(i);
		return operaciones;
	}

//Tar in en text n�r den �r deklarerad och deriverar av den en ArrayList<Operaci�n>
	class Operaci�nDeTexto {
		String texto;
		ArrayList<Operaci�n> operaciones;

		Operaci�nDeTexto(String texto) {
			this.texto = texto;
			operaciones = new ArrayList<Operaci�n>();
			cr�aListaDeArregla();
		}

//H�mtar operationer fr�n texten och l�gger dem i listan
		void cr�aListaDeArregla() {
			while (this.texto.length() > 0) {
				operaciones.add(conseguirProximaOperaci�n());
			}
		}

//Beroende p� vad den f�rsta charen �r l�gger den till olika operationer
//Ja, jag r�knar ett tal som en operation
		Operaci�n conseguirProximaOperaci�n() {
			char primeroChar = this.texto.charAt(0);
			this.texto = this.texto.substring(1);
			switch (primeroChar) {
			case '+':
				return new Adici�n();
			case '-':
				return new Sustracci�n();
			case '*':
				return new Multiplicaci�n();
			case '/':
				return new Divisi�n();
			default:
				int cortar = proximaOperador();
				String n�mero = primeroChar + this.texto.substring(0, cortar);
				this.texto = this.texto.substring(proximaOperador());
				return new Doble().darValor(Double.valueOf(n�mero));
			}
		}
		int proximaOperador() {
			for (int i = 0; i < this.texto.length(); i++) {
				if (("" + this.texto.charAt(i)).matches("[+-/*]") && this.texto.charAt(i) != '.') {
					return i;
				}
			}
			return this.texto.length();
		}
	}

// en operaci�n kan ta in tv� tal och spotta ut ett annat
	abstract class Operaci�n {
		abstract double operar(double n1, double n2);
	}
	
// denna �r inte mycket av en operation men jag ville ha den i samma lista som de andra operationerna
// sparar ett double v�rde
	class Doble extends Operaci�n {
		double valor = 1;

		Doble darValor(double valor) {
			this.valor = valor;
			return this;
		}

		double operar(double n1, double n2) {
			return this.valor;
		}
	}

// som en Doble, men ANNORULDA
	class Arriba extends Doble {
	};

	class Divisi�n extends Operaci�n {
		double operar(double n1, double n2) {
			if (n2 == 0) {
				ERROR = true;
				return 0;
			}
			return n1 / n2;
		}
	}

	class Multiplicaci�n extends Operaci�n {
		double operar(double n1, double n2) {
			return n1 * n2;
		}
	}

	class Adici�n extends Operaci�n {
		double operar(double n1, double n2) {
			return n1 + n2;
		}
	}

	class Sustracci�n extends Operaci�n {

		double operar(double n1, double n2) {
			return n1 - n2;
		}
	}

// alla knappar m�ste ju g�ra n�got
	abstract class Acci�nDelBot�n {
		abstract void hacerlo();
	}

// denna handlingen k�r RESPONDAME() som ger ett svar p� polynomet
	class be extends Acci�nDelBot�n {
		void hacerlo() {
			RESPONDAME();
		}
	}

// alla knappar som skriver en symbol har vissa saker gemensamt och d�rf�r gjorde jag detta till en abstrakt klass
	abstract class Escribir extends Acci�nDelBot�n {
		char c;

		Escribir c(char c) {
			this.c = c;
			return this;
		}

		abstract void hacerlo();
	}

// knappar som extendar escribir har olika villkor innan de skriver en char
// jag skrev ett annat s�tt att validera om en char ska kunna bli skriven l�ngre ner. Jag skulle
// ha �teranv�nt koden b�ttre
	class Escribirlo extends Escribir {
		@Override
		void hacerlo() {
			if (texto.conseguir�ltimo() != ')') {
				texto.setText(texto.getText() + c);
			}
		}
	}

	class EscribirloDos extends Escribir {
		@Override
		void hacerlo() {
			if (!("" + texto.conseguir�ltimo()).matches("[+-/*.]*") && otro()) {
				texto.setText(texto.getText() + c);
			}
		}

		boolean otro() {
			return texto.getText().length() > 0;
		}
	}

	class EscribirloTres extends EscribirloDos {
		@Override
		boolean otro() {
			return texto.puntoEsPosible();
		}
	}

	class EscribirloCuatro extends Escribir {
		@Override
		void hacerlo() {
			if (("" + texto.conseguir�ltimo()).matches("[+-/*( ]*")) {
				texto.setText(texto.getText() + c);
			}
		}
	}

	class EscribirloCinco extends Escribir {
		@Override
		void hacerlo() {
			if (("" + texto.conseguir�ltimo()).matches("[0-9.)]*")
					&& new TextFieldDeN�meros().hayAbierta(texto.getText())) {
				texto.setText(texto.getText() + c);
			}
		}
	}

	class Reiniciar extends Acci�nDelBot�n {
		@Override
		void hacerlo() {
			texto.clear();
			ERROR = false;
		}
	}

	class Bot�n extends Button {
		@Override
		public void resize(double uno, double dos) {
			super.resize(50, 25);
		}
	}

	class TextFieldDeN�meros extends TextField {
		@Override
		public void replaceText(int comienzo, int fin, String texto) {
			if (((comienzo == fin && validar(texto)) || comienzo + 1 == fin) && fin == this.getText().length()) {
				super.replaceText(comienzo, fin, texto);
			}
		}

		@Override
		public void replaceSelection(String texto) {
		}

		private boolean validar(String eltexto) {

			if (eltexto.contains("" + ',')) {
				return false;
			}
			if (mo("" + conseguir�ltimo())) {
				return mn(eltexto);
			} else if (eltexto.matches("[.]*")) {
				return puntoEsPosible();
			} else if (eltexto.matches("[(]*")) {
				return ("" + conseguir�ltimo()).matches("[(]*");
			} else if (eltexto.matches("[)]*")) {
				return ("" + conseguir�ltimo()).matches("[0-9.)]*") && hayAbierta(this.getText());
			} else if (this.getText().charAt(this.getText().length() - 1) == ')') {
				return mo(eltexto);
			}

			return eltexto.matches("[0-9+-/*]*");
		}

		private boolean mn(String cuerda) {
			return cuerda.matches("[0-9(]*");
		}

		private boolean mo(String cuerda) {
			return cuerda.matches("[+-/* ]*");
		}

		private boolean m3(String cuerda) {
			return cuerda.matches("[+-/*()]*");
		}

		char conseguir�ltimo() {
			int longitud = this.getText().length() - 1;
			if (longitud == -1) {
				return ' ';
			} else {
				return this.getText().charAt(longitud);
			}
		}

		boolean puntoEsPosible() {
			if (("" + conseguir�ltimo()).matches("[()]*")) {
				return false;
			}
			for (int i = this.getText().length() - 1; i >= 0; i--) {
				char elChar = this.getText().charAt(i);
				if (elChar == '.') {
					return false;
				}
				if (m3("" + elChar)) {
					return true;
				}

			}
			return true;
		}

		boolean hayAbierta(String cuerda) {
			int contar = 0;
			for (int i = 0; i < cuerda.length(); i++) {
				if (cuerda.charAt(i) == '(') {
					contar++;
				} else if (cuerda.charAt(i) == ')') {
					contar--;
				}
			}
			return (contar > 0);
		}
	}

}
