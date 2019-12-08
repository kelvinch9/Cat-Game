import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * This class sets up all of the graphics for the game
 * It draws the game start screen and game over screen
 * It also draws all of the objects 
 * 
 * @author Team 68
 */
public class GameGraphics extends JPanel {

	private Stage stage;
	private ImageIcon gameBackground;

	/**
	 * Constructor to initialize values (Stage class and image of game background)
	 * @param stage
	 * @param gameBackground
	 */
	public GameGraphics(Stage stage, ImageIcon gameBackground) {
		this.stage = stage;
		this.gameBackground = gameBackground;

	}

	/**
	 * Start screen for the game
	 * This is after the user has hit the play button
	 * @param g
	 */
	public void drawGameStart(Graphics g) {
		//string message
		String msg = "Press ENTER to play!";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		//sets color and font
		g.setColor(Color.white);
		g.setFont(small);

		//sets height on screen
		int lineDisplayHeight = (stage.getB_HEIGHT() / 2);

		//draws on screen
		g.drawString(msg, (stage.getB_WIDTH() - fm.stringWidth(msg)) / 2,
				lineDisplayHeight);
	}


	/**
	 * This method draws the objects 
	 * (cat, boxes, coins, ghosts, and birds)
	 * @param g
	 */
	public void drawObjects(Graphics g) {

		//draw background
		g.drawImage(gameBackground.getImage(), 0, 0, null);

		//draws the cat
		if (stage.getCat().isVisible()) {
			g.drawImage(stage.getCat().getImage(), stage.getCat().getX(), 
					stage.getCat().getY(), stage);
		}

		//draws the boxes
		for (Box box : stage.getBoxes()) {
			if (box.isVisible()) {
				g.drawImage(box.getImage(), box.getX(), box.getY(), stage);
			}
		}

		//draws the coins
		for (Coin coin : stage.getCoins()) {
			if (coin.isVisible()) {
				g.drawImage(coin.getImage(), coin.getX(), coin.getY(), stage);
			}
		}

		//draws the ghosts
		for (Ghost ghost : stage.getGhosts()) {
			if (ghost.isVisible()) {
				g.drawImage(ghost.getImage(), ghost.getX(), ghost.getY(), stage);
			}
		}

		//draws the bird
		g.drawImage(stage.getBird().getImage(), stage.getBird().getX(), 
				stage.getBird().getY(), stage);

		//writes the scores
		g.setColor(Color.WHITE);
		g.drawString("Coins: " + stage.getCoinsCollected(), 5, 15);
		g.drawString("Ghosts:" + stage.getCat().getGhostsCollected(), 5, 30);
		g.drawString("Distance: 0" + stage.getDistance(), 5, 45);
		g.drawLine(0, 280, stage.getB_WIDTH(), 280);

		//displays a message before the speed up
		if(((stage.getSpeedUpDistance() * stage.getFactor()) - stage.getDistance()) < 50) {
			g.drawString("SPEED UP!", (stage.getB_WIDTH() - 60) / 2,
					stage.getB_HEIGHT() / 2);
		}

		//displays a message while in ghost mode and ghost mode not expiring
		if(stage.getCat().getGhostMode() && !stage.getCat().getGhostModeExpiration()) {
			g.setColor(Color.WHITE);
			g.drawString("GHOST MODE", (stage.getB_WIDTH() - 80) / 2,
					stage.getB_HEIGHT() / 3);
		}
		
		//displays a message while in ghost mode and ghost mode expiring
		if(stage.getCat().getGhostMode() && stage.getCat().getGhostModeExpiration()) {
			g.setColor(Color.RED);
			g.drawString("GHOST MODE EXPIRING IN 1 SECOND", (stage.getB_WIDTH() - 100) / 3,
					stage.getB_HEIGHT() / 3);
		}	
	}



	/**
	 * This displays the game over screen and a player's final score
	 * @param g
	 */
	public void drawGameOver(Graphics g) {

		//final score is 100 points per coin plus total distance traveled
		String msg = "Game Over!\n\nTotal Score: " + stage.getGameScore().getScore() 
		+ "    |    " +	stage.getGameScore().displayHighScore(stage.getGameScore().getScore())
		+ "\n\nPress 'Enter' to replay\n";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		//sets font and color
		g.setColor(Color.white);
		g.setFont(small);

		//height to display message
		int lineDisplayHeight = (stage.getB_HEIGHT() / 3);

		// drawString does not handle new line characters - split on "\n"
		for (String line : msg.split("\n")) {
			g.drawString(line, (stage.getB_WIDTH() - fm.stringWidth(line)) / 2,
					lineDisplayHeight);
			lineDisplayHeight += fm.getHeight() + 5;
		}

	}

}
