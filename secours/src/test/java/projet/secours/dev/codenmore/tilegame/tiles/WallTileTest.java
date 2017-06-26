package projet.secours.dev.codenmore.tilegame.tiles;

import java.awt.image.BufferedImage;

import junit.framework.TestCase;

/**
 * Test class for WallTile
 * 
 * @see WallTile
 * 
 * @author Corentin
 *
 */
public class WallTileTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test the isSolid Methode
     * 
     * @author Corentin
     * 
     * @see isSolid
     */
    public void testIsSolid() {
        final BufferedImage Wall = null;
        
        final boolean expected = false;
        final Tile tile = new Tile(Wall, 0); 
        
        assertEquals(expected, tile.isSolid()); 
    }

    /**
     * Test the getId Methode
     * 
     * @author Corentin
     * 
     * @see getId
     */
    public void testGetId() {
        final BufferedImage Wall = null;
        
        final int expected = 0;
        final Tile tile = new Tile(Wall, 0); 
        
        assertEquals(expected, tile.getId()); 
    }

}