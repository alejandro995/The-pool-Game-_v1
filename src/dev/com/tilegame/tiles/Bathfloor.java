package dev.com.tilegame.tiles;

import java.awt.image.BufferedImage;

import dev.com.tilegame.gfx.Assets;

public class Bathfloor extends Tile{

	public Bathfloor(int id) {
		super(Assets.bathfloor, id);
		// TODO Auto-generated constructor stub
	}
	
	//Overriden method
	public boolean isSolid(){
		return true;
	}

}
