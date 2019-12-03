import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StageTest {
	Stage stage = new Stage();
	
	
	@Test
	void testInitBoxes() {
		stage.initBoxes();
		assertEquals(stage.getBoxes().isEmpty(), false);
		assertEquals((stage.getBoxes().get(0).getX()), 400);
		assertEquals((stage.getBoxes().get(0).getY()), 250);
	}
	
	@Test
	void testInitCoins() {
		stage.initCoins();
		assertEquals(stage.getCoins().isEmpty(), false);
		assertEquals(stage.getCoins().get(0).getX(), 250);
		assertEquals(stage.getCoins().get(0).getY(), 210);
	}
	
	@Test
	void testCalcHighScore() {
		stage.setHighScore(10);
		stage.calcHighScore(1);
		assertEquals(stage.getHighScore(), 10);
		stage.setHighScore(10);
		stage.calcHighScore(100);
		assertEquals(stage.getHighScore(), 100);
		stage.setHighScore(10);
		stage.calcHighScore(10);
		assertEquals(stage.getHighScore(), 10);
		
	}
	
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
		
		/*
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

}
