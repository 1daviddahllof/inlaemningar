package oooooooo;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class correr extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	      primaryStage.setTitle("ventana"); 
	      
	      primaryStage.setScene(página());
	      primaryStage.show();
	}
	
	
	private Scene página() {
		
		return new Scene(new Group(), 400, 300);
	}
}
