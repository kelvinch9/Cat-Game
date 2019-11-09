package application;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Object extends Main {

	double xPosition;
	double yPosition;
	Image image;
	// calculate collision with height and width
	
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
