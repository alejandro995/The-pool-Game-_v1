package dev.com.tilegame.states;

import java.awt.Graphics;

import dev.com.tilegame.Game;
import dev.com.tilegame.Handler;

public abstract class States {
	
	
	
	private static States currentState = null;
	
	public static void setState(States state){
		currentState = state;
		
	}
	public static States getState(){
		return currentState;
	}
	
	
	
	
	//Class
	protected Handler handler;
	
	public States(Handler handler){
		this.handler = handler;
		 
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	

}
