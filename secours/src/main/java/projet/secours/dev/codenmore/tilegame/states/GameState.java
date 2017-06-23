package projet.secours.dev.codenmore.tilegame.states;

import java.awt.Graphics;

import projet.secours.dev.codenmore.tilegame.Handler;
import projet.secours.dev.codenmore.tilegame.worlds.World;

public class GameState extends State{
	
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler);
		handler.setWorld(world);
	}

	public void tick() {
		world.tick();
	}

	public void render(Graphics g) {
		world.render(g);
	}
	
}
