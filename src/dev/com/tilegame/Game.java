package dev.com.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.nio.channels.AsynchronousServerSocketChannel;

import dev.com.tilegame.display.Display;
import dev.com.tilegame.gfx.Assets;
import dev.com.tilegame.gfx.GameCamera;
import dev.com.tilegame.gfx.ImageLoader;
import dev.com.tilegame.gfx.SpriteSheet;
import dev.com.tilegame.input.KeyManager;
import dev.com.tilegame.states.GameState;
import dev.com.tilegame.states.MenuState;
import dev.com.tilegame.states.States;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	// thread is a mini program going to run with in the program.

	private boolean running = false; // this will be the variable the controls
										// the game loop, we take it out as a
										// variable to have more control over
										// the loop.
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;
	
	
	//States
	private States gameState, menuState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;

	// temp code
	// private BufferedImage testImage;
	// private SpriteSheet sheet;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager(); 
	}

	private void init() {
		display = new Display(title, width, height); // to make sure is ruuning
														// in the new thraed
														// that we create.
		// testImage = ImageLoader.loadImage("/textures/sheet.png");
		// sheet = new SpriteSheet(testImage);
		display.getFrame().addKeyListener(keyManager);
		
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler,0, 0);
		
		
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler); 
		States.setState(gameState);

	}

	//int x = 0;

	private void tick() {// this updates all the variables of the game to be
							// render if these change affect the graphics
							// itself.
		//x += 1;
		keyManager.tick();
		
		if(States.getState() != null){
			States.getState().tick();
		}
		
	}

	private void render() { // It renders the graphics of the game itself.
		bs = display.getCanvas().getBufferStrategy(); // Its a way to let the
														// computer how to draw
														// thing to the screen
		if (bs == null) {// a Buffer is a hidden computer screen behind your
							// computer
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear the screen.
		g.clearRect(0, 0, width, height);
		// Draw Here!
		// coordinates x and y it will be important to know
		// g.setColor(Color.CYAN); //After you set up the color all the grafics
		// will have all that color
		// g.fillRect(10, 50, 50, 70);
		// g.setColor(Color.MAGENTA);
		// g.fillRect(0, 0, 10, 10);
		// g.drawImage(sheet.crop(0, 40, 30, 30), 5, 5, null);
		// g.drawImage(sheet.crop(30, 40, 30, 30), 15, 15, null);

		// g.fillRect(0, 0, width, height); rectangule
		
		if(States.getState() != null){
			States.getState().render(g);
		}

		//g.drawImage(Assets.player, x, 10, null);

		// End drawing!

		bs.show();
		g.dispose();
	}

	public void run() { // you always have to implement run when you implement
						// runnable class
		init();

		int fps = 60; //Frame per seconds ticks is the amount of time we want  to call every second
		double TimePerTick = 1000000000 / fps; // fps measured in nanoseconds this is the maximum of time we have to execute the tick and render methods
		double delta = 0; //The amount of time that we have before we call the tick and render method again.
		long now; //This is the time when the loop start the currently time of our computer. 
		long lastTime = System.nanoTime(); // The actual time of the computer in
											// nanoseconds

		// Timer for the fPS
		long timer = 0;
		int ticks = 0;

		while (running) { // while the variable of running is true the game loop
							// it will keep going doing the process over and
							// over again.
			now = System.nanoTime();
			delta += (now - lastTime) / TimePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer>=1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				 ticks =0;
				 timer =0; 
				 
			}
		}

		stop();

		// Game loop!!!! to know how it work -> first its updates all the
		// variables, position of the object and the rest of variables need for
		// the game to
		// be playable after that -> it renders all that information of the
		// variables to the graphics
	}

	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}

	
	public synchronized void start() { // Basically you use only when are you
										// working with threads // this will be
										// the main method that starts the game
										// to begin with
		if (running) // what if our game is already running // we dont ant to
						// reinitialize our thread will harm the program
			return;

		running = true; // This will mean that the game has started a we need to
						// do the game loop to update all the information and
						// render all the images.

		thread = new Thread(this); // We put this because we want the this class
									// (Game) to be run in the thread.
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;

		running = false; // this will be the opposite of the start the loop, we
							// want to stop the loop.

		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}


}
