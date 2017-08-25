/**
 * SpriteSheet Class for images
 */
package com.wayne.bomberman.framework;

import java.awt.image.BufferedImage;

/**
 * SpriteSheet Class
 * @author 
 *
 */
public class SpriteSheet {

	private BufferedImage image;
	
	/**
	 *Constructor SpriteSheet Class
	 * @param image this is the image 
	 */
	public SpriteSheet(BufferedImage image){
		this.image=image;
	}
	
	/**
	 * This method takes the image and returns it
	 * @param col column position
	 * @param row row position
	 * @param width width of image to be taken
	 * @param height height of image to be taken
	 * @return
	 */
	public BufferedImage grabImage(int col, int row, int width, int height){
		BufferedImage img = image.getSubimage((col*width)- width, (row*height)-height, width, height);
		return img;
	}
}
