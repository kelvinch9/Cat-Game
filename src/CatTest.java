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
		assertEquals(cat.getY(), 250);
	}

	@Test
	public void testGhost() {
		cat.ghost();
		assertEquals(cat.getGhostMode(), true);
	}

	@Test
	public void testGhostsCollected() {
		cat.getGhostsCollected();
		assertEquals(cat.getGhostsCollected(), 0); 
		cat.setGhostsCollected(cat.getGhostsCollected() + 1);
		assertEquals(cat.getGhostsCollected(), 1);
	}

	@Test
	public void testHeight() {
		cat.y = 400;
		cat.move();
		assertEquals(cat.getY(), 250);
	}

	@Test
	public void testDoubleJump() {
		assertEquals(cat.canJump(), true);
		cat.y = 400;
		assertEquals(cat.canJump(), false);
	}
}

