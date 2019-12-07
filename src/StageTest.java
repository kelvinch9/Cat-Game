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
	void testBoxCollision() {
		Stage stage = new Stage();
		stage.initStage();
		stage.getCat().setX(100);
		int Y = stage.getCat().getY();
		Box box = new Box(100, Y);
		stage.getBoxes().add(box);
		stage.checkCollisions();
		assertEquals(stage.getStageOfGame(), 2);
	}
	
	@Test
	void testCoinCollision() {
		Stage stage = new Stage();
		stage.initStage();
		stage.getCat().setX(100);
		int Y = stage.getCat().getY();
		Coin coin = new Coin(100, Y);
		stage.getCoins().add(coin);
		stage.checkCollisions();
		assertEquals(stage.getCoinsCollected(), 1);
	}
	
	@Test
	void testGhostCollision() {
		Stage stage = new Stage();
		stage.initStage();
		stage.getCat().setX(100);
		int Y = stage.getCat().getY();
		Ghost ghost = new Ghost(100, Y);
		stage.getGhosts().add(ghost);
		stage.checkCollisions();
		assertEquals(stage.getCat().getGhostsCollected(), 1);
	}
	
	
}


