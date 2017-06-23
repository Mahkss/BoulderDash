package BDDConnector;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projet.secours.dev.codenmore.tilegame.worlds.World;

public class WorldDAO extends AbstractDAO {
	 private static String sqlLevelById   = "{call GetLevel(?)}";
		
	 private static int tileCoordXColumnIndex = 1;
	 private static int tileCoordYColumnIndex = 2;
	 private static int tileTypeIdColumnIndex = 3;
	 
	 
	 public static World getLevelById(World world, final int lvl) throws SQLException {
		 
	        final CallableStatement callStatement = prepareCall(sqlLevelById);
	        callStatement.setInt(1, lvl);
	        
	        if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            
	           
	            boolean isResultLeft = result.first();
	            while (isResultLeft) {

	            	world.setTiles(result.getInt(tileTypeIdColumnIndex), result.getInt(tileCoordXColumnIndex) - 1, result.getInt(tileCoordYColumnIndex) - 1);
	            	isResultLeft = result.next();
	            	
	               
	                		//(result.getInt(idColumnIndex), result.getString(nameColumnIndex)));
	            }
	            
	            result.close();
	        }
	        return world;
	    }
	 
	 
	 
	 
}
