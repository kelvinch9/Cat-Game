package application;

/**
 * CoinObject is a specific non-controllable object which inherits from Object. CoinObjects do not have collision. CoinObjects can be collected which increase the Player's score
 * @author Kelvin
 *
 */
public class CoinObject extends Object{
	
	int scoreValue;
	
	CoinObject(double x, double y, double w, double h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter for scoreValue
	 * @return
	 */
	public int getScoreValue() {
		return scoreValue;
	}
	
	

}
