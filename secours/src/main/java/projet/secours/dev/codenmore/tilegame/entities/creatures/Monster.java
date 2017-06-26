package projet.secours.dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;

import projet.secours.dev.codenmore.tilegame.Handler;


public class Monster extends Creature {

	
	public Monster(Handler handler, int x, int y, int width, int height) {
		super(handler, x, y, width, height);
		//Hitbox
				bounds.x = 1;
				bounds.y = 1;
				bounds.width = 60;
				bounds.height = 60;
	}

	
	public void tick() {
		// TODO Auto-generated method stub

	}


	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}
