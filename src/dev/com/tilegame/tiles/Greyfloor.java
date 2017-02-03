package dev.com.tilegame.tiles;

import java.awt.image.BufferedImage;

import dev.com.tilegame.gfx.Assets;

public class Greyfloor extends Tile{
	
	

	public Greyfloor(int id) {
		super(Assets.stairs1, id);
		switch (id){
		case 5: this.texture = Assets.stairs1; break;
		case 6: this.texture = Assets.stairs2; break;
		case 7: this.texture = Assets.stairs3; break;
		default : this.texture = Assets.stairs2;
		}
		
	}

}
