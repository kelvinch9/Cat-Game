import static org.junit.Assert.*;
import java.awt.event.KeyEvent;
import org.junit.Test;


/**
 * JUnit tests for methods
 * Difficult to test many GUI methods, so made sure it functions properly.
 * Easier to test by playing the game!
 * @author Team 68
 */


public class CatTest {

	Cat cat = new Cat(40, 250);

	@Test
	public void testJump() {
		cat.jump();
		assertEquals(250, cat.getY());
	}

	@Test
	public void testGhost() {
		cat.activateGhostMode();
		assertEquals(true, cat.getGhostMode());
	}

	@Test
	public void testGhostsCollected() {
		cat.getGhostsCollected();
		assertEquals(0, cat.getGhostsCollected()); 
		cat.setGhostsCollected(cat.getGhostsCollected() + 1);
		assertEquals(1, cat.getGhostsCollected());
	}

	@Test
	public void testHeight() {
		cat.y = 400;
		cat.move();
		assertEquals(250, cat.getY());
	}

	@Test
	public void testDoubleJump() {
		assertEquals(true, cat.canJump());
		cat.y = 400;
		assertEquals(false, cat.canJump());
	}
}

