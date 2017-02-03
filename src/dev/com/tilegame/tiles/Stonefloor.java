package dev.com.tilegame.tiles;

import dev.com.tilegame.gfx.Assets;

public class Stonefloor extends Tile{
	
	public Stonefloor(int id){
		super(Assets.stonefloor, id);
		switch (id){
		case 2: this.texture = Assets.stonefloor; break;
		case 3: this.texture = Assets.stonefloor2; break;
		default: this.texture = Assets.stonefloor;
		}
	}

}
