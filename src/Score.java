/**
 * This Class represents the score of the game.
 * 
 * It contains a score for the game just played.
 * 
 * It compares the previous high score to the current score.
 * 
 * It also checks if the game has been played before to display
 * a unique message for whether the score is a high score.
 * 
 * @author Team 68
 */
public class Score {
	
	private int score;
	private int prevHighScore; // high score before new high score (based on current score)			
	private int highScore;
	private boolean ifGameRetried; // determines if first play of game. Used for scoring
	
	/**
	 * Constructor to initialize values
	 */
	public Score() {
		this.score = 0;
		this.prevHighScore = 0;
		this.highScore = 0;
		this.ifGameRetried = false;
	}
	
	/**
	 * This method calculates the score
	 * 100 points are given for each coin, which is added to the
	 * total distance traveled
	 * @param coinsCollected
	 * @param distance
	 * @return
	 */
	public int calcScore(int coinsCollected, int distance) {
		int score = coinsCollected * 100 + distance;
		return score;
	}
	
	
	/**
	 * This method calculates the high score
	 * @param score
	 */
	public void calcHighScore(int score) {
		//prevHighScore helps determine unique scoring message
		prevHighScore = highScore;
		if (score > highScore) {
			highScore = score;
		}
	}
	

	/**
	 * This method displays a message for the high score depending
	 * on how well the player did
	 * @param score
	 * @return
	 */
	public String displayHighScore(int score) {
		String highScoreString = "High Score: " + highScore;
		
		// if first time playing, score will be the high score
		if (ifGameRetried == false) {
			return highScoreString + "\nIt's your first time. You get the high score!";
		}
		else if (ifGameRetried == true && score == prevHighScore) {
			return highScoreString + "\nNice try! You tied the high score.";
		}
		else if (score < prevHighScore) {
			return highScoreString + "\nBetter luck next time!";
		}
		else {
			return highScoreString + "\nCongrats! New High Score!";
		}
	}
	
	/**
	 * Setter to set current score
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Setter to set if the game has been replayed
	 * @param ifGameRetried
	 */
	public void setIfGameRetried(boolean ifGameRetried) {
		this.ifGameRetried = ifGameRetried;
	}
	
	/**
	 * Gets the current score
	 * @return
	 */
	public int getScore() {
		return score;
	}
	
	
	//The rest of these getters and setters are only used for JUnit
	//They can be commented out while the program is running

	/**
	 * Sets the previous high score
	 * @param prevHighScore
	 */
	public void setPrevHighScore(int prevHighScore) {
		this.prevHighScore = prevHighScore;
	}

	/**
	 * Gets the current high score
	 * @return
	 */
	public int getHighScore() {
		return highScore;
	}

	/**
	 * Sets the current high score
	 * @param highScore
	 */
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
}
