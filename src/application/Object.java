package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;


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


	public Image getImage() {
		return image;
	}

	public void setImage(Image i) {
		this.image = i;
	}
	
	public void setImage(String filename) {
		Image i = new Image(filename);
		setImage(i);
	}
	
	public void setPosition(double x, double y) {
		xPosition = x;
		yPosition = y;
	}
	
	public void render(GraphicsContext gc) {
		gc.drawImage(image, xPosition, yPosition);
	}
	
}
