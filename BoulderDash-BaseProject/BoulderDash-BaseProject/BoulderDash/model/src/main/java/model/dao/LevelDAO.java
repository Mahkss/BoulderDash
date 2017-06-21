package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Level;

public class LevelDAO extends AbstractDAO {

	 private static String sqlLevelById   = "{call GetLevel(?)}";
	
	 private static int tileTypeIdColumnIndex = 3;
	 private static int tileCoordXColumnIndex = 1;
	 private static int tileCoordYColumnIndex = 2;
	 
	 
	 public static Level getLevelById(final int lvl) throws SQLException {
	        final Level level = new Level();
	        final CallableStatement callStatement = prepareCall(sqlLevelById);
	        callStatement.setInt(1, lvl);
	        if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            
	           
	            boolean isResultLeft = result.first();
	            while (isResultLeft) {

	            	level.setTiles(result.getInt(tileTypeIdColumnIndex), result.getInt(tileCoordXColumnIndex) - 1, result.getInt(tileCoordYColumnIndex) - 1);
	            	isResultLeft = result.next();
	            	
	               
	                		//(result.getInt(idColumnIndex), result.getString(nameColumnIndex)));
	            }
	            
	            result.close();
	        }
	        return level;
	    }
}
