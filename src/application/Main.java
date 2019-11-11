package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {

	public void start(Stage theStage) {
		theStage.setTitle("Game!");

		Group root = new Group();
		Scene theScene = new Scene(root, 600, 400); // size of window
		theStage.setScene(theScene); // sets theScene in stage

		Canvas canvas = new Canvas( 1000, 1000); // size of entire canvas (larger than scene)
		root.getChildren().add(canvas); // canvas is a child of root

		GraphicsContext gc = canvas.getGraphicsContext2D();

		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
		gc.setFont(theFont);
		gc.fillText("Cat Game!", 60, 50);
		gc.strokeText("Cat Game!", 60, 50);


		Image barn = new Image("barn.jpg");
		//gc.drawImage(barn, 0, 0);

		Cat mufi = new Cat();
		mufi.setImage("Cat_front.png");
		mufi.setPosition(50, 200);
		mufi.render(gc);
		
		Object barrel = new Object();
		barrel.setImage("barrel.png");
		barrel.setPosition(300, 100);
		barrel.render(gc);

		//final long startNanoTime = System.nanoTime();
		
		new AnimationTimer() { // every 1/60 sec this happens
			public void handle(long time) {
				//double t = (currentNanoTime - startNanoTime) / 1000000000.0;
				if(mufi.yPosition != 200) { // this is hard-coding 100
					mufi.yPosition = mufi.yPosition + 1;
					gc.clearRect(mufi.xPosition, mufi.yPosition, 400, 600);
					mufi.render(gc);
					barrel.render(gc);
				}
				else {
					mufi.ableToJump = true;
				}
				
				//double x = 100+t;
				//gc.drawImage(barn, 0, 0);
				//gc.drawImage(cat, x, 100);
			}
		}
		.start();

		theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent ke) {
				if(ke.getCode() == KeyCode.SPACE) {
					if(mufi.ableToJump == true) {
						gc.clearRect(mufi.xPosition, mufi.yPosition, 400, 600);
						//gc.drawImage(barn, 0, 0);
						mufi.jump();
						mufi.render(gc);
					}
				}
				
				if(ke.getCode() == KeyCode.A) {
					mufi.move("left");
					gc.clearRect(mufi.xPosition, mufi.yPosition, 400, 600);
					//gc.drawImage(barn, 0, 0);
					mufi.render(gc);
				}
				
				if(ke.getCode() == KeyCode.D) {
					mufi.move("right");
					gc.clearRect(mufi.xPosition, mufi.yPosition, 400, 600);
					//gc.drawImage(barn, 0, 0);
					mufi.render(gc);
				}
			}
		});
		
		theStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}


