/**
 * Position Class for locations of all GameObjects
 */
package com.wayne.bomberman.framework;

public class Position {
	public int x;
	public int y;
	
	/**
	 * Constructor for Position class
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public Position(int x, int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * getter for x Position Class
	 * @return x 
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * getter for y Position Class
	 * @return
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * setter for x Position Class
	 * @return x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * setter for y Position Class
	 * @return y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
		
		
		