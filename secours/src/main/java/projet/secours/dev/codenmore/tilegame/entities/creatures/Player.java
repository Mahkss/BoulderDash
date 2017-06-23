package projet.secours.dev.codenmore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projet.secours.dev.codenmore.tilegame.Handler;
import projet.secours.dev.codenmore.tilegame.gfx.Animation;
import projet.secours.dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {
	
	//Animation
	private Animation animDownLeft, animDownRight, animUpLeft, animUpRight, animLeft, animRight, animAfk;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//Hitbox
		bounds.x = 1;
		bounds.y = 1;
		bounds.width = 60;
		bounds.height = 60;
		
		//Animations
		animDownLeft = new Animation(250, Assets.player_down_left);
		animDownRight = new Animation(250, Assets.player_down_right);
		animUpLeft = new Animation(250, Assets.player_up_left);
		animUpRight = new Animation(250, Assets.player_up_right);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);
		animAfk = new Animation(250, Assets.player_afk);
	}

	public void tick() {
		//Animation
		animDownLeft.tick();
		animDownRight.tick();
		animUpLeft.tick();
		animUpRight.tick();
		animLeft.tick();
		animRight.tick();
		animAfk.tick();
		
		//Movement
		getInput();
		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//Animation
		
		
		//Hitbox
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		 if(xMove < 0){
			 return animLeft.getCurrentFrame();
		 }else if(xMove > 0){
			 return animRight.getCurrentFrame();
		 }else if(yMove < 0){
			 return animUpRight.getCurrentFrame();
		 }else if(yMove > 0){
			 return animDownLeft.getCurrentFrame();
		 }else{
			 return animAfk.getCurrentFrame();
		 }
	}
	
}
