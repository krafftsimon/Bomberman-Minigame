/**
 * Animations class for Player movement animations
 * 
 * @since April 13, 2014
 */
package com.wayne.bomberman.framework;

/**
 * Animations class.
 * 
 * @author Wayne Tam
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animations {

	private int speed;
	private int frames;
	
	private int index = 0;
	private int count = 0;
	
	private BufferedImage[] images;
	private BufferedImage currentImg;
	
	/**
	 * Constructor for Animations class takes speed and BufferedImage args.
	 * 
	 * 
	 * @param speed rate at which the frame changes
	 * @param args the images in a series of frame
	 */
	public Animations(int speed, BufferedImage...args){
		
		this.speed = speed;
		images = new BufferedImage[args.length];
		
		for(int i=0; i<args.length;i++){
			
			images[i] = args[i];
		}
		frames  = args.length;
	}
	
	/**
	 * Run method for the animation class.
	 * 
	 * 	calls nextFrame
	 *            
	 */
	public void runAnimation(){
		
		index++;
		if(index > speed){
			index=0;
			nextFrame();
		}
	}
	
	/**
	 * nextFrame for the animations
	 * this method changes the image 
	 * 	 
	 *            
	 */
	public void nextFrame(){
		
		for(int i=0; i<frames;i++){
			if(count==i)
				currentImg = images[i];
		}
		count++;
		if(count > frames)
			count = 0;
	}
	
	/**
	 * This method draws the image
	 * 
	 * @param g this is the graphics variable
	 * @param x position on x coord
	 * @param y position on y coord
	 * @param scaleX weight
	 * @param scaleY height
	 */
	public void drawAnimation(Graphics g, int x, int y,int scaleX, int scaleY){
		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
	}
	
	
}
