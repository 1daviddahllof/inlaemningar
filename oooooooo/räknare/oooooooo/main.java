package oooooooo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class main extends Application{

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
		TextFieldDeN�meros texto = new TextFieldDeN�meros();
		borderpane.setTop(texto);
		Bot�n que = new Bot�n();
		
		borderpane.relocate(120, 20);
		
		return new Group(borderpane, que);
	}
	class Bot�n extends Button{
		@Override
		public void resize(double uno, double dos) {
			super.resize(50, 20);
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

	    private boolean validate(String texto)
	    {
	        return texto.matches("[0-9 +-/*()]*");
	    }
	}
}
