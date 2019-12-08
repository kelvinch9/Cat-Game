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

	
	/**
	 * Tests the jump method for the cat.
	 * 
	 */
	@Test
	public void testJump() {
		cat.jump();
		assertEquals(250, cat.getY());
	}

	/**
	 * Tests the activate Ghost Mode method.
	 */
	@Test
	public void testGhost() {
		cat.activateGhostMode();
		assertEquals(true, cat.getGhostMode());
	}

	/**
	 * Tests whether the number of ghosts collected
	 * is correct.
	 * 
	 */
	@Test
	public void testGhostsCollected() {
		cat.getGhostsCollected();
		assertEquals(0, cat.getGhostsCollected()); 
		cat.setGhostsCollected(cat.getGhostsCollected() + 1);
		assertEquals(1, cat.getGhostsCollected());
	}

	/**
	 * Tests the move method of the cat and how
	 * that impacts height (y).
	 */
	@Test
	public void testMove() {
		cat.y = 400;
		cat.move();
		assertEquals(250, cat.getY());
	}

	/**
	 * Tests whether the cat can double jump
	 * (should not be allowed).
	 */
	@Test
	public void testDoubleJump() {
		assertEquals(true, cat.canJump());
		cat.y = 400;
		assertEquals(false, cat.canJump());
	}
}

