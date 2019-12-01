
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * This class runs the game. It extends the JFrame class
 * to use the Swing library.
 * @author Danielle
 *
 */
public class Runner extends JFrame{
	
	
	Stage game;
	boolean inGamePanel = false;

	/**
	 * This method runs the game
	 */
	public Runner() {
		this.game = new Stage();
		initUI();
		
	}
	
	/**
	 * This method sets the window and opens the game
	 */
	private void initUI() {
		
		GamePanels panels = new GamePanels(game);
		add(panels.getUI());

		setResizable(false);
		pack(); // automatically sets size of JFrame
		setTitle("Cat Game");
		setLocationRelativeTo(null); // centers the window onto screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if window is close it exits game
	}
	
	

	/**
	 * Main method to run the game and set it to be visible
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            Runner ex = new Runner();
            ex.setVisible(true);
        });
    }
	
}
