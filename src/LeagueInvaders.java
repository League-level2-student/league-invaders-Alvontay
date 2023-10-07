import javax.swing.JFrame;

public class LeagueInvaders {
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame frame;
	GamePanel gamePanel;
	
	
	public static void main(String[] args) {
		new LeagueInvaders().setup();
	}
	
	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	} 
	
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePanel);
	}
	

}
