import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for methods
 * Difficult to test many GUI methods, so made sure it initialized properly
 * @author Team 68
 *
 */
class StageTest {
	Stage stage = new Stage();

	@Test
	void testInitStage() {
		stage.initStage();
		assertEquals((stage.getBoxes().get(0).getX()), 400);
		assertEquals((stage.getBoxes().get(0).getY()), 250);
		assertEquals(stage.getCoins().get(0).getX(), 250);
		assertEquals(stage.getCoins().get(0).getY(), 210);
		assertEquals(stage.getCat().getX(), 40);
		assertEquals(stage.getCat().getY(), 250);
		assertEquals(stage.getGhosts().get(0).getX(), 600);
		assertEquals(stage.getGhosts().get(0).getY(), 210);
		assertEquals(stage.getBird().getX(), 400);
		assertEquals(stage.getBird().getY(), 160);

	}

	
	@Test
	void testCollision() {
		
	}
}


