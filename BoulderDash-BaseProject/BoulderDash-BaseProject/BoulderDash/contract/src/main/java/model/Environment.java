package model;

public abstract class Environment {

	private boolean destroyable;
	
	protected int x;
	protected int y;
	
	public Environment(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setDestroyable(boolean value) {
		this.destroyable = value;
	}
	
	public boolean getDestroyable() {
		return this.destroyable;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
}
