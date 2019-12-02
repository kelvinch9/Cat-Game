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
	
	public void move() {
		
		Random random = new Random();
		int r = random.nextInt(1)-1;
		
//		if(y < 180) {
//			y+=1;
//		}
//		
//		if(y > 250) {
//			y-=1;
//		}
//		
//		if(x < 0) {
//			x = 400;
//		}
		
		if(x < 0) {
			x = 400;
		}
		x -= 1 * factor;	
//		y -=1;
		

	}

}
