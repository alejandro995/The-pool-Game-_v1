package dev.com.tilegame.entity.creatures.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.com.tilegame.Game;
import dev.com.tilegame.Handler;
import dev.com.tilegame.entity.creatures.Creature;
import dev.com.tilegame.gfx.Animation;
import dev.com.tilegame.gfx.Assets;

public class Player extends Creature {
	
	private Animation animationUp,animationLeft,animationDown,animationRight;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 48, 72);
		
		bounds.x = 9;
		bounds.y = 42;
		bounds.width = 32;
		bounds.height = 32;
		//
		animationUp = new Animation(200, Assets.player_up);
		animationLeft = new Animation(200, Assets.player_left);
		animationDown = new Animation(200, Assets.player_down);
		animationRight = new Animation(200, Assets.player_right);
		
		
	}

	
	public void tick() {
		//
		animationUp.tick();
		animationLeft.tick();
		animationDown.tick();
		animationRight.tick();
		//
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove=0;
		yMove=0;
		
		if(handler.getKeyManager().up)
			yMove= -speed;
		if(handler.getKeyManager().down)
			yMove=  speed;
		if(handler.getKeyManager().left)
			xMove= -speed;
		if(handler.getKeyManager().right)
			xMove= speed;
	}

	
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x- handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.green);
		/*g.fillRect((int)(x+ bounds.x - handler.getGameCamera().getxOffset()), 
				(int)(y+ bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);*/
		
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove<0 ) {//left
			return animationLeft.getCurrentFrame();
		}else if (xMove>0){
			return animationRight.getCurrentFrame();
		} else if (yMove< 0){
			return animationUp.getCurrentFrame();
		} else if (yMove> 0){
			return animationDown.getCurrentFrame();
			
		}else{
			return Assets.player;
		}
	}
	
	

}
