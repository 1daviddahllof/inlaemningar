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
	TextFieldDeNúmeros texto = new TextFieldDeNúmeros();
	static boolean ERROR = false;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("título");
		primaryStage.show();
		primaryStage.setScene(new Scene(créaTodo(primaryStage), 400, 300));
	}

// initierar andra metoder som skapar en borderpane och en gridpane för att lägga i en ny group som returnas.
	Group créaTodo(Stage primaryStage) {
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(texto);
		borderpane.relocate(120, 20);
		GridPane cuadrícula = créaCuadrícula1();

		return new Group(borderpane, cuadrícula);
	}

// Skapar och ger attributer till en cuadrícula och kör metod som lägger till knappar och sedan returnas den
	GridPane créaCuadrícula1() {
		GridPane cuadrícula = new GridPane();
		botondes(cuadrícula);
		cuadrícula.setHgap(40);
		cuadrícula.setVgap(10);
		cuadrícula.relocate(40, 60);
		return cuadrícula;
	}

// Tar en gridpane och lägger till knapparna med hjälp av créaBotón metoden
	void botondes(GridPane cuadrícula) {
		Botón b7 = créaBotón('7', new Escribirlo().c('7'));
		Botón b8 = créaBotón('8', new Escribirlo().c('8'));
		Botón b9 = créaBotón('9', new Escribirlo().c('9'));
		Botón ba = créaBotón('+', new EscribirloDos().c('+'));
		Botón bc = créaBotón('C', new Reiniciar());
		cuadrícula.addRow(0, b7, b8, b9, ba, bc);

		Botón b4 = créaBotón('4', new Escribirlo().c('4'));
		Botón b5 = créaBotón('5', new Escribirlo().c('5'));
		Botón b6 = créaBotón('6', new Escribirlo().c('6'));
		Botón bs = créaBotón('-', new EscribirloDos().c('-'));
		Botón bcl = créaBotón('(', new EscribirloCuatro().c('('));
		cuadrícula.addRow(1, b4, b5, b6, bs, bcl);

		Botón b1 = créaBotón('1', new Escribirlo().c('1'));
		Botón b2 = créaBotón('2', new Escribirlo().c('2'));
		Botón b3 = créaBotón('3', new Escribirlo().c('3'));
		Botón bm = créaBotón('*', new EscribirloDos().c('*'));
		Botón bco = créaBotón(')', new EscribirloCinco().c(')'));
		cuadrícula.addRow(2, b1, b2, b3, bm, bco);

		Botón b0 = créaBotón('0', new Escribirlo().c('0'));
		Botón bp = créaBotón('.', new EscribirloTres().c('.'));
		Botón be = créaBotón('=', new be());
		Botón bd = créaBotón('/', new EscribirloDos().c('/'));
		cuadrícula.addRow(3, b0, bp, be, bd);
	}

// Skapar en knapp med symbolen c och funktionen acción
	Botón créaBotón(char c, AcciónDelBotón acción) {
		Botón b = new Botón();
		b.setText(Character.toString(c));
		b.setOnAction(Application -> {
			acción.hacerlo();
		});
		return b;
	}

//  Tar bord eventuella operationer på slutet av texten som kan strula till det och kör sedan 
//	metoder som tar texten och spottar ut ett svar villket läggs till i texto
	void RESPONDAME() {
		String pregunta = texto.getText();
		if (("" + pregunta.charAt(pregunta.length() - 1)).matches("[+-/*]*")) {
			pregunta = pregunta.substring(0, pregunta.length() - 1);
		}

		ArrayList<ArrayList<ArrayList<Operación>>> árbol = new ArrayList<ArrayList<ArrayList<Operación>>>();
		créaÁrbol(árbol, pregunta, 0);
		EJECUTAR(árbol);
		if (ERROR) {
			texto.setText("ERROR");
		} else {
			texto.setText("" + árbol.get(0).get(0).get(0).operar(0, 0));
		}
	}

