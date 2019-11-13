package application;

/**
 * JumpObject is a specific non-controllable object which inherits from object. 
 * The purpose is to create objects for which the cat can jump over. JumpObject has a box image.
 * @author Team68
 * 
 */
public class JumpObject extends Object{
	
	/**
	 * Inherited constructor from Object. Creates JumpObject based on xPosition, yPosition,
	 * width, height
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	JumpObject(double x, double y, double w, double h) {
		super(x, y, w, h);
		//this.image = box;
	}
}
