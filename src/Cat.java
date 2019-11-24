import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Cat extends Object{

	private int dx;
	private int dy;
	boolean can_jump;
	
	public Cat(int x, int y) {
		super(x, y);
		loadImage("small_cat.png");//image of cat
		getImageDimensions();
	}
	
	public void move() {

        y += dy;

        if (y < 1) {
            y = 1;
        }
    }
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_SPACE) {
			jump();
		}
		// no other actions but can add some
	}
	
	public void jump() {
		
		dy  = -1;
//		if(can_jump) {
//			dy = 1;
//			can_jump = true;
//		}
//		else {
//			// do nothing;
//		}
	}
	
}
