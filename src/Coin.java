
public class Coin extends Object{

	public Coin(int x, int y) {
		super (x,y);
		
		loadImage("coin.png");
		getImageDimensions();
	}
	
	public void move() {
		
		if(x < 0) {
			x = 400;
		}
		x -= 1;	
	}

}
