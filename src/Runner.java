
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		UI.setFocusable(true);
		UI.addKeyListener(new MyKeyListener());
	
		
		// Create Panel for Start of Game
		JPanel startPanel = new JPanel();
		JButton start = new JButton("Play");
		JButton guide = new JButton("Guide");
		JButton credits = new JButton("Credits");
		
		startPanel.add(start);
		startPanel.add(guide);
		startPanel.add(credits);
		
		
//		startPanel.setFocusable(true);
		
		// add background picture for game
//		BufferedImage myPicture;
//		try {
//		
//			myPicture = ImageIO.read(new File("full-background.png"));
//			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//			startPanel.add(picLabel);
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		
//		JPanel test = new JPanel();
//        test.add(start);
//        test.add(hello);
//        startPanel.setLayout(new BorderLayout());
//        startPanel.add(test, BorderLayout.CENTER);
		
		// create back button
		JButton guideBack = new JButton("Back");
		JButton creditsBack = new JButton("Back");
		
		// Create Panel for Guide
		JPanel guidePanel = new JPanel();
		guidePanel.add(guideBack);
		
		// Create Panel for Credits
		JPanel creditsPanel = new JPanel();
		creditsPanel.add(creditsBack);
		
		
		
		// Create Panel for Game
		JPanel gamePanel = new JPanel();
		game = new Stage();
		gamePanel.add(game);
//		gamePanel.setFocusable(true);
		
		
		// UI - add panels to UI Main panel
		UI.add("startPanel", startPanel);
		UI.add("guidePanel", guidePanel);
		UI.add("creditsPanel", creditsPanel);
		UI.add("gamePanel", gamePanel);
		this.setContentPane(UI);
		cards.show(UI, "1");
		
		// add action for start button - When you click start button, it goes to 
		// next panel which is gamePanel
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "gamePanel");
				inGamePanel = true;
			}
		});

		// add action for back button 
		creditsBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "startPanel");

			}
		});
		
		// add action for back button 
				guideBack.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						cards.show(UI, "startPanel");

					}
				});

		// add action for guide button 
		guide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "guidePanel");

			}
		});

		// add action for guide button 
		credits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "creditsPanel");

			}
		});

		

		setResizable(false);
		pack(); // automatically sets size of JFrame
		setTitle("Cat Game");
		setLocationRelativeTo(null); // centers the window onto screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if window is close it exits game
	}
	
	
	/**
	 * 
	 * KeyListener
	 * @author matthewordway
	 *
	 */
	private class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			
			// allow replay if at beginning or cat died
			if( inGamePanel == true && (game.getIngame() == 0 || game.getIngame() == 2) ) {
				game.play(e);
			}
			
			// if inGamePanel and not in start screen
			if (inGamePanel == true && game.getIngame() != 0 ) {
				game.getCat().keyPressed(e);
			}
			
			
		}
		
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
