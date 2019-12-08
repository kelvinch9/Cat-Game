import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is a JUnit test class for the Score class
 * 
 * @author Team 68
 *
 */
class ScoreTest {
	Score score = new Score();
	
	/**
	 * Tests the method responsible for calculating
	 * the score.
	 * 
	 */
	@Test
	void testCalcScore() {
		assertEquals(0, score.calcScore(0, 0));
		assertEquals(1572, score.calcScore(10, 572));
		assertEquals(10100, score.calcScore(100, 100));
		assertEquals(1000, score.calcScore(10, 0));
		assertEquals(600, score.calcScore(0, 600));
	}

	/**
	 * Tests the method responsible for calculating the high score.
	 * 
	 */
	@Test
	void testCalcHighScore() {
		score.setHighScore(100);
		score.calcHighScore(10);
		assertEquals(100, score.getHighScore());
		
		score.calcHighScore(1000);
		assertEquals(1000, score.getHighScore());
	}

	/**
	 * Tests the logic to display a high score
	 * (i.e. is the score a new  high score).
	 */
	@Test
	void testDisplayHighScore() {
		score.setIfGameRetried(false);
		score.setHighScore(100);
		assertEquals(("High Score: 100" +
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

}
