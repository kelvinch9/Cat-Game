import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Class for all the Panels in the game. Includes:
 * (1) gamePanel - the actual game (Stage class)
 * (2) guidePanel - instructions for game
 * (3) creditsPanel - credits for game
 * 
 * @author Team 68
 */
public class GamePanels extends JFrame {

	private Stage game;
	private boolean inGamePanel;   // is gamePanel currently in focus
	private JPanel UI;	// main JPanel
	private CardLayout cards;   // cards organize the JPanels (layout-related)
	
	
	private JButton start; // start button is an instance variable for JUnit test only
	private JButton guide; // guide button is an instance variable for JUnit test only
	private JButton credits; // credits button is an instance variable for JUnit test only
	
	private boolean inGuidePanel; // is guidePanel currently in focus (used for JUnit test only)
	private boolean inCreditsPanel; // is creditsPanel currently in focus (used for JUnit test only)
	


	/**
	 * Constructor for the GamePanels class.
	 * The constructor creates all the panels in the Game UI.
	 * @param game
	 */
	GamePanels(Stage game) {
		this.game = game;
		inGamePanel = false;
		createPanels();
	}


	/**
	 * The method is called in the Constructor and is responsible
	 * for creating all of the panels.
	 */
	private void createPanels() {

		/* creating main JPanel (UI) that holds all the other JPanels
		 *  (Guide, Credits, Game) */
		cards = new CardLayout();
		UI = new JPanel();
		UI.setLayout(cards);
		UI.setFocusable(true);
		UI.addKeyListener(new MyKeyListener()); // allows KeyListener to work across panels

		// call helper methods to create each panel and respective buttons/formatting
		JPanel startPanel = createStartPanel();
		JPanel guidePanel = createGuidePanel();
		JPanel creditsPanel = createCreditsPanel();
		JPanel gamePanel = createGamePanel();

		// add all panels to the UI (main panel)
		UI.add("startPanel", startPanel);
		UI.add("guidePanel", guidePanel);
		UI.add("creditsPanel", creditsPanel);
		UI.add("gamePanel", gamePanel);
		this.setContentPane(UI);
		cards.show(UI, "1");
	}


