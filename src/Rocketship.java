import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject { 

	boolean up, down, left, right = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		loadImage ("rocket.png");
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	public void update() {
		
		super.update();

		if (up && y-speed > 0) {
			y-=speed;
		}

		if (down && y+speed < LeagueInvaders.HEIGHT - height*2) {
			y+=speed;
		}

		if (right && x+speed < LeagueInvaders.WIDTH - width*1.5) {
			x+=speed;
		}

		if (left && x-speed > 0) {
			x-=speed;
		}

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public Projectile newProjectile() {
		return new Projectile(x+width/2, y, 10, 10);
	} 
}


