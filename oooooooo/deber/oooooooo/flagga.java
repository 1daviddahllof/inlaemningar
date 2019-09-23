package oooooooo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class flagga extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		  Rectangle rayacero = new Rectangle();
	      rayacero.setFill(Color.DARKBLUE);
	      rayacero.setWidth(480);
	      rayacero.setHeight(300);
	      
	      Rectangle raya = new Rectangle();
	      raya.setFill(Color.YELLOW);
	      raya.setWidth(60);
	      raya.setHeight(300);
	      raya.setX(150);
	      
	      Rectangle rayados = new Rectangle();
	      rayados.setFill(Color.YELLOW);
	      rayados.setWidth(480);
	      rayados.setHeight(60);
	      rayados.setY(120);
	      
	    
	     
	      
	      Group root = new Group(rayacero, raya, rayados);

	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 330);
	      //Setting title to the Stage 
	      primaryStage.setTitle("EN J*VLA FLAGGA"); 
	      
	      primaryStage.setScene(scene);
	      
	      primaryStage.show();
	}

}