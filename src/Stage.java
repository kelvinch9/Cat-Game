import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class represents the stage of the game. It extends
 * JPanel and implements ActionListener, both of which are
 * parts of the Swing library
 * @author Team 68
 *
 */
public class Stage extends JPanel implements ActionListener {

	private Timer timer;
	private Cat cat;
	private Bird bird;
	private List<Box> boxes;
	private List<Coin> coins;
	private int stageOfGame;   // 0 = start screen; 1 = in game; 2 = game over
	private final int B_WIDTH = 400; // screen width
	private final int B_HEIGHT = 300; // screen height
	private final int DELAY = 15;
	public final int FLOOR = 250; // this is considered the floor. Leave as public
	private int coinsCollected = 0;
	private int distance = 1;
	private int factor = 1;
	private int speedUpDistance = 1000;
	private final ImageIcon background = new ImageIcon("grass.png");
	
	Score gameScore;
	GameGraphics gameGraphics;
	

	/**
	 * This method calls to set the stage of the game
	 */
	public Stage() {
		
		// initialize variables
		gameScore = new Score();
		stageOfGame = 0;
		gameGraphics = new GameGraphics(this, background);
		
		// settings for JPanel (game window)
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
	}
	


	/**
	 * This method sets the initial state of the game
	 */
	private void initStage() { 

		//creates the cat, the player character
		cat = new Cat(40, FLOOR);
	
		//creates ArrayList for boxes and sets the first box
		boxes = new ArrayList<>();
		boxes.add(new Box(400, FLOOR));
		
		//creates ArrayList for coins and sets the first coin
		coins = new ArrayList<>();
		coins.add(new Coin(250, FLOOR - 40));

		//creates bird
		bird = new Bird(40, FLOOR - 40);

		//the timer for the game, which allows the game to 
		//continuously run
		timer = new Timer(DELAY, this);
		timer.start();
	}

	

	
	/**
	 * This method paints the screen
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw start screen
		if (stageOfGame == 0) {
			gameGraphics.drawGameStart(g);
		}
		
		// draw objects when in game
		else if( stageOfGame == 1) {
			gameGraphics.drawObjects(g);

		}
		
		// draw game over when game over
		else {
			gameGraphics.drawGameOver(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}




	/**
	 * Play / replay method. Called in TAdapter Class at bottom.
	 * If user presses enter, starts the game.
	 * @param e
	 */
	public void play(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ENTER) {
			if(stageOfGame == 2) {

				// reset instance variables
				coinsCollected = 0;
				distance = 1;
				factor = 1;
				gameScore.setScore(0);
				
				// sets game retry to true
				gameScore.setIfGameRetried(true);
			}
			stageOfGame = 1;
			initStage();
			
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		//check if game is over
		ifGameOver();

		//update the location of cat, boxes, coins, and bird
		updateCat();
		updateBoxes();
		updateCoins();
		bird.move();

		//checks if the objects collide
		checkCollisions();

		//repaints the game 
		repaint();
		
	}

	/**
	 * This method stops the time if the game is over and calculates the score
	 */
	private void ifGameOver() {

		if (stageOfGame == 2) {
			timer.stop();
			int score = gameScore.calcScore(coinsCollected, distance);
			gameScore.setScore(score);
			gameScore.calcHighScore(score);
			
		}
	}

	/**
	 * This method updates the cat's position and its distance
	 */
	private void updateCat() {

		if (cat.isVisible()) {

			cat.move();
			distance++;

			//increases the speed of the game after every 1000 traveled
			if(distance % speedUpDistance == 0) {
				factor++;
				cat.setFactor(factor);
			}
		}
		
//		if(cat.getGhost()) {
//			int temp = factor;
//			factor = 2*factor;
//		}
		
	}

