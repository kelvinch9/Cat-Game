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
    
    public Stage() {

        initStage();
    }

    private void initStage() { // for the initial state of the game

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        cat = new Cat(40, FLOOR);

        initBoxes();
        initCoins();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initBoxes() {
        
        boxes = new ArrayList<>();
        
        for(int i = 0; i < 50; i++) {
        	Random rand = new Random();
        	int r = rand.nextInt(1000)+300;
        	boxes.add(new Box(r, FLOOR));
        }    
    }
    
    public void initCoins() {
    	
    	coins = new ArrayList<>();
    	for(int i = 0; i < 50; i++) {
        	Random rand = new Random();
        	int r = rand.nextInt(1000)+300;
        	coins.add(new Coin(r, FLOOR - 35));
        }    
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

    private void drawObjects(Graphics g) {

        if (cat.isVisible()) {
            g.drawImage(cat.getImage(), cat.getX(), cat.getY(),
                    this);
        }

        for (Box box : boxes) {
            if (box.isVisible()) {
                g.drawImage(box.getImage(), box.getX(), box.getY(), this);
            }
        }
        
        for (Coin coin : coins) {
            if (coin.isVisible()) {
                g.drawImage(coin.getImage(), coin.getX(), coin.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Coins: " + coins_collected, 5, 15);
        g.drawString("Score: 0" + boxes.size(), 5, 30);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateCat();
        updateBoxes();
        updateCoins();

        checkCollisions();

        repaint();
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }

    private void updateCat() {

        if (cat.isVisible()) {
        	
            cat.move();
        }
    }

    private void updateBoxes() {

        for (int i = 0; i < boxes.size(); i++) {

            Box a = boxes.get(i);
            
            if (a.isVisible()) {
                a.move();
            } else {
            	boxes.remove(i);
            }
        }
    }
    
    private void updateCoins() {

        for (int i = 0; i < coins.size(); i++) {

            Coin a = coins.get(i);
            
            if (a.isVisible()) {
                a.move();
            } else {
            	coins.remove(i);
            }
        }
    }

    public void checkCollisions() {

        Rectangle r3 = cat.getBounds();

        for (Box box : boxes) {
            
            Rectangle r2 = box.getBounds(); // get the bounds of collision

            if (r3.intersects(r2)) {
                
                cat.setVisible(false);
                box.setVisible(false);
                ingame = false;
            }
        }

        Rectangle cat_collision = cat.getBounds();
        
        for(Box box : boxes) {
        	Rectangle box_collision = box.getBounds();
        	if(cat_collision.intersects(box_collision)) { // intersects is a Rectangle method
        		cat.setVisible(false);
        	}
        }
        
        for(Coin coin : coins) {
        	Rectangle coin_collision = coin.getBounds();
        	if(cat_collision.intersects(coin_collision)) {
        		coins_collected++;
        	}
        }
        

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            cat.keyPressed(e);
        }
    }
}