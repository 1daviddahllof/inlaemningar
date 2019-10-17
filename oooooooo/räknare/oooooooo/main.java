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
	TextFieldDeN�meros texto = new TextFieldDeN�meros();

	public static void main(String[] args) {	
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("t�tulo");
		primaryStage.show();
		primaryStage.setScene(new Scene(cr�aTodo(primaryStage), 400, 300));
	}
	Group cr�aTodo(Stage primaryStage) {
		BorderPane borderpane = new BorderPane();
		borderpane.setTop(texto);
		borderpane.relocate(120, 20);
		GridPane cuadr�cula = cr�aCuadr�cula1();
		
		
		return new Group(borderpane, cuadr�cula);
	}
	
	
	
	GridPane cr�aCuadr�cula1(){
		GridPane cuadr�cula = new GridPane();
		botondes(cuadr�cula);
		cuadr�cula.setHgap(40);
		cuadr�cula.setVgap(10);
		cuadr�cula.relocate(40, 60);
		return cuadr�cula;
	}
	
	void botondes(GridPane cuadr�cula) {
		Bot�n b7 = cr�aBot�n('7');
		Bot�n b8 = cr�aBot�n('8');
		Bot�n b9 = cr�aBot�n('9');
		Bot�n ba= cr�aBot�n('+');
		cuadr�cula.addRow(0, b7, b8, b9, ba);
		
		Bot�n b4 = cr�aBot�n('4');
		Bot�n b5 = cr�aBot�n('5');
		Bot�n b6 = cr�aBot�n('6');
		Bot�n bs = cr�aBot�n('-');
		cuadr�cula.addRow(1, b4, b5, b6, bs);
		
		Bot�n b1 = cr�aBot�n('1');
		Bot�n b2 = cr�aBot�n('2');
		Bot�n b3 = cr�aBot�n('3');
		Bot�n bm = cr�aBot�n('*');
		cuadr�cula.addRow(2, b1, b2, b3, bm);
		
		Bot�n b0 = cr�aBot�n('0');
		Bot�n bp = cr�aBot�n('.');
		Bot�n be = be();
		Bot�n bd = cr�aBot�n('/');
		cuadr�cula.addRow(3, b0, bp, be, bd);
	}
	
	Bot�n cr�aBot�n(char c) {
		Bot�n b = new Bot�n();
		b.setText(Character.toString(c));
		b.setOnAction(Application -> {
			texto.setText(texto.getText() + c);
		});
		return b;
	}
	
	
	
	Bot�n be() {
		Bot�n be = new Bot�n();
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
	
	
	class Bot�n extends Button{
		@Override
		public void resize(double uno, double dos) {
			super.resize(50, 25);
		}
	}

	class TextFieldDeN�meros extends TextField{
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