	/**
	 * This method updates the boxes' positions
	 * It also checks to see if a new box will be
	 * randomly generated and if it is, it adds it
	 * to the boxes array list
	 */
	private void updateBoxes() {
		
		if(!boxes.isEmpty()) {
			//for each box, move it through the screen
			for (int i = 0; i < boxes.size(); i++) {

				Box a = boxes.get(i);

				if (a.isVisible()) {
					a.move();
					a.setFactor(factor);
					//if the box moves off the screen, remove it
					if(a.getX() < 2) {
						boxes.remove(i);
					}
				} 
				else {
					boxes.remove(i);
				}
			}
		}
		if(!(((speedUpDistance * factor) - distance < 400) &&
				((speedUpDistance * factor) - distance > 200))){
			//if there are boxes in the array list
			if(!boxes.isEmpty()) {
				//checks if there is enough distance between boxes
				if(boxes.get(boxes.size() - 1).getX() <= 230) {
					if(Math.random() < 0.03) {
						Box temp = new Box(400, FLOOR);
						boxes.add(temp);
					}
				}
			}
			//add a box to the end of the screen if no current boxes
			else {
				Box temp = new Box(400, FLOOR);
				boxes.add(temp);
			}
		}
	}

	/**
	 * This method updates the coins on screen by moving
	 * them across the screen. It also randomly generates
	 * more coins
	 */
	private void updateCoins() {

		//randomly adds a coin
		if(Math.random() < 0.005) {
			Coin temp = new Coin(400, FLOOR - 35);
			coins.add(temp);
		}
		else if(Math.random() < .01) {
			if(!boxes.isEmpty()) {
				if(!(boxes.get(boxes.size() - 1).getX() >= 360)) {
					Coin temp = new Coin(390, FLOOR);
					coins.add(temp);
				}
			}
			else {
				Coin temp = new Coin (390, FLOOR);
				coins.add(temp);
			}
		}


		if(!coins.isEmpty()) {
			//for each coin, moves it across the screen
			for (int i = 0; i < coins.size(); i++) {

				Coin a = coins.get(i);

				if (a.isVisible()) {
					a.move();
					if(a.getX() < 2) {
						coins.remove(i);
					}
					a.setFactor(factor);
				} 
				else {
					coins.remove(i);
				}
			}
		}
	}

	
	
	/**
	 * This method checks to see if the cat collides with
	 * objects. If it hits a box, the game is over. If it hits
	 * a coin, the score is updated.
	 */
	public void checkCollisions() {

		Rectangle cat_collision = cat.getBounds();

		//checks to see if the cat hits a box, if so, game over
		for(Box box : boxes) {
			Rectangle box_collision = box.getBounds();
			// intersects is a Rectangle method
			if(cat_collision.intersects(box_collision) && (!cat.getGhost())) { 
				cat.setVisible(false);
				box.setVisible(false);
				stageOfGame = 2;
			}
		}

		//checks if the cat get a coin, if so, it removes it
		for(int i = 0; i < coins.size(); i++) {
			Coin coin = coins.get(i);
			Rectangle coin_collision = coin.getBounds();
			if(cat_collision.intersects(coin_collision)) {
				coinsCollected++;
				coins.remove(i);
			}
		}
	}


	public Cat getCat() {
		return cat;
	}

	public int getStageOfGame() {
		return stageOfGame;
	}

	public List<Box> getBoxes() {
		return boxes;
	}


	public List<Coin> getCoins() {
		return coins;
	}


	public int getB_WIDTH() {
		return B_WIDTH;
	}


	public int getB_HEIGHT() {
		return B_HEIGHT; 
	}


	public int getCoinsCollected() {
		return coinsCollected;
	}


	public int getDistance() {
		return distance;
	}


	public int getFactor() {
		return factor;
	}


	public int getSpeedUpDistance() {
		return speedUpDistance;
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(stageOfGame == 0 || stageOfGame == 2) {
				play(e);
			}
			
			cat.keyPressed(e);
			
		}
	}
}