// Skapar ett träd (árbol) av ArrayList<Operación>
// En arrayList<Operación> kan beräknas till en double och en Arriba() är platshållare till en annan
// arrayList<Operación> som ska beräknas först och har en högre index i árbol

	void créaÁrbol(ArrayList<ArrayList<ArrayList<Operación>>> árbol, String tempPregunta, int altura) {
		if (altura >= árbol.size()) {
			árbol.add(new ArrayList<ArrayList<Operación>>());
		}
		if (tempPregunta.length() == 0) {
			return;
		}
		int proximaAbierta = tempPregunta.indexOf('(');
		int proximaCerrada = tempPregunta.indexOf(')');

		ArrayList<Operación> k = new ArrayList<Operación>();
		if (proximaAbierta == proximaCerrada) {
			k.addAll(new OperaciónDeTexto(tempPregunta).operaciones);
			árbol.get(altura).add(k);
		} else if (proximaAbierta < proximaCerrada && proximaAbierta != -1) {
			k.addAll(new OperaciónDeTexto(tempPregunta.substring(0, proximaAbierta)).operaciones);
			k.add(new Arriba());
			árbol.get(altura).add(k);
			créaÁrbol(árbol, tempPregunta.substring(proximaAbierta + 1), altura + 1);
		} else {
			k.addAll(new OperaciónDeTexto(tempPregunta.substring(0, proximaCerrada)).operaciones);
			árbol.get(altura).add(k);
			créaÁrbol(árbol, tempPregunta.substring(proximaCerrada + 1), altura - 1);
		}
	}
	
// Beräknar varje <ArrayList<Operación>> med hjälp av calcular metoden. Om en altura() hittas byts den ut mot en
// double som beräknades innan från en ArrayList<Operación>, int contarArriba håller reda på var i den ArrayList<ArrayList<Operación>>
// som ligger ett index högre som den kan hitta rätt ArrayList<Operación>

	void EJECUTAR(ArrayList<ArrayList<ArrayList<Operación>>> árbol) {

		for (int i = árbol.size() - 1; i >= 0; i--) {

			int contarArriba = 0;
			for (int i2 = 0; i2 + 1 < árbol.get(i).size(); i2++) {
				if (árbol.get(i).get(i2).get(árbol.get(i).get(i2).size() - 1).getClass()
						.equals(new Arriba().getClass())) {
					árbol.get(i).get(i2).set(árbol.get(i).get(i2).size() - 1,
							new Doble().darValor(árbol.get(i + 1).get(contarArriba).get(0).operar(0, 0)));
					árbol.get(i).get(i2).addAll(árbol.get(i).get(i2 + 1));
					árbol.get(i).remove(i2 + 1);
					i2--;
					contarArriba++;
				}
			}
			if (árbol.get(i).get(árbol.get(i).size() - 1).get(árbol.get(i).get(árbol.get(i).size() - 1).size() - 1)
					.getClass().equals(new Arriba().getClass())) {
				árbol.get(i).get(árbol.get(i).size() - 1).set(árbol.get(i).get(árbol.get(i).size() - 1).size() - 1,
						new Doble().darValor(árbol.get(i + 1).get(contarArriba).get(0).operar(0, 0)));
			}
			for (int i2 = 0; i2 < árbol.get(i).size(); i2++) {
				ArrayList<Operación> corta = new ArrayList<Operación>();
				corta.add(new Doble().darValor(calcular(árbol.get(i).get(i2))));
				árbol.get(i).set(i2, corta);
			}
		}
	}
	
// Hämtar en ArrayList<Operación> och spottar ut en double.
// Använder sig av metoder som letar efter divisioner, multiplikationer, additioner och subtraktioner och tar
// De gränsande talen(Doble) för att skapa en ny Doble som ersätter dem
	double calcular(ArrayList<Operación> operaciones) {
		operaciones = Divición(operaciones);
		operaciones = Multiplicación(operaciones);
		operaciones = adiciónYSustracción(operaciones);
		return operaciones.get(0).operar(0, 0);
	}

	ArrayList<Operación> Divición(ArrayList<Operación> operaciones) {
		for (int i = 0; i < operaciones.size(); i++) {
			if (operaciones.get(i).getClass().equals(new División().getClass())) {
				operaciones = acción(operaciones, i);
				i -= 2;
			}
		}
		return operaciones;
	}

	ArrayList<Operación> Multiplicación(ArrayList<Operación> operaciones) {
		for (int i = 0; i < operaciones.size(); i++) {
			if (operaciones.get(i).getClass().equals(new Multiplicación().getClass())) {
				operaciones = acción(operaciones, i);
				i -= 2;
			}
		}
		return operaciones;
	}

	ArrayList<Operación> adiciónYSustracción(ArrayList<Operación> operaciones) {
		for (int i = 0; i < operaciones.size(); i++) {
			if (operaciones.get(i).getClass().equals(new Adición().getClass())
					|| operaciones.get(i).getClass().equals(new Sustracción().getClass())) {
				operaciones = acción(operaciones, i);
				i -= 2;
			}
		}
		return operaciones;
	}

	ArrayList<Operación> acción(ArrayList<Operación> operaciones, int i) {
		operaciones.set(i, new Doble().darValor(
				operaciones.get(i).operar(operaciones.get(i - 1).operar(0, 0), operaciones.get(i + 1).operar(0, 0))));
		operaciones.remove(i - 1);
		operaciones.remove(i);
		return operaciones;
	}

