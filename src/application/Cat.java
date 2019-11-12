package application;

import java.awt.geom.Rectangle2D;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Cat extends Object {

	Cat(double x, double y, double w, double h) {
		super(x, y, w, h);
//		// TODO Auto-generated constructor stub
	}

	boolean ableToJump = true;

	/**
	 * Allows the cat to jump by moving yPosition up 50 units. Sets ableToJump to false
	 */ 
	public void jump() {
		setyPosition(getyPosition() - 50); // for some reason, minus is jump
		//change the image
		ableToJump = false;
		
	}
	
	/**
	 * Allows the cat the move by moving x,y positions
	 * @param input (W,A,S,D)
	 */
	public void move(String input) {
		
		switch(input) {
		case "left": setxPosition(getxPosition() - 5);
		break;

		case "right": setxPosition(getxPosition() + 5);
		break;
		
		}

	}
    
}
