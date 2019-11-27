import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the cat (the player of the game)
 * This class extends from the Object class
 * @author Danielle
 *
 */
public class Cat extends Object{

	private int dx;
	private int dy;
	
	/**
	 * Constructor to initialize values
	 * Sets the cat image and its dimensions
	 * @param x
	 * @param y
	 */
	public Cat(int x, int y) {
		super(x, y);
		loadImage("small_cat.png");//image of cat
		getImageDimensions();
	}
	
	/**
	 * This method moves the cat through its jump
	 * It will pull the cat back down after it jumps
	 */
	public void move() {
        y += dy;

        if (y < 180) {
            y = 180;
            dy = 1 * factor;
        }
        
        if(y >= 250) {
        	y = 250;
        	dy = 0;
        }
    }
	
	/**
	 * This method checks to see if the space bar was pressed
	 * If so, it calls the jump method
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_SPACE) {
			jump();
		}
		// no other actions but can add some
	}
	
	/**
	 * This method makes the cat jump
	 */
	public void jump() {
		if(canJump()) {
			dy  = -1 * factor;
		}
	}
	
	/**
	 * This method checks to see if the cat can jump
	 * The cat must be on the ground to jump
	 * @return
	 */
	private boolean canJump() {
		if(y == 250) return true;
		else return false;
	}

}