	/**
	 * Helper method to create the startPanel.
	 * The startPanel allows you to access the other panels (Game, Guide, Credits).
	 * @return
	 */
	private JPanel createStartPanel() {
		JPanel startPanel = new JPanel();
		startPanel.setLayout(new BorderLayout()); // BorderLayout is a layout manager for JPanel

		// create buttons to access other panels
		start = new JButton("Play");
		guide = new JButton("Guide");
		credits = new JButton("Credits");


		// create a JLabel to display text for the panel - includes HTML for formatting
		String startString = "<html><div style='text-align: center;'>"
				+ "<p><b>Welcome to Team 68's Cat Game!</b></p> "
				+ "<br>" // line break
				+ "<br>" // line break
				+ "</div></html>";

		JLabel startText = new JLabel(startString);
		startText.setFont(new Font("Verdana",Font.PLAIN,16));

		// create sub-panels for label and buttons - this is for formatting
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// add labels and buttons to respective panels
		buttonPanel.add(start);
		buttonPanel.add(guide);
		buttonPanel.add(credits);
		labelPanel.add(startText);

		// add label and button panels to main Panel
		startPanel.add(buttonPanel, BorderLayout.CENTER);
		startPanel.add(labelPanel, BorderLayout.PAGE_START);

		// set backgrounds of each panel making up the main panel
		buttonPanel.setBackground(Color.ORANGE);
		labelPanel.setBackground(Color.ORANGE);

		// add action to "start" button
		// if you click start, the panel changes to the gamePanel
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "gamePanel");
				inGamePanel = true;
			}
		});

		// add action to "guide" button
		// if you click guide, the panel changes to the guidePanel 
		guide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "guidePanel");
				inGuidePanel = true;
			}
		});

		// add action to "credits" button
		// if you click credits, the panel changes to the creditsPanel 
		credits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "creditsPanel");
				inCreditsPanel = true;
			}
		});

		return startPanel;
	}


	/**
	 * Helper method to create the guidePanel.
	 * @return
	 */
	private JPanel createGuidePanel() {
		// Create Panel for Guide
		JPanel guidePanel = new JPanel();
		guidePanel.setLayout(new BorderLayout()); // BorderLayout is a layout manager for JPanel

		// create back button to go back to the startPanel
		JButton guideBack = new JButton("Back");

		// create a JLabel to display text for the panel
		String guideString = "<html><div style='text-align: center;'>"
				+ "<p><b>The cat, Mufi, is hungry for coins.</b></p> "
				+ "<br>" // line break
				+ "<p>Press space to jump and</p>"
				+ "<p>avoid the boxes.</p>"
				+ "<br>" // line break
				+ "<p>Watch out for speed increases!</p>"
				+ "<p><i>Speed increases every 1000 distance.</i></p>"
				+ "<br>" // line break
				+ "<p>Collect ghosts to become a ghost cat!</p>"
				+ "<p>Press the G key to activate ghost mode.</p>"
				+ "<p><i>In ghost mode, you can run through boxes </i></p>"
				+ "<p><i>for a short period of time. </i></p>"
				+ "</div></html>";

		JLabel guideText = new JLabel(guideString);
		guideText.setFont(new Font("Verdana",Font.PLAIN,16));

		// add panels for the Button and the JLabel - this is for formatting 
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// add labels and buttons to respective panels
		labelPanel.add(guideText);
		buttonPanel.add(guideBack);

		// add label and button panels to main Panel
		guidePanel.add(labelPanel, BorderLayout.NORTH); // puts in north quadrant
		guidePanel.add(buttonPanel, BorderLayout.SOUTH); // puts in south quadrant


		// add action to "back" button
		// if you click back, the panel changes back to the startPanel 
		guideBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "startPanel");
				inGuidePanel = false;
			}
		});
		return guidePanel;
	}


	/**
	 * Helper method for the creditsPanel.
	 * @return
	 */
	private JPanel createCreditsPanel() {

		// Create Panel for Credits
		JPanel creditsPanel = new JPanel();
		creditsPanel.setLayout(new BorderLayout()); // BorderLayout is a layout manager for JPanel


		// create back button to go back to the startPanel
		JButton creditsBack = new JButton("Back");


		// create a JLabel to display text for the panel - w/ HTML for display
		String creditsString = "<html><div style='text-align: center;'>"
				+ "<p><b>Created by Team 68.</b></p> "
				+ "<br>" // line break
				+ "<p>Danielle Coates, Kelvin Cheung,</p>"
				+ "<p>and Matthew Ordway</p>"
				+ "</div></html>";
		JLabel creditsText = new JLabel(creditsString);
		creditsText.setFont(new Font("Verdana",Font.PLAIN,16));
		creditsPanel.add(creditsText);


		// add panels for the Button and the JLabel - this is for formatting 
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// add labels and buttons to respective panels
		labelPanel.add(creditsText);
		buttonPanel.add(creditsBack);

		// add label and button panels to main Panel
		creditsPanel.add(labelPanel, BorderLayout.NORTH); // put in north quadrant
		creditsPanel.add(buttonPanel, BorderLayout.SOUTH); // put in south quadrant


		// add action to "back" button
		// if you click back, the panel changes back to the startPanel
		creditsBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cards.show(UI, "startPanel");
				inCreditsPanel = false;
			}
		});

		return creditsPanel;
	}


	/**
	 * Helper method to create the gamePanel.
	 * @return
	 */
	private JPanel createGamePanel() {
		// Create Panel for Game
		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(Color.BLACK);

		// Add the game (Stage Class) to the gamePanel
		game = new Stage();
		gamePanel.add(game);
		//gamePanel.setFocusable(true);

		return gamePanel;
	}


	/**
	 * Getter for the UI JPanel.
	 * @return
	 */
	public JPanel getUI() {
		return UI;
	}
	
	
	/**
	 * Getter for inGamePanel boolean.
	 * Used for JUnit test only.
	 * @return
	 */
	public boolean isInGamePanel() {
		return inGamePanel;
	}
	

	/**
	 * Getter for start button.
	 * Used for JUnit test only.
	 * @return
	 */
	public JButton getStart() {
		return start;
	}
	
	/**
	 * Getter for guide button.
	 * Used for JUnit test only.
	 * @return
	 */
	public JButton getGuide() {
		return guide;
	}
	
	/**
	 * Getter for credits button.
	 * Used for JUnit test only.
	 * @return
	 */
	public JButton getCredits() {
		return credits;
	}
	
	/**
	 * Getter for inGuidePanel.
	 * Used for JUnit test only.
	 * @return
	 */
	public boolean isInGuidePanel() {
		return inGuidePanel;
	}

	/**
	 * Getter for inCreditsPanel.
	 * Used for JUnit test only.
	 * 
	 * @return
	 */
	public boolean isInCreditsPanel() {
		return inCreditsPanel;
	}






	/**
	 * MyKeyListener Class that allows keys to be pressed in the gamePanel (Stage Class). 
	 * @author Team 68
	 */
	private class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {

			// allow replay if at beginning or cat died
			if( inGamePanel == true 
					&& (game.getStageOfGame() == 0 || game.getStageOfGame() == 2) ) {
				game.play(e);
			}

			// if inGamePanel and not in start screen
			if (inGamePanel == true && game.getStageOfGame() != 0 ) {
				game.getCat().keyPressed(e);
			}
		}
	}
}
