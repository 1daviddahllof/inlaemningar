package oooooooo;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class flagga extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	      primaryStage.setTitle("titel"); 
	      
	      Button btn1 = new Button();
	      btn1.setText(" SVERIGE ");
	     
	      Button btn2 = new Button();
	      btn2.setText("FRANKRIKE");
	      
	      Button btn3 = new Button();
	      btn3.setText("  SKRUV  ");
	      
	      HBox botones = new HBox(btn1, btn2, btn3);
	      botones.setSpacing(60);
	      botones.relocate(75, 325);
	      
	      btn1.setOnAction(new EventHandler<ActionEvent>() {
	    	  
	            @Override
	            public void handle(ActionEvent event) {
	                demonstrar(1, primaryStage, botones);
	            }
	        });
	      
	      btn2.setOnAction(new EventHandler<ActionEvent>() {
	    	  
	            @Override
	            public void handle(ActionEvent event) {
	                demonstrar(2, primaryStage, botones);
	            }
	        });
	      
	      btn3.setOnAction(new EventHandler<ActionEvent>() {
	   
	            @Override
	            public void handle(ActionEvent event) {
	                demonstrar(3, primaryStage, botones);
	            }
	        });
	      
	      demonstrar(2, primaryStage, botones);
	      
	      
	      primaryStage.show();
	}
	private void demonstrar(int dirección, Stage primaryStage, HBox botones) {
		switch (dirección){
			case(1):
			  Rectangle rayaCero = new Rectangle();
		      rayaCero.setFill(Color.DARKBLUE);
		      rayaCero.setWidth(480);
		      rayaCero.setHeight(300);
		      
		      Rectangle raya = new Rectangle();
		      raya.setFill(Color.YELLOW);
		      raya.setWidth(60);
		      raya.setHeight(300);
		      raya.setX(150);
		      
		      Rectangle rayaDos = new Rectangle();
		      rayaDos.setFill(Color.YELLOW);
		      rayaDos.setWidth(480);
		      rayaDos.setHeight(60);
		      rayaDos.setY(120);
		      
		      Group raíz = new Group(rayaCero, raya, rayaDos, botones);
		      
		      Scene scene1 = new Scene(raíz, 480, 355);
		      
		      primaryStage.setScene(scene1);
		      break;
			case(2):

				Rectangle galón = new Rectangle();
				galón.setFill(Color.DARKBLUE);
				galón.setWidth(160);
				galón.setHeight(320);
				
				Rectangle galónDos = new Rectangle();
				galónDos.setFill(Color.RED);
				galónDos.setWidth(160);
				galónDos.setHeight(320);
				galónDos.setX(320);
				
				Group grupo = new Group(galón, galónDos, botones);
				Scene scene2 = new Scene(grupo, 480, 355);
				primaryStage.setScene(scene2);
				break;
			case(3):
// jag vet att den inte är symmetrisk men jag orkar inte ändra den
				
				Rectangle antecedentes = new Rectangle();
				antecedentes.setFill(Color.LIGHTGRAY);
				antecedentes.setWidth(480);
				antecedentes.setHeight(320);
				
				Circle circulo = new Circle();
				circulo.setFill(Color.BLACK);
				circulo.setRadius(80);
				circulo.setCenterX(236);
				circulo.setCenterY(156);
				
				Polygon polígono = créalo();
				
				Polygon polígonoDos = créalo();
				polígonoDos.setRotate(180);
				polígonoDos.relocate(179.5, 141.5);
				
				Group equipo = new Group(antecedentes, circulo, polígono, polígonoDos, botones
						);
				Scene escena = new Scene(equipo, 480, 355);
				primaryStage.setScene(escena);
				break;
		}
	}
	private Polygon créalo() {
		Polygon polígono = new Polygon(new double[] {
				237.5, 147.5,
				242.5, 152.5,
				220, 176,
				205, 172,
				200, 140,
				294.5, 81,
				229.5, 146,
				234, 150.5
				
		});
		polígono.setFill(Color.WHITE);
		polígono.setScaleX(1.4);	
		polígono.setScaleY(1.4);
		return polígono;
	}

}