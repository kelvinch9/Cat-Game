package application;

import java.awt.geom.Rectangle2D;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public class Cat extends Object {

	boolean ableToJump = true;

	public void jump() {
		yPosition = yPosition - 50; // for some reason, minus is jump
		//change the image
		ableToJump = false;
	}
	
	public void move(String input) {
		
		switch(input) {
		case "left": xPosition = xPosition - 5;
		break;

		case "right": xPosition = xPosition + 5;
		break;
		
		}
		
		
	}
    
}
