package projet.secours.dev.codenmore.tilegame.entities.creatures;

import projet.secours.dev.codenmore.tilegame.Handler;
import projet.secours.dev.codenmore.tilegame.gfx.Animation;
import projet.secours.dev.codenmore.tilegame.gfx.Assets;

public class Butterfly extends Monster {

	private Animation animButt;
	
	public Butterfly(Handler handler, int x, int y, int width, int height) {
		super(handler, x, y, width, height);
		bounds.x = 1;
		bounds.y = 1;
		bounds.width = 60;
		bounds.height = 60;
		
		animButt = new Animation(250, Assets.Butt);
	}
	
	public void tick() {
		
	}
	
	
		
}
