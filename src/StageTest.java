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
	void testCalcScore() {
		assertEquals(score.calcScore(0, 0), 0);
		assertEquals(score.calcScore(10, 572), 1572);
		assertEquals(score.calcScore(100, 100), 10100);
		assertEquals(score.calcScore(10, 0), 1000);
		assertEquals(score.calcScore(0, 600), 600);
	}

	@Test
	void testCalcHighScore() {
		score.setHighScore(100);
		score.calcHighScore(10);
		assertEquals(100, score.getHighScore());
		score.calcHighScore(1000);
		assertEquals(1000, score.getHighScore());
	}

	
	@Test
	void testDisplayHighScore() {
		score.setIfGameRetried(false);
		score.setHighScore(100);
		assertEquals(("High Score: " + score.getHighScore() +
				"\nIt's your first time. You get the high score!"), 
			score.displayHighScore(100));
		score.setIfGameRetried(true);
		score.setPrevHighScore(100);
		assertEquals(("High Score: " + score.getHighScore() +
				"\nNice try! You tied the high score."), 
			score.displayHighScore(100));
		assertEquals(("High Score: " + score.getHighScore() +
				"\nCongrats! New High Score!"), 
				score.displayHighScore(1000));
		assertEquals(("High Score: " + score.getHighScore() +
				"\nBetter luck next time!"), 
			score.displayHighScore(1));
	}
	
	
	@Test
	void testCollision() {
		
	}
}


