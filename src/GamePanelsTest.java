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
	 * the panel to the game.
	 */
	@Test
	void testStartButton() {
		GamePanels panels = new GamePanels(new Stage());
		assertEquals(false, panels.isInGamePanel());
		
		JButton start = panels.getStart();
		start.doClick();
		assertEquals(true, panels.isInGamePanel());
	}
	
	/**
	 * Tests the guide button and whether it changes
	 * the panel to the guide panel.
	 */
	@Test
	void testGuideButton() {
		GamePanels panels = new GamePanels(new Stage());
		assertEquals(false, panels.isInGuidePanel());
		
		JButton guide = panels.getGuide();
		guide.doClick();
		assertEquals(true, panels.isInGuidePanel());
	}
	
	/**
	 * Tests the credits button and whether it changes
	 * the panel to the credits panel.
	 */
	@Test
	void testCreditsButton() {
		GamePanels panels = new GamePanels(new Stage());
		assertEquals(false, panels.isInCreditsPanel());
		
		JButton credits = panels.getCredits();
		credits.doClick();
		assertEquals(true, panels.isInCreditsPanel());
	}

}
