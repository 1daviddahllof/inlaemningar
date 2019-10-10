package oooooooo;



import java.util.Arrays;

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
	     
	      HBox botones = cr�aBotones(primaryStage);
	    
	      demonstrar(4, primaryStage, botones);
	      
	      primaryStage.show();
	}
	private void demonstrar(int direcci�n, Stage primaryStage, HBox botones) {
		switch (direcci�n){
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
		      
		      Group ra�z = new Group(rayaCero, raya, rayaDos, botones);
		      primaryStage.setScene(new Scene(ra�z, 480, 355));
		      break;
			case(2):

				Rectangle gal�n = new Rectangle();
				gal�n.setFill(Color.DARKBLUE);
				gal�n.setWidth(160);
				gal�n.setHeight(320);
				
				Rectangle gal�nDos = new Rectangle();
				gal�nDos.setFill(Color.RED);
				gal�nDos.setWidth(160);
				gal�nDos.setHeight(320);
				gal�nDos.setX(320);
				
				Group grupo = new Group(gal�n, gal�nDos, botones);
				primaryStage.setScene(new Scene(grupo, 480, 355));
				break;
			case(3):
// jag vet att den inte �r symmetrisk men jag orkar inte �ndra den
				
				Rectangle antecedentes = new Rectangle();
				antecedentes.setFill(Color.LIGHTGRAY);
				antecedentes.setWidth(480);
				antecedentes.setHeight(320);
				
				Circle circulo = new Circle();
				circulo.setFill(Color.BLACK);
				circulo.setRadius(80);
				circulo.setCenterX(236);
				circulo.setCenterY(156);
				
				Polygon pol�gono = cr�alo();
				
				Polygon pol�gonoDos = cr�alo();
				pol�gonoDos.setRotate(180);
				pol�gonoDos.relocate(179.5, 141.5);
				
				Group equipo = new Group(antecedentes, circulo, pol�gono, pol�gonoDos, botones);
				primaryStage.setScene(new Scene(equipo, 480, 355));
				break;
			case(4):
				Rectangle cuadrado = new Rectangle();
				cuadrado.setFill(Color.RED);
				cuadrado.setX(240);
				cuadrado.setWidth(240);
				cuadrado.setHeight(160);
				
				Rectangle otroCuadrado =  new Rectangle();
				otroCuadrado.setFill(Color.BLUE);
				otroCuadrado.setX(0);
				otroCuadrado.setY(160);
				otroCuadrado.setWidth(240);
				otroCuadrado.setHeight(160);
				
				Polygon estrella = cr�aEstrella();
				estrella.setFill(Color.BLUE);
				estrella.relocate(120, 80);
				
				Polygon estrellaDos = cr�aEstrella();
				estrellaDos.setFill(Color.RED);
				estrellaDos.relocate(360, 240);
				
				Group camaradas = new Group(cuadrado, otroCuadrado, estrella, estrellaDos, botones);
				primaryStage.setScene(new Scene(camaradas, 480, 355));
				break;
		}
	}
	private Polygon cr�alo() {
		Polygon pol�gono = new Polygon(new double[] {
				237.5, 147.5,
				242.5, 152.5,
				220, 176,
				205, 172,
				200, 140,
				294.5, 81,
				229.5, 146,
				234, 150.5
				
		});
		pol�gono.setFill(Color.WHITE);
		pol�gono.setScaleX(1.4);	
		pol�gono.setScaleY(1.4);
		return pol�gono;
	}
	private Polygon cr�aEstrella() {
		Polygon estrella = new Polygon(new double[] {
		1, 2,
		.775, 1.3091,
		.0049, 1.3091,
		.637, .8821,
		.412, .191,
		1, .6181,
		1.5878, .191,
		1.3633, .8821,
		1.9515, 1.3091,
		1.225, 1.3091
		
		});
		estrella.setScaleX(40);
		estrella.setScaleY(40);
		estrella.setRotate(180);
		return estrella;
			
	}
	private HBox cr�aBotones(Stage primaryStage) {
	
		 Button btn1 = new Button();
	      btn1.setText("  SVERIGE  ");
	     
	      Button btn2 = new Button();
	      btn2.setText("FRANKRIKE");
	      
	      Button btn3 = new Button();
	      btn3.setText("   SKRUV   ");
	      
	      Button btn4 = new Button();
	      btn4.setText("  PANAMA  ");
	      
	      HBox botones = new HBox(btn1, btn2, btn3, btn4);
	      botones.setSpacing(30);
	      botones.relocate(40, 325);
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
	      
	      btn4.setOnAction(new EventHandler<ActionEvent>() {
	   	   
	            @Override
	            public void handle(ActionEvent event) {
	                demonstrar(4, primaryStage, botones);
	            }
	        });
	      return botones;
	}
	private Rectangle raya(int lo) {
		Rectangle este = new Rectangle();
		este.setWidth(480);
		double altura =  240*13.75 / 169;
		este.setHeight(altura);
		este.setY(lo * altura * 2);
		este.setFill(Color.RED);
		return este;
	}
	private Polygon cr�aEstrella2(Polygon estrella) {
		estrella.setScaleX(0.19384615385);
		estrella.setScaleY(0.19384615385);
		estrella.setFill(Color.WHITE);
		return estrella;
	}
}