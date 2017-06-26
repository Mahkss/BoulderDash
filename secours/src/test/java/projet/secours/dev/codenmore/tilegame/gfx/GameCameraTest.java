package projet.secours.dev.codenmore.tilegame.gfx;

import junit.framework.TestCase;

/**
 * Test Class for GameCamera
 * 
 * @see GameCamera
 * 
 * @author Corentin
 *
 *Don't know why her didn't work
 */
public class GameCameraTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test the checkBlankSpace Methode
     * 
     * @author Corentin
     * 
     * @see checkBlankSpace
     */
    public void testCheckBlankSpace() {
        final float xOffset = -2;
        final float yOffset = 8;
        final float expected = 0;
        final GameCamera gameCamera = new GameCamera(null, xOffset, yOffset);    
        gameCamera.checkBlankSpace();
        
        assertEquals(expected, gameCamera.getxOffset());
    }
    
    /**
     * Test the getxOffset Methode
     * 
     * @author Corentin
     * 
     * @see getxOffset
     */
    public void testGetxOffset() {
        final int expected = 5;
        final GameCamera gameCamera = new GameCamera(null, 5, 8);
        
        assertEquals(expected, gameCamera.getxOffset());
    }
    
    /**
     * Test the getyOffset Methode
     * 
     * @author Corentin
     * 
     * @see getyOffset
     */
    public void testGetyOffset() {
        final int expected = 2;
        final GameCamera gameCamera = new GameCamera(null, 6, 2);
        
        assertEquals(expected, gameCamera.getyOffset());
    }

}