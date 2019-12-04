import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * This class represents the objects, including the cat 
 * and what it interacts with. It can represent barriers 
 * that cause game over or coins to improve score.
 * @author Team 68
 *
 */
public class Object {
	
    protected int x;
    protected int y;
    protected int factor;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    /**
     * Constructor to initialize values
     * @param x
     * @param y
     */
    public Object(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
        factor = 1;
    }

    /**
     * This gets the image dimensions to determine a collision
     */
    protected void getImageDimensions() {

    	// the dimensions determine collision
    	// subtracted 5 to make the visual look more accurate
        width = image.getWidth(null) - 5;
        height = image.getHeight(null) - 5;
    }

    /**
     * This method loads the image
     * @param imageName
     */
    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    /**
     * Getter for the image
     * @return
     */
    public Image getImage() { 
        return image;
    }

    /**
     * Getter for the object's x
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Setter to set the object's x    
     * @param x
     */
    public void setX(int x) {
		this.x = x;
	}

	/**
     * Getter for the object's y
     * @return
     */
    public int getY() {
        return y;
    }
    
    /**
	 * Gets the factor to increase speed by
	 * @return
	 */
	public int getFactor() {
		return factor;
	}
	
	/**
	 * Sets the factor to increase speed by
	 * @param factor
	 */
	public void setFactor(int factor) {
		this.factor = factor;
	}

	/**
     * Getter to determine if the object is visible
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets the object's visibility
     * @param visible
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * Getter for the bounds of a rectangle
     * @return
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

