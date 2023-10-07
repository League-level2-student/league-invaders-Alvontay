import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject { 
	
	boolean up, down, left, right = false;
	
	 public Rocketship(int x, int y, int width, int height) {
		 super(x, y, width, height);
		 speed = 10;
	 }
	 
	 void draw(Graphics g) {
	        g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);
	 }
	 
	 public void update() {
		 if (up && y-speed < LeagueInvaders.HEIGHT) {
			 y-=speed;
		 }
		 
		 if (down && y+speed > 0) {
			 y+=speed;
		 }
		 
		 if (right && x+speed < LeagueInvaders.WIDTH) {
			 x+=speed;
		 }
		 
		 if (left && x-speed > 0) {
			 x-=speed;
		 }
			 
	 }
}


