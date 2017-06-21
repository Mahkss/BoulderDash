package model;



public class Level {

	private int tileWidth;
	private int tileHeight;
	private int[][] tiles;
	
	public Level() {
		this.tileWidth = 40;
		this.tileHeight = 31;
		this.tiles = new int[tileHeight][tileWidth];
	}
	
	public int getTileWidth() {
		return tileWidth;
	}
	
	public int getTileHeight() {
		return tileHeight;
	}
	
	public void setTiles(int type, int i, int j) {
		this.tiles[j][i] = type;
	}
	
	public int[][] getTiles() {
		return this.tiles;
	}
	
	public int getSingleTile(int x, int y) {
		return this.tiles[y][x];
	}
}
