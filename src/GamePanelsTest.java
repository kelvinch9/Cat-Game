import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for GamePanels class.
 * @author Team 68
 *
 */
class GamePanelsTest {
	
	/**
	 * Tests the start button and whether it changes
	 * the panel the game.
	 */
	@Test
	void testStartButton() {
		GamePanels panels = new GamePanels(new Stage());
		assertEquals(false, panels.isInGamePanel());
		
		JButton start = panels.getStart();
		start.doClick();
		assertEquals(true, panels.isInGamePanel());
	}

}
