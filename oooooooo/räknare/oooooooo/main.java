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
		primaryStage.setTitle("título");
		primaryStage.show();
		primaryStage.setScene(new Scene(créaTodo(primaryStage), 400, 300));
	}
	Group créaTodo(Stage primaryStage) {
		BorderPane borderpane = new BorderPane();
		TextFieldDeNúmeros texto = new TextFieldDeNúmeros();
		borderpane.setTop(texto);
		Botón que = new Botón();
		
		borderpane.relocate(120, 20);
		
		return new Group(borderpane, que);
	}
	class Botón extends Button{
		@Override
		public void resize(double uno, double dos) {
			super.resize(50, 20);
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

	    private boolean validate(String texto)
	    {
	        return texto.matches("[0-9 +-/*()]*");
	    }
	}
}
