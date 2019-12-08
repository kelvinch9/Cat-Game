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
	Score score = new Score();

	/**
	 * Tests the method responsible for creating the initial
	 * state of the game.
	 */
	@Test
	void testInitStage() {
		stage.initStage();
		assertEquals(400, (stage.getBoxes().get(0).getX()));
		assertEquals(250, (stage.getBoxes().get(0).getY()));
		assertEquals(250, stage.getCoins().get(0).getX());
		assertEquals(210, stage.getCoins().get(0).getY());
		assertEquals(40, stage.getCat().getX());
		assertEquals(250, stage.getCat().getY());
		assertEquals(600, stage.getGhosts().get(0).getX());
		assertEquals(210, stage.getGhosts().get(0).getY());
		assertEquals(400, stage.getBird().getX());
		assertEquals(160, stage.getBird().getY());

	}

	
	
	/**
	 * Tests the checkCollision method for the cat and a box.
	 */
	@Test
	void testBoxCollision() {
		Stage stage = new Stage();
		stage.initStage();
		stage.getCat().setX(100);
		int Y = stage.getCat().getY();
		Box box = new Box(100, Y);
		stage.getBoxes().add(box);
		stage.checkCollisions();
		
		assertEquals(2, stage.getStageOfGame());
	}
	
	
	/**
	 * Tests the checkCollision method for the cat and a coin.
	 * 
	 */
	@Test
	void testCoinCollision() {
		Stage stage = new Stage();
		stage.initStage();
		stage.getCat().setX(100);
		int Y = stage.getCat().getY();
		Coin coin = new Coin(100, Y);
		stage.getCoins().add(coin);
		stage.checkCollisions();
		
		assertEquals(1, stage.getCoinsCollected());
	}
	
	
	/**
	 * Tests the checkCollision method for the cat and a ghost.
	 * 
	 */
	@Test
	void testGhostCollision() {
		Stage stage = new Stage();
		stage.initStage();
		stage.getCat().setX(100);
		int Y = stage.getCat().getY();
		Ghost ghost = new Ghost(100, Y);
		stage.getGhosts().add(ghost);
		stage.checkCollisions();
		assertEquals(1, stage.getCat().getGhostsCollected());
	}
	
	
}


