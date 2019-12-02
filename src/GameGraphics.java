import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

/**
 * 
 * Graphics for game
 * @author matthewordway
 *
 */
public class GameGraphics extends JPanel {

	Stage stage;
	ImageIcon gameBackground;

	public GameGraphics(Stage stage, ImageIcon gameBackground) {
		this.stage = stage;
		this.gameBackground = gameBackground;
	}

	/**
	 * Start screen for the game
	 * @param g
	 */
	public void drawGameStart(Graphics g) {
		String msg = "Press ENTER to play!";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);

		int lineDisplayHeight = (stage.getB_HEIGHT() / 2);

		// drawString does not handle new line characters - split on "\n"
		for (String line : msg.split("\n")) {
			g.drawString(line, (stage.getB_WIDTH() - fm.stringWidth(line)) / 2,
					lineDisplayHeight);
			lineDisplayHeight += fm.getHeight() + 5;
		}

	}


	/**
	 * This method draws the objects (cat, boxes, and coins)
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

		//writes the scores
		g.setColor(Color.WHITE);
		g.drawString("Coins: " + stage.getCoinsCollected(), 5, 15);
		g.drawString("Distance: 0" + stage.getDistance(), 5, 30);
		g.drawLine(0, 280, stage.getB_WIDTH(), 280);

		//displays a message before the speed up
		if(((stage.getSpeedUpDistance() * stage.getFactor()) - stage.getDistance()) < 50) {
			g.drawString("SPEED UP!", (stage.getB_WIDTH() - 60) / 2,
					stage.getB_HEIGHT() / 2);
		}
	}



	/**
	 * This displays the game over screen and a player's final score
	 * @param g
	 */
	public void drawGameOver(Graphics g) {

		//final score is 100 points per coin plus total distance traveled
		String msg = "Game Over!\n\nTotal Score: " + stage.gameScore.getScore() + "    |    " +
				stage.gameScore.displayHighScore(stage.gameScore.getScore()) + 
				"\n\nPress 'Enter' to replay\n";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);

		int lineDisplayHeight = (stage.getB_HEIGHT() / 3);

		// drawString does not handle new line characters - split on "\n"
		for (String line : msg.split("\n")) {
			g.drawString(line, (stage.getB_WIDTH() - fm.stringWidth(line)) / 2,
					lineDisplayHeight);
			lineDisplayHeight += fm.getHeight() + 5;
		}

	}

}
