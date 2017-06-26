package projet.secours.dev.codenmore.tilegame.worlds;

import junit.framework.TestCase;

/**
 * Test class for World
 * 
 * @see World
 * 
 * @author Corentin
 *
 */
public class WorldTest extends TestCase {


    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test the getWidth Methode
     * 
     * @author Corentin
     * 
     * @see getWidth
     */
    public void testGetWidth() {
        final int expected = 2560;
    
        final World world = new World(null);
        
        assertEquals(expected, world.getWidth());
        
    }
    
    /**
     * Test the getHeight Methode
     * 
     * @author Corentin
     * 
     * @see getHeight
     */
    public void testGetHeight() {
        final int expected = 1984;
        
        final World world = new World(null);
        
        assertEquals(expected, world.getHeight());
    }

}