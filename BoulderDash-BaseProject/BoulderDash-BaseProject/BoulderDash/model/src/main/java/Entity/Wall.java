package Entity;
import model.Environment;

public class Wall extends Environment {

	
	public Wall(int x, int y) {
		
		super(x, y);
		setDestroyable(false);
		
	}

}
