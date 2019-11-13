package application;

/** 
 * This class calculates the total score and keeps
 * track of the high score.
 * @author Team68
 */
public class Score {
	
	private int maxScore;
	private int score;

	/**
	 * Constructor for Score class. Sets maxScore to 0. Sets score to 0.
	 * 
	 */
	public Score() {
		maxScore = 0;
		score = 0;
	}
	
	/**
	 * This method returns the total score for the player
	 * It takes into account the total distance and the number
	 * of mice caught.
	 * @return
	 */
	public int totalScore(int distance, int mice) {
		score = distance + mice * 1000;
		return score;
	}
	
	/**
	 * This method keeps track of the high score for the
	 * current game session
	 * It wipes when the game is exited
	 * @return
	 */
	public int calculateHighScore() {
		if(score > maxScore) {
			maxScore = score;
		}
		return maxScore;
	}

}
