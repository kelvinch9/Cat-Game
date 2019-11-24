import java.awt.EventQueue;
import javax.swing.JFrame;

public class Runner extends JFrame{

	public Runner() {
		
		initUI();
		
	}
	
	private void initUI() {
		
		add(new Stage());
		setResizable(false);
		pack(); // automatically sets size of JFrame
		setTitle("Cat Game");
		setLocationRelativeTo(null); // centers the window onto screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if window is close it exits game
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            Runner ex = new Runner();
            ex.setVisible(true);
        });
    }
	
}
