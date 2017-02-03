package dev.com.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class Display {
	
	private JFrame frame; // private 
	private Canvas canvas; //This will allow to draw image to the window to add it to the frame. 
	
	
	
	//isntance for the windows
	private String title;
	private int width, height;
	
	
	public Display(String title, int width, int height){  //parameters in a constructor. 
		this.title = title;   //this to not confused the 
		this.width = width;
		this.height = height;
		
		createDisplay(); //This will help us organize the code that we have
		
		
	}
	
	private void createDisplay(){ // this is a method
			frame = new JFrame(title);
			frame.setSize(width, height);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			//Properties of the canvas to be initialized
			canvas = new Canvas();
			canvas.setPreferredSize(new Dimension(width, height)); //Anonymous class remember you only can extend and implement only one class and interface from it.  
			canvas.setMaximumSize(new Dimension(width, height)); // make sure the dimension is the same always
			canvas.setMinimumSize(new Dimension(width, height));
			canvas.setFocusable(false);
			
			frame.add(canvas);
			frame.pack();
			
	}
	
	public Canvas getCanvas(){
		 return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
