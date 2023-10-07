import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font instructionsFont;
    Timer frameDraw;
    Rocketship rocketship;
    
    public GamePanel() {
        titleFont = new Font("Arial", Font.PLAIN, 48);
        instructionsFont = new Font("Arial", Font.PLAIN, 24);
        frameDraw = new Timer(1000/60, this);
        frameDraw.start();
        rocketship = new Rocketship(250, 700, 50, 50);
    }
	
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
		    drawMenuState(g);
		} else if (currentState == GAME) {
		    drawGameState(g);
		} else if (currentState == END) {
		    drawEndState(g);
		}
	}
	
	void updateMenuState() {
	
	}
	 
	void updateGameState() {
		rocketship.update();
	}
	 
	void updateEndState()  {
	
	}
	
	void drawMenuState(Graphics g) {	
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		
		g.drawString("LEAGUE INVADERS", 15, 150);
		
		g.setFont(instructionsFont);
		
		g.drawString("Press ENTER to start", LeagueInvaders.WIDTH/2 - 135, 400);		
		g.drawString("Press SPACE for instructions", LeagueInvaders.WIDTH/2 - 170, 500);
		
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		rocketship.draw(g);
	}
	
	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		
		g.drawString("GAME OVER", 90, 150);
		
		g.setFont(instructionsFont);
		
		g.drawString("You killed __ Enemies", LeagueInvaders.WIDTH/2 - 130, 400);		
		g.drawString("Press ENTER to restart", LeagueInvaders.WIDTH/2 - 140, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
		    updateMenuState();
		} else if (currentState == GAME) {
		    updateGameState();
		} else if (currentState == END) {
		    updateEndState();
		}
		
//		System.out.println(e);
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		
		if (currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    rocketship.up = true;
			}
			
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    rocketship.down = true;
			} 
			
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {			   
				rocketship.right = true;
			} 
			
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				rocketship.left = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    rocketship.up = false;
			}
			
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    rocketship.down = false;
			} 
			
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {			   
				rocketship.right = false;
			} 
			
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				rocketship.left = false;
			}
		}		
	}
	
}
