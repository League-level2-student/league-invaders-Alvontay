import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectManager implements ActionListener {
	
	Rocketship rocket;
	List <Projectile> projectiles = new ArrayList<>();
	List <Alien> aliens = new ArrayList<>();
	Random random = new Random();
	int score = 0;

	public ObjectManager(Rocketship r) {
		rocket = r;
	}
	
	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	public void update() {
		
		for (Alien a: aliens) {
			a.update();
			if (a.y > LeagueInvaders.HEIGHT) {
				a.isActive = false;
			}
		}
		
		for (Projectile p: projectiles) {
			p.update();
			if (p.y > LeagueInvaders.HEIGHT) {
				p.isActive = false;
			}
		}
		
		checkCollision();
		purgeObjects();
		
	}
	
	public void draw(Graphics g) {
		
		rocket.draw(g);
		
		for (Alien a: aliens) {
			a.draw(g);
		}
		
		for (Projectile p: projectiles) {
			p.draw(g);
		}
	}
	
	public void purgeObjects() {
		
		for(int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive) {
				aliens.remove(i);
			}
		}	
		
		for(int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isActive) {
				projectiles.remove(i);
			}
		}
		
	}
	
	public void checkCollision() {
		
		for (Alien a: aliens) {
			
			for (Projectile p: projectiles) {
				if (a.collisionBox.intersects(p.collisionBox)) {
					a.isActive = false;
					p.isActive = false;
					score++;
				}
			}
			
			if ( a.collisionBox.intersects(rocket.collisionBox)) {
				a.isActive = false;
				rocket.isActive = false;
			}
			
		}
		

		
//		for(int i = 0; i < aliens.size(); i++) { 
//			for (int j = 0; j < projectiles.size(); j++) {
//				
//			}
//		}
	}
	
	public int getScore() {
		return score;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();
	}
}
