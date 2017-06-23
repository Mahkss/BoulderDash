package projet.secours;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import projet.secours.dev.codenmore.tilegame.Handler;
import projet.secours.dev.codenmore.tilegame.display.Display;
import projet.secours.dev.codenmore.tilegame.gfx.Assets;
import projet.secours.dev.codenmore.tilegame.gfx.GameCamera;
import projet.secours.dev.codenmore.tilegame.input.KeyManager;
import projet.secours.dev.codenmore.tilegame.states.GameState;
import projet.secours.dev.codenmore.tilegame.states.MenuState;
import projet.secours.dev.codenmore.tilegame.states.State;
import projet.secours.dev.codenmore.tilegame.worlds.World;

public class Game implements Runnable {
	
	/*ATTRIBUTS*/
	private Display display;
	public String title;
	private int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs; /*A bufferstrategy is a way for the computer to draw things to the screen, it tells to the computer how he should draw things to the screen and he uses buffer to do that a buffer is like a hidden computer screen which you can draw on*/
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	/*CONSTRUCTOR*/
	public Game(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
		
		
		
	}
	
	private void tick(){ /*This method is here to update the variables and the position of things on the screen*/
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){ /*This method is here to put all things on the screen with the variables and the position of things on the screen updated*/
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); /*A graphics object is like a paint brush, it allows us to draw things on the screen*/
		
		//Clear Screen
		g.clearRect(0, 0, width, height);
		
		//Draw Here!  fillRect=Rectangleplein  drawRect=Rectanglevide setColor(Color.nomdelacouleurenanglais)=couleuredurectangle tout ce qui se trouve en dessous de set color sera de la couleur indiqu�e jusqu'� ce qu'on la change, g.drawImage(ceminImage, 20, 20, null); afficher une image, g.drawImage(sheet.crop(0, 0, 16, 16), 5, 5, null); la fonction crop permet de d�couper les sprites
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){ /*We want to show things updated on the screen over and over so we create a loop*/
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
			tick();
			render();
			ticks++;
			delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start(); /*This will call the run method to start the thread*/
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join(); /*To stop the thread properly*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
