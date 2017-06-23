package projet.secours.dev.codenmore.tilegame.tiles;

import java.awt.image.BufferedImage;

import projet.secours.dev.codenmore.tilegame.gfx.Assets;

public class DiamondTile extends Tile {

	public DiamondTile(int id) {
		super(Assets.diamond, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
