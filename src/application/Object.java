package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class is the parent class which creates objects in the game. Each object has an image, xPosition, yPosition, length, and width. The sub-classes which inherit from Object contain subclass specific properities/methods
 * @author Team68
 *
 */
public class Object extends Stage { // changed from extends main

	private double xPosition;
	private double yPosition;
	private double width;
	private double height;

	Image image;
	// calculate collision with height and width
	
	/**
	 * Constructor to initialize values
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	Object(double x, double y, double w, double h){
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
	}
	
	/**
	 * Getter for x position
	 * @return
	 */
	public double getxPosition() {
		return xPosition;
	}

	/**
	 * Sets the x position
	 * @param xPosition
	 */
	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * Getter for y position
	 * @return
	 */
	public double getyPosition() {
		return yPosition;
	}

	/**
	 * Setter for y position
	 * @param yPosition
	 */
	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * Gets object width
	 * @return
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Gets object height
	 * @return
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Gets image
	 * @return
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Setter for image
	 * @param i
	 */
	public void setImage(Image i) {
		this.image = i;
	}
	
	/**
	 * Sets the actual image for Object
	 * @param filename
	 */
	public void setImage(String filename) {
		Image i = new Image(filename);
		setImage(i);
	}
	
	/**
	 * Sets the x and y position. 
	 * @param x
	 * @param y
	 */
	public void setPosition(double x, double y) {
		xPosition = x;
		yPosition = y;
	}
	
	/**
	 * Draws the image in graphics context
	 * @param gc
	 */
	public void render(GraphicsContext gc) {
		gc.drawImage(image, xPosition, yPosition);
	}
	
}
