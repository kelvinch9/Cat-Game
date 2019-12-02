import java.util.ArrayList;

/**
 * This class represents a box that the cat
 * must avoid. It extends from the object class.
 * @author Team 68
 *
 */
public class Box extends Object{
	
	/**
	 * Constructor to initialize values
	 * Loads image and its dimensions
	 * @param x
	 * @param y
	 */
	public Box(int x, int y) {
		super(x,y);
		loadImage("box.png");
		getImageDimensions();
	}
	
	/**
	 * This method scrolls the box on to the screen
	 * to make it appear as the cat is running
	 */
	public void move() {
		
		
		if(x < 0) {
			x = 400;
		}
		x -= 1 * factor;
	}
	
}
