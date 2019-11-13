package application;

import java.awt.geom.Rectangle2D;

import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * Cat class represents the main character of the game. It is a subclass of Object
 * 
 * This class has methods that allows cat to jump and duck
 *
 * @author Team68
 *
 */
public class Cat extends Object {
	
	private boolean ableToJump;

	/**
	 * Inherited constructor from Object. Creates cat based on xPosition, yPosition,
	 * width, height
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	Cat(double x, double y, double w, double h) {
		super(x, y, w, h);
		ableToJump = true;
	}

	/**
	 * Allows the cat to jump by moving yPosition up 50 units. Sets ableToJump to false to prevent double jumping
	 */ 
	public void jump() { 
		setyPosition(getyPosition() - 50); // for some reason, minus is jump
		//change the image
		ableToJump = false;
		
	}
	
	
	/**
	 * Allows the cat to "duck / crouch". The input choice is controlled by the Event Handler in Main
	 * @param input
	 */
	public void duck(String input) {
		
	}

	/**
	 * Getter for isAbleToJump
	 * @return
	 */
	public boolean isAbleToJump() {
		return ableToJump;
	}
	/**
	 * Setter for ableToJump
	 * @param a
	 */
	public void setAbleToJump(boolean a) {
		this.ableToJump = a;
	}
	
}
