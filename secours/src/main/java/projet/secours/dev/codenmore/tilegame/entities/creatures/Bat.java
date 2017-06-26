package projet.secours.dev.codenmore.tilegame.entities.creatures;

import projet.secours.dev.codenmore.tilegame.Handler;

public class Bat extends Monster {

	public Bat(Handler handler, int x, int y, int width, int height) {
		super(handler, x, y, width, height);
		bounds.x = 1;
		bounds.y = 1;
		bounds.width = 60;
		bounds.height = 60;
	}

}
