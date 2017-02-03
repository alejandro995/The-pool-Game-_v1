package dev.com.tilegame.entity.statics;

import java.awt.Graphics;

import dev.com.tilegame.Handler;
import dev.com.tilegame.gfx.Assets;
import dev.com.tilegame.tiles.Tile;

public class Box extends StaticEntity{

	public Box(Handler handler, float x, float y) {
		super(handler, x ,y, 32, 32 );
		
		bounds.x = 1;
		bounds.y = 1;
		bounds.width = this.height-2;
		bounds.height = this.width-2;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.box,(int)(x-handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width,height,null);
		
	}
	
	

}
