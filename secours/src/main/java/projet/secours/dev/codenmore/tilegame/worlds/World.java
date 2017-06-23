package projet.secours.dev.codenmore.tilegame.worlds;

import java.awt.Graphics;
import java.sql.SQLException;

import BDDConnector.WorldDAO;
import projet.secours.dev.codenmore.tilegame.Handler;
import projet.secours.dev.codenmore.tilegame.entities.EntityManager;
import projet.secours.dev.codenmore.tilegame.entities.creatures.Player;
import projet.secours.dev.codenmore.tilegame.entities.statics.Diamond;
import projet.secours.dev.codenmore.tilegame.tiles.Tile;


public class World {
	
	private Handler handler;
	private static int width = 2560, height = 1984;
	private int spawnX, spawnY;
	private int[][] tiles;
	private static int WORLDID = 1;
	
	//Entities
	private EntityManager entityManager;
	
	
	public World(Handler handler) {
		
		entityManager = new EntityManager(handler, new Player(handler, spawnX, spawnY));
		entityManager.addEntity(new Diamond(handler, 128, 128));
		
		this.handler = handler;
		
		loadWorld(this);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		if (WORLDID == 1) {
			this.spawnX = 15;
			this.spawnY = 6;
		}
		if (WORLDID == 2) {
			this.spawnX = 35;
			this.spawnY = 5;
		}
		
		
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH +1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.emptyMudTile;
		
		Tile t = Tile.tiles[tiles[y][x]];
		if(t == null)
			return Tile.emptyMudTile;
		return t;
	}
	
	public void setTiles (int type, int x, int y) {
		this.tiles[x][y] = type;
	}
	
	public void loadWorld(World world){
		
		world.tiles = new int[40][31];
		try {
			WorldDAO.getLevelById(world, WORLDID);
		} catch (SQLException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}