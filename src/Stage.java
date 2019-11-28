import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private List<Box> boxes;
	private List<Coin> coins;
	private boolean ingame;
	private final int B_WIDTH = 400;
	private final int B_HEIGHT = 300;
	private final int DELAY = 15;
	public final int FLOOR = 250; // this is considered the floor. Leave as public
	private int coins_collected = 0;
	private int distance = 1;
	private int factor = 1;
	private int speedUpDistance = 1000;
	private int score = 0;
	private int highScore = 0;
	private boolean ifGameRetried = false; // determine if this is first play of game. used for scoring

	/**
	 * This method calls to set the stage of the game
	 */
	public Stage() {

		initStage();
	}

	/**
	 * This method sets the initial state of the game
	 */
	private void initStage() { 

		addKeyListener(new TAdapter());
		setFocusable(true);

		//background color
		setBackground(Color.BLACK);

		//no game over
		ingame = true;

		//sets the dimensions of the game
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

		//creates the cat, the player character
		cat = new Cat(40, FLOOR);

		//creates arraylist for boxes and coins
		initBoxes();
		initCoins();

		//the timer for the game, which allows the game to 
		//continuously run
		timer = new Timer(DELAY, this);
		timer.start();
	}

	/**
	 * This method creates the array list of boxes
	 * for the cat to avoid and sets the first box
	 */
	public void initBoxes() {

		boxes = new ArrayList<>();
		boxes.add(new Box(400, FLOOR));
	}

	/**
	 * This method creates the array list of coins
	 * for the cat to collect and sets the first coin 
	 */
	public void initCoins() {

		coins = new ArrayList<>();
		coins.add(new Coin(250, FLOOR - 40));
	}



	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (ingame) {

			drawObjects(g);

		} else {

			drawGameOver(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}


	/**
	 * This method draws the objects (cat, boxes, and coins)
	 * @param g
	 */
	private void drawObjects(Graphics g) {

		//draws the cat
		if (cat.isVisible()) {
			g.drawImage(cat.getImage(), cat.getX(), cat.getY(),
					this);
		}

		//draws the boxes
		for (Box box : boxes) {
			if (box.isVisible()) {
				g.drawImage(box.getImage(), box.getX(), box.getY(), this);
			}
		}

		//draws the coins
		for (Coin coin : coins) {
			if (coin.isVisible()) {
				g.drawImage(coin.getImage(), coin.getX(), coin.getY(), this);
			}
		}

		//writes the scores
		g.setColor(Color.WHITE);
		g.drawString("Coins: " + coins_collected, 5, 15);
		g.drawString("Distance: 0" + distance, 5, 30);
		g.drawLine(0, 280, B_WIDTH, 280);

		//displays a message before the speed up
		if(((speedUpDistance * factor) - distance) < 50) {
			g.drawString("SPEED UP!", (B_WIDTH - 60) / 2,
					B_HEIGHT / 2);
		}
	}
	
	
	private void calcHighScore(int score) {
		if (score > highScore) {
			highScore = score;
		}
	}
	
	private String displayHighScore(int score) {
		String highScoreString = "\nHigh Score: " + highScore;
		
		// if first time playing, score will be the high score
		if (ifGameRetried == false && score == highScore) {
			return highScoreString + "\nIt's your first time. You get the high score!";
		}
		else if (ifGameRetried == true && score == highScore) {
			return highScoreString + "\nNice try! You almost beat the high score.";
		}
		else if (score < highScore) {
			return highScoreString + "\nBetter luck next time";
		}
		else {
			return highScoreString + "\nCongrats! New High Score!";
		}
		
	}

	/**
	 * This displays the game over screen and a player's final score
	 * @param g
	 */
	private void drawGameOver(Graphics g) {

		//final score is 100 points per coin plus total distance traveled
		String msg = "Game Over!  Total Score: " + score + 
				"\n\nPress 'Enter' to replay\n" + displayHighScore(score);
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		
		int lineDisplayHeight = (B_HEIGHT / 2);
		
		// drawString does not handle new line characters - split on "\n"
		for (String line : msg.split("\n")) {
			g.drawString(line, (B_WIDTH - fm.stringWidth(line)) / 2,
					lineDisplayHeight);
			lineDisplayHeight += fm.getHeight() + 5;
		}
		
	}
	

	/**
	 * Replay method. Called in TAdapter Class at bottom.
	 * If user presses enter, restart the game.
	 * @param e
	 */
	public void replay(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ENTER) {
			initStage();
			
			// reset instance variables
			coins_collected = 0;
			distance = 1;
			factor = 1;
			score = 0;
			
			// sets game retry to true
			ifGameRetried = true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//check that game isn't over
		inGame();

		//update the location of cat, boxes, and coins
		updateCat();
		updateBoxes();
		updateCoins();

		//checks if the objects collide
		checkCollisions();

		//repaints the game 
		repaint();
		
	}

	/**
	 * This method stops the time if the game is over and calculates the score
	 */
	private void inGame() {

		if (!ingame) {
			timer.stop();
			score = coins_collected * 100 + distance;
			System.out.println(score);// testing
			calcHighScore(score);
			
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
		if(!(((speedUpDistance * factor) - distance - 200) < 0)) {
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
			if(cat_collision.intersects(box_collision)) { 
				cat.setVisible(false);
				box.setVisible(false);
				ingame = false;
			}
		}

		//checks if the cat get a coin, if so, it removes it
		for(int i = 0; i < coins.size(); i++) {
			Coin coin = coins.get(i);
			Rectangle coin_collision = coin.getBounds();
			if(cat_collision.intersects(coin_collision)) {
				coins_collected++;
				coins.remove(i);
			}
		}
	}


	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			cat.keyPressed(e);
			
			// allow replay if not in game
			if(!ingame) {
				replay(e);  
			}
			
		}
	}
}