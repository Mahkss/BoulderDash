package projet.secours.dev.codenmore.tilegame.tiles;

import projet.secours.dev.codenmore.tilegame.gfx.Assets;
import projet.secours.dev.codenmore.tilegame.worlds.World;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public void SearchRockFall(World world){
	    int y = 0;
		int x= 0;
	    
	    
	    for (y = 0; y <= 30; y++){
	        for (x = 0; x <= 39; x++){
	            if ( world.getTile(y, x) == rockTile ||  world.getTile(y, x) == diamondTile){
	                WhereRockFall(world, y, x);
	            }
	        }
	        x = 0;
	    }
	}

	public void WhereRockFall(World world, int y, int x){
	    if(world.getTile(y + 1, x) == emptyMudTile){
	        FallDown(world, x, y);
	    }
	    else if(world.getTile(y+1, x) == wallTile || world.getTile(y+1, x) == rockTile || world.getTile(y+1, x) == diamondTile){
	        if(world.getTile(y, x+1) == emptyMudTile && world.getTile(y+1, x+1) == emptyMudTile){
	            FallRight(world, x, y);
	        }
	        else if(world.getTile(y, x-1) == emptyMudTile && world.getTile(y+1, x-1) == emptyMudTile){
	            FallLeft(world, x, y);
	        }
	    }
	}
	public void FallDown(World world, int x, int y){
		
		if (world.getTile(y, x) == rockTile){
			world.setTiles(3, y + 1, x);
			}
		if (world.getTile(y, x) == diamondTile){
			world.setTiles(4, y + 1, x);
			}
		world.setTiles(2, y, x);
	}

	public void FallRight(World world, int x, int y){
		
		if (world.getTile(y, x) == rockTile){
			world.setTiles(3, y, x + 1);
			}
		if (world.getTile(y, x) == diamondTile){
			world.setTiles(4, y, x + 1);
			}
		world.setTiles(2, y, x);
	}
	    
	public void FallLeft(World world, int x, int y){
		
		if (world.getTile(y, x) == rockTile){
			world.setTiles(3, y, x - 1);
		}
		if (world.getTile(y, x) == diamondTile){
			world.setTiles(4, y, x - 1);
			}
			
		world.setTiles(2, y, x);
	}
	
}
