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
	
	public static void SearchRockFall(World world){
	    int y = 0;
		int x= 0;
	    
	    
	    for (y = 0; y < 40; y++){
	        for (x = 0; x < 50; x++){
	            if ( world.getTile(y, x) == rockTile ||  world.getTile(y, x) == diamondTile){
	                WhereRockFall(world, y, x);
	            }
	        }
	    }
	}

	public static void WhereRockFall(World world, int y, int x){
	    if(world.getTile(y, x + 1) == emptyMudTile && world.getTile(y, x + 1) != rockTile && world.getTile(y, x + 1) != diamondTile){
	    	FallDown(world, x, y);
	    }
	    else if(world.getTile(y, x + 1) == rockTile || world.getTile(y, x + 1) == diamondTile){
	        if(world.getTile(y + 1, x) == emptyMudTile && world.getTile(y+1, x+1) == emptyMudTile){
	            FallRight(world, x, y);
	        }
	        else if(world.getTile(y - 1, x) == emptyMudTile && world.getTile(y-1, x+1) == emptyMudTile){
	            FallLeft(world, x, y);
	        }
	    }
	}
	public static void FallDown(World world, int x, int y){
		
		if (world.getTile(y, x) == rockTile){
			world.setTiles(3, y, x + 1);
			}
		if (world.getTile(y, x) == diamondTile){
			world.setTiles(4, y, x + 1);
			}
		world.setTiles(2, y, x);
	}

	public static void FallRight(World world, int x, int y){
		
		if (world.getTile(y, x) == rockTile){
			world.setTiles(3, y + 1, x);
			}
		if (world.getTile(y, x) == diamondTile){
			world.setTiles(4, y + 1, x);
			}
		world.setTiles(2, y, x);
	}
	    
	public static void FallLeft(World world, int x, int y){
		
		if (world.getTile(y, x) == rockTile){
			world.setTiles(3, y - 1, x);
		}
		if (world.getTile(y, x) == diamondTile){
			world.setTiles(4, y - 1, x);
			}
			
		world.setTiles(2, y, x);
	}
	
}
