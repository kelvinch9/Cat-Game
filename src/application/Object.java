package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Object extends Main {

	private double xPosition;
	private double yPosition;
	private double width;
	private double height;

	Image image;
	// calculate collision with height and width
	
	Object(double x, double y, double w, double h){
		xPosition = x;
		yPosition = y;
		width = w;
		height = h;
	}
	
	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
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
