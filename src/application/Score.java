package application;

/** 
 * This class calculates the total score and keeps
 * track of the high score.
 * @return
 */
public class Score {

	/**
	 * This method returns the total score for the player
	 * It takes into account the total distance and the number
	 * of mice caught.
	 * @return
	 */
	public int totalScore() {
		Main main = new Main();
		int distance = main.getDistance();
		int mice = main.getMouseCount();
		return distance + mice * 1000;
	}
	
	/**
	 * This method keeps track of the high score for the
	 * current game session
	 * It wipes when the game is exited
	 * @return
	 */
	public int calculateHighScore() {
		int maximum = 0;
		if(totalScore() > maximum) {
			maximum = totalScore();
		}
		return maximum;
	}

}
