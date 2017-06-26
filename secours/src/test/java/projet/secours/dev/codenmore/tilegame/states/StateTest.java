package projet.secours.dev.codenmore.tilegame.states;

import junit.framework.TestCase;

/**
 * Test class for State
 * 
 * @see State
 * 
 * @author Corentin
 *
 */
public class StateTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test the setState Methode
     * 
     * @author Corentin
     * 
     * @see setState
     */
    public void testSetState() {
        State.setState(null);
        assertNull(State.getState());
    }

    /**
     * Test the getState Methode
     * 
     * @author Corentin
     * 
     * @see getState
     */
    public void testGetState() {
        final State expected = null;
        
        assertEquals(expected, State.getState());
    }

}