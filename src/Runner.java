import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class runs the game. It extends the JFrame class
 * to use the Swing library.
 * @author Danielle
 *
 */
public class Runner extends JFrame{

	/**
	 * This method runs the game
	 */
	public Runner() {
		
		initUI();
		
	}
	
	/**
	 * This method sets the window and opens the game
	 */
	private void initUI() {
		
// -------- BEGIN CODE -------		
		// Create CardLayout Panel to switch between "cards" (diff. screens)
		CardLayout cards = new CardLayout();
		JPanel UI = new JPanel();
		UI.setLayout(cards);
	
		
//		contentPane.setLayout(cardLayout);
		
		// Create Panel for Start of Game
		Panel startPanel = new Panel();
		JButton start = new JButton("start");		
		startPanel.add(start);
		
		
		// Create Panel for Game
		Panel gamePanel = new Panel();
		Stage game = new Stage();
		gamePanel.add(game);
		
		
		// UI - add panels to UI Main panel
		UI.add("2", startPanel);
		UI.add("3", gamePanel);
		this.setContentPane(UI);
		cards.show(UI, "1");
		
		// add action for start button - When you click start button, it goes to 
		// next panel which is gamePanel
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cards.next(UI);
				
			}
			
		});
		
		
		
// --------- END - TEST OF JPANELS --------- 		
		
		
		// COMMENTED OUT
//		add(new Stage());
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
