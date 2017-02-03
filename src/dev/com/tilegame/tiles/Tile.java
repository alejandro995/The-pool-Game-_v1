package dev.com.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile BathfloorTile = new Bathfloor(0);
	public static Tile Bluefloor = new Bluefloor(1);
	public static Tile Stonefloor = new Stonefloor(2);
	public static Tile CarpetTile = new Carpet(3);
	public static Tile Stonefloor2 = new Stonefloor(4);
	public static Tile Greyfloor1 = new Greyfloor(5);
	public static Tile Greyfloor2 = new Greyfloor(6);
	public static Tile Greyfloor3 = new Greyfloor(7);
	public static Tile StairTile1 = new Greyfloor(8);
	public static Tile StairTile2 = new Greyfloor(9);
	public static Tile StairTile3 = new Greyfloor(10);
	public static Tile StairTile4 = new Greyfloor(11);
	
	
	
	
	
	//Class
	
	public static final int TILEWIDTH = 70, TILEHEIGHT=70;
	
	 protected BufferedImage texture;
	 protected final int id;

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		
		tiles[id] = this;
		
		
	}
	
	public void tick(){
		
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y,TILEWIDTH, TILEHEIGHT, null);
		
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
