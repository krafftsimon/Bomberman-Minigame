/**
 * BufferedImageLoader class. this class gets the image path and loads it 
 */
package com.wayne.bomberman.windows;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * BufferedImageLoader class
 */
public class BufferedImageLoader {

	private BufferedImage image;
	/**
	 * this method gets the image path
	 * @param path path of image
	 * @return image
	 */
	public BufferedImage loadImage(String path){
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
