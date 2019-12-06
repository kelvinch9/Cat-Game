import java.util.Random;

/**
 * This class represents a bird for animation purposes.
 * It extends from the object class.
 * @author Team 68
 *
 */

public class Bird extends Object{
	
	/**
	 * Constructor to initialize values
	 * Loads image and its dimensions
	 * @param x
	 * @param y
	 */
	public Bird(int x, int y) {
		super(x,y);
		loadImage("bird.png");
		getImageDimensions();
	}
	
	/**
	 * This method moves the bird
	 */
	public void move() {
		
		//randomly generates y position for the bird
		Random random = new Random();
		int r = random.nextInt(50)-1;

		x -= 1 * factor;
		
		//scrolls the bird back across the screen at a new y
		if(x < 0) {
			x = 400;
			y = (250 - 90) + r;
		}
		
	}

}
