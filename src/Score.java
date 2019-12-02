/**
 * 
 * Score class
 * 
 * @author matthewordway
 *
 */
public class Score {
	
	private int score;
	private int prevHighScore; // high score before new high score (based on current score)			
	private int highScore;
	private boolean ifGameRetried; // determine if this is first play of game. used for scoring
	
	
	public Score() {
		this.score = 0;
		this.prevHighScore = 0;
		this.highScore = 0;
		this.ifGameRetried = false;
	}
	
	public int calcScore(int coinsCollected, int distance) {
		int score = coinsCollected * 100 + distance;
		return score;
	}
	
	
	/**
	 * This method calculates the high score
	 * @param score
	 */
	public void calcHighScore(int score) {
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
			return highScoreString + "\nNice try! You almost beat the high score.";
		}
		else if (score < prevHighScore) {
			return highScoreString + "\nBetter luck next time!";
		}
		else {
			return highScoreString + "\nCongrats! New High Score!";
		}
		
	}
	
	

	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public int getPrevHighScore() {
		return prevHighScore;
	}



	public void setPrevHighScore(int prevHighScore) {
		this.prevHighScore = prevHighScore;
	}



	public int getHighScore() {
		return highScore;
	}



	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}



	public boolean isIfGameRetried() {
		return ifGameRetried;
	}



	public void setIfGameRetried(boolean ifGameRetried) {
		this.ifGameRetried = ifGameRetried;
	}
	
	

}
