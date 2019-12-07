/**
 * This class represents a coin object for
 * the cat to obtain. It extends the object class.
 * @author Team 68
 */
public class Coin extends Object{

	/**
	 * Constructor to initialize values
	 * Sets the coin image and its dimensions
	 * @param x
	 * @param y
	 */
	public Coin(int x, int y) {
		super (x,y);

		loadImage("coin.png");
		getImageDimensions();
	}

	/**
	 * This method moves the coins towards the
	 * cat to give the scrolling effect that the
	 * cat is running
	 */
	public void move() {

		if(x < 0) {
			x = 400;
		}

		//factor for speed increase
		x -= 1 * factor;	
	}

}
