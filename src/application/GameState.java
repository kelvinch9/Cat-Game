package application;

import javafx.application.Application;

/**
 * The GameState class displays the state of the game. There are three states:
 * a) Intro - Displays the intro and allows player to start the game
 * b) Start Game - Displays the opening scene
 * c) End Game - Displays the score and allows player to replay the game
 * @author Team68
 *
 */
public class GameState {
	
	private boolean shouldReplay;
	
	/**
	 * Creates GameState with shouldReplay = false
	 */
	public GameState(){
		shouldReplay = false;
	}
	
	/**
	 * Creates the intro scene for the game. The intro scene
	 * will have instructions on how to play the game (up to jump, down to duck). 
	 * It will have a "Start" button to click and a "Credits" button to see the game
	 * creators.
	 * 
	 */
	public void setIntroScene() {
		;
	}
	
	
	
	/**
	 * Creates the start scene for the game. The start scene will display
	 * the cat and the first scene with obstacles and a '0' score. It will say press "space"
	 * to start the game.  
	 * 
	 * 
	 */
	public void setGameStartScene() {
		;
	}
	
	
	
	/**
	 * Creates the game end scene for the game. Once that player dies (collide with object),
	 * the GameEndScene will display. This scene displays the current score, the high score,
	 * and will prompt the user whether to replay the game.
	 * 
	 * Note: High score will only be saved for the next round if the game is replayed.
	 * 
	 * 
	 */
	public void setGameEndScene(Score score) {
		;
	}

	/**
	 * Getter for shouldReplay
	 * @return
	 */
	public boolean isShouldReplay() {
		return shouldReplay;
	}

	/**
	 * Setter for shouldReplay
	 * @param shouldReplay
	 */
	public void setShouldReplay(boolean shouldReplay) {
		this.shouldReplay = shouldReplay;
	}
	
	


}

