
public class Box extends Object{
	
	public Box(int x, int y) {
		super(x,y);
		
		loadImage("box.png");
		getImageDimensions();
	}
	
	public void move() {
		
		if(x < 0) {
			x = 400;
		}
		x -= 1;	
	}
	
}
