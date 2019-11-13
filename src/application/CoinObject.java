package application;

/**
 * CoinObject is a specific non-controllable object which inherits from Object. 
 * CoinObjects can be collected which increase the Player's score.
 * CoinObject has image of mice
 * @author Team68
 *
 */
public class CoinObject extends Object{
	
	/**
	 * Inherited constructor from Object. Creates CoinObject based on xPosition, yPosition,
	 * width, height
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	CoinObject(double x, double y, double w, double h) {
		super(x, y, w, h);
		//this.image = 'mice';
	}


}
