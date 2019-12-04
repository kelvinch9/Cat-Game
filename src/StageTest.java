import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StageTest {
	Stage stage = new Stage();
	Score score = new Score();

	@Test
	void testInitStage() {
		stage.initStage();
		assertEquals(stage.getBoxes().isEmpty(), false);
		assertEquals((stage.getBoxes().get(0).getX()), 400);
		assertEquals((stage.getBoxes().get(0).getY()), 250);
		assertEquals(stage.getCoins().isEmpty(), false);
		assertEquals(stage.getCoins().get(0).getX(), 250);
		assertEquals(stage.getCoins().get(0).getY(), 210);
		assertEquals(stage.getCat().getX(), 40);
		assertEquals(stage.getCat().getY(), 250);
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
	/*

	@Test
	void testCollision() {
		stage.setCat(new Cat(40, 250));
		ArrayList<Box> boxes = new ArrayList<>();
		boxes.add(new Box(100,250));
		boxes.add(new Box(400, 250));
		stage.setBoxes(boxes);
		ArrayList<Coin> coins = new ArrayList<>();
		stage.setCoins(coins);
		stage.checkCollisions();
		assertEquals(0, stage.getIngame());

		//this test isn't working yet
		//will work on later
		boxes.add(new Box(40, 250));
		stage.setBoxes(boxes);
		assertEquals(2, stage.getIngame());


		Cat mufiTwo = new Cat(40, 180);

		Box boxTwo = new Box(40, 250);
		Box boxThree = new Box(30, 250);
		Box boxFour = new Box(0, 0);
		Coin coinOne = new Coin(40, 180);
		Coin coinTwo = new Coin(40, 250);
		Coin coinThree = new Coin(30, 170);
		Coin coinFour = new Coin(400, 180);
		assertEquals(false, stage.checkCollisions());
		assertEquals(true, stage.checkCollisions(barrelTwo, mufi));
		assertEquals(false, stage.checkCollisions(barrelThree, mufi));
		assertEquals(false, main.checkCollisions(barrelFour, mufi));
		assertEquals(true, main.checkCollision(barrelFive, mufi));
		assertEquals(true, main.checkCollision(barrelThree, mufiTwo));
		assertEquals(false, main.checkCollision(barrelFour, mufiTwo));

	 */
}


