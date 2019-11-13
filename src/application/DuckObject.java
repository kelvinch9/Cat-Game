package application;

/**
 * DuckObject is a specific non-controllable object which inherits from object. 
 * The purpose is to create objects for which the cat can duck under. Image of duck object is a tree
 * @author Team68
 *
 */
public class DuckObject extends Object {
	
	/**
	 * Inherited constructor from Object. Creates DuckObject based on xPosition, yPosition,
	 * width, height
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	DuckObject(double x, double y, double w, double h) {
		super(x, y, w, h);
		//this.image = 'tree';
	}

}
