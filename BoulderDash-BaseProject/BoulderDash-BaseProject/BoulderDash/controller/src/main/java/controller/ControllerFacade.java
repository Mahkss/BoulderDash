package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;

import model.IModel;
import view.IView;
import model.Level;
/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements KeyListener, IController {
	
	//ATTRIBUTS
	private boolean[] keys;
	public boolean up, down, left, right;

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        keys = new boolean[256];
    }
    
    //To update the value of the key pressed
	public void tickKeys(){
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
	}
	
    //KeyListener
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed!");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
    	
        //this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        // this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        /*  final List<Example> examples = this.getModel().getAllExamples();
         final StringBuilder message = new StringBuilder();
         // a.append(" bar);
         for (final Example example : examples) {
             message.append(example);
             message.append('\n');
         }
         this.getView().displayMessage(message.toString()); */
     	
         final Level level = this.getModel().getLevelById(1);
       
         // a.append(" bar);
        for (int i = 0; i < level.getTileHeight(); i++) {
             for (int j = 0; j < level.getTileWidth(); j++ ) {
             	System.out.print(level.getSingleTile(j,i));
             }
             System.out.println("");
         }
         
         
     }
    	
    

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

}
