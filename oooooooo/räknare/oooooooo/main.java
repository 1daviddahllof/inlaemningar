package oooooooo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class main extends Application{
	TextFieldDeNúmeros texto = new TextFieldDeNúmeros();

	public static void main(String[] args) {	
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("título");
		primaryStage.show();
		primaryStage.setScene(new Scene(créaTodo(primaryStage), 400, 300));
	}
	Group créaTodo(Stage primaryStage) {
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(texto);
		borderpane.relocate(120, 20);
		GridPane cuadrícula = créaCuadrícula1();
		
		
		return new Group(borderpane, cuadrícula);
	}
	
	
	
	GridPane créaCuadrícula1(){
		GridPane cuadrícula = new GridPane();
		botondes(cuadrícula);
		cuadrícula.setHgap(40);
		cuadrícula.setVgap(10);
		cuadrícula.relocate(40, 60);
		return cuadrícula;
	}
	
	void botondes(GridPane cuadrícula) {
		Botón b7 = créaBotón('7');
		Botón b8 = créaBotón('8');
		Botón b9 = créaBotón('9');
		Botón ba= créaBotón('+');
		cuadrícula.addRow(0, b7, b8, b9, ba);
		
		Botón b4 = créaBotón('4');
		Botón b5 = créaBotón('5');
		Botón b6 = créaBotón('6');
		Botón bs = créaBotón('-');
		cuadrícula.addRow(1, b4, b5, b6, bs);
		
		Botón b1 = créaBotón('1');
		Botón b2 = créaBotón('2');
		Botón b3 = créaBotón('3');
		Botón bm = créaBotón('*');
		cuadrícula.addRow(2, b1, b2, b3, bm);
		
		Botón b0 = créaBotón('0');
		Botón bp = créaBotón('.');
		Botón be = be();
		Botón bd = créaBotón('/');
		cuadrícula.addRow(3, b0, bp, be, bd);
	}
	
	Botón créaBotón(char c) {
		Botón b = new Botón();
		b.setText(Character.toString(c));
		b.setOnAction(Application -> {
			texto.setText(texto.getText() + c);
		});
		return b;
	}
	
	
	
	Botón be() {
		Botón be = new Botón();
		be.setText("=");
		be.setOnAction(Application -> {
			RESPONDAME();
		});
		return be;
	}
	
	void RESPONDAME() {
		
	}
	
	abstract class operador{
	}
	
	
	class Botón extends Button{
		@Override
		public void resize(double uno, double dos) {
			super.resize(50, 25);
		}
	}

	class TextFieldDeNúmeros extends TextField{
	    @Override
	    public void replaceText(int comienzo, int fin, String texto)
	    {
	        if (validate(texto))
	        {
	            super.replaceText(comienzo, fin, texto);
	        }
	    }

	    @Override
	    public void replaceSelection(String texto)
	    {
	        if (validate(texto))
	        {
	            super.replaceSelection(texto);
	        }
	    }

	    private boolean validate(String texto) {    	
	    	return texto.matches("[0-9 +-/*.()]*");
	    }
	}
	
}
