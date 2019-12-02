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
 * @author Team 68
 *
 */
public class Cat extends Object{

	private int dx;
	private int dy;
	public int birds_collected;
	private boolean ghost_mode = false;
	private Image normal_cat;
	private Image ghost_cat;
	
	/**
	 * Constructor to initialize values
	 * Sets the cat image and its dimensions
	 * @param x
	 * @param y
	 */
	public Cat(int x, int y) {
		super(x, y);
		birds_collected = 0;
		
		ImageIcon normal = new ImageIcon("small_cat.png");
		normal_cat = normal.getImage();
		this.image = normal_cat; // default image of cat
		
		ImageIcon ghost = new ImageIcon("ghost_cat.png");
		ghost_cat = ghost.getImage();
		
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
        
        // updates image of cat based off ghost_mode
        if(ghost_mode) {
        	this.image = ghost_cat;
        }
        else {
        	this.image = normal_cat;
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
		if(key == KeyEvent.VK_L) {
			ghost();
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
	private boolean canJump() {
		if(y == 250) return true;
		else return false;
	}
	
	/**
	 * Setter for ghost mode
	 */
	public void setGhost() {
		this.ghost_mode = !(this.ghost_mode);
	}
	
	void ghost() {
		
		ghost_mode = true;
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			public void run() {
				ghost_mode = false;
			}
		};
		timer.schedule(task, 6000); // waits 6000 milliseconds, then sets ghost_mode = false;
	}
	
	/**
	 * Getter for ghost mode
	 */
	public boolean getGhost() {
		return ghost_mode;
	}


}
