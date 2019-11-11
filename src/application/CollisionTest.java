package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CollisionTest {

	@Test
	void testCollision() {
		Main main = new Main();
		Cat mufi = new Cat(100, 100, 10, 10);
		Cat mufiTwo = new Cat(0, 0, 0, 0);
		Object barrel = new Object(100, 100, 10, 10);
		Object barrelTwo = new Object(90, 90, 10, 10);
		Object barrelThree = new Object(0, 0, 50, 1);
		Object barrelFour = new Object(100, 150, 10, 20);
		Object barrelFive = new Object(85, 115, 20, 20);
		assertEquals(true, main.checkCollision(barrel, mufi));
		assertEquals(true, main.checkCollision(barrelTwo, mufi));
		assertEquals(false, main.checkCollision(barrelThree, mufi));
		assertEquals(false, main.checkCollision(barrelFour, mufi));
		assertEquals(true, main.checkCollision(barrelFive, mufi));
		assertEquals(true, main.checkCollision(barrelThree, mufiTwo));
		assertEquals(false, main.checkCollision(barrelFour, mufiTwo));



	}

}
