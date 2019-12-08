import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

/**
 * This class represents the cat (the player of the game)
 * This class extends from the Object class
 * 
 * @author Team 68
 */
public class Cat extends Object{

	private int dx; // used to update y location (on y-axis) 
	private int dy; // used to update x location (on x-axis)
	private int ghostsCollected;
	private boolean ghostMode; 
	private boolean ghostModeExpiration; // determine if ghost mode is about to expire
	private Image normalCat;
	private Image ghostCat;

	/**
	 * Constructor to initialize values
	 * Sets the cat image and its dimensions
	 * @param x
	 * @param y
	 */
	public Cat(int x, int y) {
		super(x, y);

		ImageIcon normal = new ImageIcon("small_cat.png");
		normalCat = normal.getImage();
		this.image = normalCat; // default image of cat

		ImageIcon ghost = new ImageIcon("ghost_cat.png");
		ghostCat = ghost.getImage(); // image of cat for ghost mode

		getImageDimensions();

		ghostsCollected = 0;
		ghostMode = false;
		ghostModeExpiration = false;

	}

	/**
	 * This method moves the cat through its jump
	 * It will pull the cat back down after it jumps
	 */
	public void move() {
		y += dy;

		//starts bringing the cat down again
		if (y < 180) {
			y = 180; // 180 is max height
			dy = 1 * factor;
		}

		//back on floor
		if(y >= 250) {
			y = 250;
			dy = 0;
		}

		// updates image of cat based off ghost_mode
		if(ghostMode) {
			this.image = ghostCat;
		}
		else {
			this.image = normalCat;
		}

	}

	/**
	 * This method checks to see if the a key was pressed
	 * If the space bar was pressed, it calls the jump method
	 * If the g key was pressed, it activates ghost mode
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if(key == KeyEvent.VK_SPACE) {
			jump();
		}

		if(key == KeyEvent.VK_G) {
			if(ghostsCollected > 0 && !ghostMode) {
				activateGhostMode();
				ghostsCollected--;
			}
		}
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
	//to run JUnit, this needs to be public, for actual program can be private
	public boolean canJump() {
		if(y == 250) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Activates ghost mode w/ timer
	 */	
	public void activateGhostMode() {

		ghostMode = true;

		Timer timer = new Timer();

		TimerTask taskSetGhostFalse = new TimerTask() {
			public void run() {
				ghostMode = false;
				ghostModeExpiration = false;
			}
		};
		
		TimerTask taskGhostDisappWarning = new TimerTask() {
			public void run() {
				ghostModeExpiration = true;
			}
		};
		
		timer.schedule(taskGhostDisappWarning, 3500); // waits 3500 milliseconds (3.5 seconds), then gives 1.5 second warning
		timer.schedule(taskSetGhostFalse, 5000); // waits 5000 milliseconds (5 seconds), then sets ghost_mode = false;
	}

	/**
	 * Getter for ghost mode
	 * @return
	 */
	public boolean getGhostMode() {
		return ghostMode;
	}
	
	/**
	 * Getter for ghost mode expiration
	 * @return
	 */
	public boolean getGhostModeExpiration() {
		return ghostModeExpiration;
	}

	/**
	 * Getter for the number of ghosts collected
	 * @return
	 */
	public int getGhostsCollected() {
		return ghostsCollected;
	}

	/**
	 * Setter for the number of ghosts collected
	 * @param ghostsCollected
	 */
	public void setGhostsCollected(int ghostsCollected) {
		this.ghostsCollected = ghostsCollected;
	}

}
