
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * This class runs the game. It extends the JFrame class
 * to use the Swing library.
 * @author Danielle
 *
 */
public class Runner extends JFrame{
	
	GamePanels panels;
	Stage gameStage;

	/**
	 * This method runs the game
	 */
	public Runner() {
		// instantiate Stage and GamePanels variables
		gameStage = new Stage();
		panels = new GamePanels(gameStage);
		add(panels.getUI()); // add UI JPanel to JFrame

		// various settings for JFrame
		setResizable(false);
		pack(); // automatically sets size of JFrame
		setTitle("Cat Game");
		setLocationRelativeTo(null); // centers the window onto screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit game if window is closed
		
		
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
