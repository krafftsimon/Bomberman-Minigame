/**
 * Moveable Class for moving objects
 */
package com.wayne.bomberman.framework;

/**
 * 
 * @author Simon Krafft Alistar Russell
 *
 */
public interface Moveable {
	
	void moveUp(int velocity);
	void moveDown(int velocity);
	void moveLeft(int velocity);
	void moveRight(int velocity);
	
}