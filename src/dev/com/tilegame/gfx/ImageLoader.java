package dev.com.tilegame.gfx;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage (String path){ //static mean that you can access from anywhere. 
	try {
		return ImageIO.read(ImageLoader.class.getResource(path));
	} catch (Exception e) {
		e.printStackTrace();
		System.exit(1);
	}
		return null;
	}
}
