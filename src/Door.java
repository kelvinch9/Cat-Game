/**
 * This class represents a door that the cat
 * must avoid. It extends from the object class.
 * @author Team 68
 *
 */
public class Door extends Object{
	
	/**
	 * Constructor to initialize values
	 * Loads image and its dimensions
	 * @param x
	 * @param y
	 */
	public Door(int x, int y) {
		super(x,y);
		loadImage("door.png");
		getImageDimensions();
	}
	
	/**
	 * This method scrolls the door on to the screen
	 * to make it appear as the cat is running
	 */
	public void move() {
		
		
		if(x < 0) {
			x = 400;
		}
		x -= 1 * factor;	
	}
	
}
