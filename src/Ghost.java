
/**
 * This class represents a ghost that the cat
 * can catch. It extends from the object class.
 * @author Team 68
 */
public class Ghost extends Object{
	
	/**
	 * Constructor to initialize values
	 * Loads image and its dimensions
	 * @param x
	 * @param y
	 */
	public Ghost(int x, int y) {
		super(x,y);
		loadImage("ghost.png");
		getImageDimensions();
	}
	
	/**
	 * This method moves the ghost across the screen
	 */
	public void move() {
		if(x < 0) {
			x = 400;
		}
		
		// factor for speed increase
		x -= 1 * factor;	
	}

}
