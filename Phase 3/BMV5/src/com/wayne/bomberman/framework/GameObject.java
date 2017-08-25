/**
 * GameObject class for the physiscal components of the GameObject
 * 
 * @since April 13, 2014
 */
package com.wayne.bomberman.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.wayne.bomberman.objects.Bomb;

/**
 * GameObject class
 * @author Wayne Tam
 *
 */
public abstract class GameObject {

	
	public Position position; 
	protected ObjectId id; 
	protected int velX=0, velY=0;
	/**
	 * Constructor for GameObject class takes a Position and ObjectId variable
	 * 
	 * @param p this is the position of the GameObject
	 * @param id this is the id of the GameObject
	 */
	public GameObject(Position p, ObjectId id){
		//constructor for object
		
		position = p;
		this.id = id;
	}
	/**
	 * 
	 * @param object
	 */
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract boolean isBombed(Bomb bomb);
	
	/**
	 * Getter for GameObject velocity x
	 * @return velocity x
	 */
	public float getVelX(){
		return velX;
	}
	
	/**
	 * Getter for the GameObject velocity Y
	 * @return velocity y
	 */
	public float getVelY(){
		return velY;
	}
	
	/**
	 * Setter for the GameObject velocity x
	 * @param velocity x
	 */
	public void setVelX(int velX){
		this.velX= velX;
	}
	
	/**
	 * Setter for the GameObject velocity y
	 * @param velocity y
	 */
	public void setVelY(int velY){
		this.velY= velY;
	}	

	/**
	 * getter for the GAmeObject id
	 * @return GameObject Id
	 */
	public  ObjectId getId(){
		return id;
	}
	/**
	 * GameObject upward moving method
	 * @param velocity 
	 */
	public void moveUp(int velocity) {
		this.velY = (-1)*velocity;
	}
	/**
	 * GameObject downward moving method
	 * @param velocity
	 */
	public void moveDown(int velocity) {
		this.velY = velocity;
	}
	
	/**
	 * GameObject leftward moving method
	 * @param velocity
	 */
	public void moveLeft(int velocity) {
		this.velX = (-1)*velocity;
	}
	
	/**
	 * GameObject Rightward moving method
	 * @param velocity
	 */
	public void moveRight(int velocity) {
		this.velX = velocity;
	}


	/**
	 * getter for GameObject position
	 * @return position
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * setter for GameObject position
	 * @param x x coordinate of GameObject
	 * @param y y coordinate of GameObject
	 */
	public void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}

}