//Tar in en text när den är deklarerad och deriverar av den en ArrayList<Operación>
	class OperaciónDeTexto {
		String texto;
		ArrayList<Operación> operaciones;

		OperaciónDeTexto(String texto) {
			this.texto = texto;
			operaciones = new ArrayList<Operación>();
			créaListaDeArregla();
		}

//Hämtar operationer från texten och lägger dem i listan
		void créaListaDeArregla() {
			while (this.texto.length() > 0) {
				operaciones.add(conseguirProximaOperación());
			}
		}

//Beroende på vad den första charen är lägger den till olika operationer
//Ja, jag räknar ett tal som en operation
		Operación conseguirProximaOperación() {
			char primeroChar = this.texto.charAt(0);
			this.texto = this.texto.substring(1);
			switch (primeroChar) {
			case '+':
				return new Adición();
			case '-':
				return new Sustracción();
			case '*':
				return new Multiplicación();
			case '/':
				return new División();
			default:
				int cortar = proximaOperador();
				String número = primeroChar + this.texto.substring(0, cortar);
				this.texto = this.texto.substring(proximaOperador());
				return new Doble().darValor(Double.valueOf(número));
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

// en operación kan ta in två tal och spotta ut ett annat
	abstract class Operación {
		abstract double operar(double n1, double n2);
	}
	
// denna är inte mycket av en operation men jag ville ha den i samma lista som de andra operationerna
// sparar ett double värde
	class Doble extends Operación {
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

	class División extends Operación {
		double operar(double n1, double n2) {
			if (n2 == 0) {
				ERROR = true;
				return 0;
			}
			return n1 / n2;
		}
	}

	class Multiplicación extends Operación {
		double operar(double n1, double n2) {
			return n1 * n2;
		}
	}

	class Adición extends Operación {
		double operar(double n1, double n2) {
			return n1 + n2;
		}
	}

	class Sustracción extends Operación {

		double operar(double n1, double n2) {
			return n1 - n2;
		}
	}

// alla knappar måste ju göra något
	abstract class AcciónDelBotón {
		abstract void hacerlo();
	}

// denna handlingen kör RESPONDAME() som ger ett svar på polynomet
	class be extends AcciónDelBotón {
		void hacerlo() {
			RESPONDAME();
		}
	}

// alla knappar som skriver en symbol har vissa saker gemensamt och därför gjorde jag detta till en abstrakt klass
	abstract class Escribir extends AcciónDelBotón {
		char c;

		Escribir c(char c) {
			this.c = c;
			return this;
		}

		abstract void hacerlo();
	}

// knappar som extendar escribir har olika villkor innan de skriver en char
// jag skrev ett annat sätt att validera om en char ska kunna bli skriven längre ner. Jag skulle
// ha återanvänt koden bättre
	class Escribirlo extends Escribir {
		@Override
		void hacerlo() {
			if (texto.conseguirÙltimo() != ')') {
				texto.setText(texto.getText() + c);
			}
		}
	}

	class EscribirloDos extends Escribir {
		@Override
		void hacerlo() {
			if (!("" + texto.conseguirÙltimo()).matches("[+-/*.]*") && otro()) {
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
			if (("" + texto.conseguirÙltimo()).matches("[+-/*( ]*")) {
				texto.setText(texto.getText() + c);
			}
		}
	}

	class EscribirloCinco extends Escribir {
		@Override
		void hacerlo() {
			if (("" + texto.conseguirÙltimo()).matches("[0-9.)]*")
					&& new TextFieldDeNúmeros().hayAbierta(texto.getText())) {
				texto.setText(texto.getText() + c);
			}
		}
	}

	class Reiniciar extends AcciónDelBotón {
		@Override
		void hacerlo() {
			texto.clear();
			ERROR = false;
		}
	}

	class Botón extends Button {
		@Override
		public void resize(double uno, double dos) {
			super.resize(50, 25);
		}
	}

	class TextFieldDeNúmeros extends TextField {
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
			if (mo("" + conseguirÙltimo())) {
				return mn(eltexto);
			} else if (eltexto.matches("[.]*")) {
				return puntoEsPosible();
			} else if (eltexto.matches("[(]*")) {
				return ("" + conseguirÙltimo()).matches("[(]*");
			} else if (eltexto.matches("[)]*")) {
				return ("" + conseguirÙltimo()).matches("[0-9.)]*") && hayAbierta(this.getText());
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

		char conseguirÙltimo() {
			int longitud = this.getText().length() - 1;
			if (longitud == -1) {
				return ' ';
			} else {
				return this.getText().charAt(longitud);
			}
		}

		boolean puntoEsPosible() {
			if (("" + conseguirÙltimo()).matches("[()]*")) {
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
