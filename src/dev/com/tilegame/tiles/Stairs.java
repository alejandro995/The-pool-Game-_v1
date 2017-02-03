package dev.com.tilegame.tiles;

import dev.com.tilegame.gfx.Assets;

public class Stairs extends Tile{
	
	public Stairs (int id){
		super(Assets.stairs1, id);
		switch (id) {
		case 8: this.texture = Assets.stairs1; break;
		case 9: this.texture = Assets.stairs2; break;
		case 10: this.texture = Assets.stairs3; break;
		case 11: this.texture = Assets.stairs4; break;
		default: break;		
	}
	
	}
}
