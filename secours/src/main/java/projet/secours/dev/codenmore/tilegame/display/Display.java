package projet.secours.dev.codenmore.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	/*ATTRIBUTS*/
	private JFrame frame;
	private Canvas canvas; /*Allows us to draw graphics to a canvas*/
	
	private String title;
	private int width, height;
	
	/*CONSTRUCTOR*/
	public Display(String title, int width,  int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*To make sure that your window close is done properly when you press the exit button if you haven't this line of code when you will exit the game it will run in the background*/
		frame.setResizable(false); /*We don't want the user to be able to resize the window*/
		frame.setLocationRelativeTo(null); /*To pop the window in the center of the screen*/
		frame.setVisible(true); /*To set the window visible*/
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height)); /*To set the size*/
		canvas.setMaximumSize(new Dimension(width, height)); /*To make sure that the size will still be the same*/
		canvas.setMinimumSize(new Dimension(width, height)); /*To make sure that the size will still be the same*/
		canvas.setFocusable(false); /*It's make the JFrame become the only thing to focud*/
		
		frame.add(canvas); /*To add the canvas to the window*/
		frame.pack(); /*To resize the window to be able to see the entire canvas*/
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public void End(){
		frame.dispose();
	}
}
