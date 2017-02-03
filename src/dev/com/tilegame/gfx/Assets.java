package dev.com.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int WIDTH1 = 70, HEIGHT1= 143;
	public static final int WIDTH2 = 70, HEIGHT2= 70;
	public static final int ANIMATION_WIDTH = 96, ANIMATION_HEIGHT2= 144;
	public static final int BOX_WIDTH=32 , BOX_HEIGHT=32;
	
	public static BufferedImage player, player1, box;
	public static BufferedImage[] player_up,player_left,player_down,player_right;
	
	
	public static BufferedImage bathfloor,bluefloor, stonefloor, carpet, stonefloor2, greyfloor1,greyfloor2,greyfloor3,stairs1, stairs2, stairs3,stairs4; 

	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet sheetBackgroung = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
		SpriteSheet animationsheet = new SpriteSheet(ImageLoader.loadImage("/textures/animation.png"));
		SpriteSheet boxes = new SpriteSheet(ImageLoader.loadImage("/textures/boxes.png"));
		
		
		/*Animation - Frames!! */
		
		player_up = new BufferedImage[3];
		player_up[0] = animationsheet.crop(ANIMATION_WIDTH*2, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_up[1] = animationsheet.crop(ANIMATION_WIDTH*2, ANIMATION_HEIGHT2, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_up[2] = animationsheet.crop(ANIMATION_WIDTH*2, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);

		
		player_left = new BufferedImage[3];
		player_left[0] = animationsheet.crop(ANIMATION_WIDTH*3, ANIMATION_HEIGHT2, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_left[1] = animationsheet.crop(ANIMATION_WIDTH*4, ANIMATION_HEIGHT2, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_left[2] = animationsheet.crop(ANIMATION_WIDTH*5, ANIMATION_HEIGHT2, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
	
		
		player_down = new BufferedImage[3];
		player_down[0] = animationsheet.crop(ANIMATION_WIDTH, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_down[1] = animationsheet.crop(ANIMATION_WIDTH, ANIMATION_HEIGHT2, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_down[2] = animationsheet.crop(ANIMATION_WIDTH, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);

		
		player_right = new BufferedImage[3];
		player_right[0] = animationsheet.crop(ANIMATION_WIDTH*3, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_right[1] = animationsheet.crop(ANIMATION_WIDTH*4, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player_right[2] = animationsheet.crop(ANIMATION_WIDTH*5, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);

		
		
		box = boxes.crop(0, 0, BOX_WIDTH, BOX_HEIGHT);
		
		player = animationsheet.crop(0, 0, ANIMATION_WIDTH, ANIMATION_HEIGHT2);
		player1 = sheet.crop(WIDTH1, 0,WIDTH1, HEIGHT1);
		
		
	
		
		bathfloor = sheetBackgroung.crop(0, 0, WIDTH2, WIDTH2);
		
		bluefloor = sheetBackgroung.crop(WIDTH2, 0, WIDTH2, WIDTH2);
		
		stonefloor = sheetBackgroung.crop(WIDTH2*2, 0, WIDTH2, WIDTH2);
		
		carpet = sheetBackgroung.crop(WIDTH2*3, 0, WIDTH2, WIDTH2);
		
		stonefloor2 = sheetBackgroung.crop(0, WIDTH2, WIDTH2, WIDTH2);
		
		greyfloor1 = sheetBackgroung.crop(WIDTH2, WIDTH2, WIDTH2, WIDTH2);
		
		greyfloor2 = sheetBackgroung.crop(WIDTH2*2, WIDTH2, WIDTH2, WIDTH2);
		
		greyfloor3 = sheetBackgroung.crop(WIDTH2*3, WIDTH2, WIDTH2, WIDTH2);
		
		stairs1 = sheetBackgroung.crop(0, WIDTH2*2, WIDTH2, WIDTH2);
		
		stairs2 = sheetBackgroung.crop(WIDTH2, WIDTH2*2, WIDTH2, WIDTH2);
		
		stairs3 = sheetBackgroung.crop(WIDTH2*2, WIDTH2*2, WIDTH2, WIDTH2);
		
		stairs4 = sheetBackgroung.crop(WIDTH2*3, WIDTH2*2, WIDTH2, WIDTH2);
		
		
	}
	
}
