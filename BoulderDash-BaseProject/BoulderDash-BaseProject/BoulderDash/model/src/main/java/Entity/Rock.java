package Entity;
import model.Environment;


public class Rock extends Environment {

	
	private boolean falling;
	
	public Rock(int x, int y) {
		
		super(x, y);
		setDestroyable(false);
		this.falling = false;
	}
	
	public void fall() {
		this.setFalling(true);
	}
	
	public void killPlayer() {
		
	}
		
	public void setFalling(boolean value) {
		this.falling = value;
	}
	
}
