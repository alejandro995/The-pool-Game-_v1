package dev.com.tilegame.states;

import java.awt.Graphics;

import dev.com.tilegame.Game;
import dev.com.tilegame.Handler;
import dev.com.tilegame.entity.creatures.player.Player;
import dev.com.tilegame.gfx.Assets;
import dev.com.tilegame.tiles.Tile;
import dev.com.tilegame.world.World;

public class GameState extends States{
	
	
	private World world;

	public GameState(Handler handler){
		super(handler);
		world = new World(handler,"res/World/world1.txt");
		handler.setWorld(world);
		
		
	
		
	}

	public void tick() {
		world.tick();
		
		
		
	}


	public void render(Graphics g) {
	world.render(g);	
	
		
	}
	

}
