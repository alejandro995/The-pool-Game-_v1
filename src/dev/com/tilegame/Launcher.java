 package dev.com.tilegame;

import dev.com.tilegame.display.Display;

public class Launcher {
	
	public static void main(String[] args) {
		
		Game game = new Game("Title", 640, 360);
		game.start(); //This will allow to start the thread of the game
	}

}
