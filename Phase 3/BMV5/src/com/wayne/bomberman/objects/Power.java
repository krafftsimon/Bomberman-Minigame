/**
 * Power class for the GameObject power. This class gives the selected power up when its methods are called
 * and has its attributes, rendering and bounds
 */
package com.wayne.bomberman.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.wayne.bomberman.framework.GameObject;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.framework.Texture;
import com.wayne.bomberman.windows.game;

/**
 *Power Class
 */
public class Power extends GameObject{

	Texture tex = game.getInstance();
	int type;
	int powerDouble = 0;
	int powerSpeed = 1;
	int powerHealth = 2;
	int powerRange = 3;
	static int typeHolder;
	
	/**
	 * constructor for the Power class
	 * @param p position of power
	 * @param type the type of power
	 * @param id the id of the GameObject
	 */
	public Power(Position p, int type, ObjectId id) {
		super(p, id);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overrides the tick method
	 */
	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overrides the render method
	 */
	@Override
	public void render(Graphics g) {
		if(type==0)
			g.drawImage(tex.power[0], (int) position.x, (int) position.y, null);
		if(type==1)
			g.drawImage(tex.power[1], (int) position.x, (int) position.y, null);
		if(type==2)
			g.drawImage(tex.power[2], (int) position.x, (int) position.y, null);
		if(type==3)
			g.drawImage(tex.power[3], (int) position.x, (int) position.y, null);
		
	}

	/**
	 * Overrides the getBounds method
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(position.x, position.y, 32,32); 
	}

	/**
	 * this method increases player speed
	 */
	public static void speedUp(){
		Player.speed=Player.speed*2;
	}
	
	/**
	 * this method doubles the score 
	 */
	public static void doubleUp(){
		game.score=game.score*2;
	}
	
	/**
	 * this method adds 1 to the player health
	 */
	public static void healthUp(){
		Player.health++;
	}
	
	/**
	 * this method increases bomb range 
	 */
	public static void rangeUp(){
		Bomb.range+=32;
	}
	
	/**
	 * this methods checks if power up is consumed
	 * @param power
	 * @param object
	 * @return the boolean state of consumed
	 */
	public static boolean consumed(Power power, LinkedList<GameObject> object) {
		boolean consumed = false;
		if(power!=null) {
			Rectangle rect1=game.player.getBounds();
			Rectangle rect2=power.getBounds();
			
			if(rect1.intersects(rect2)) {
				consumed = true;
				selectPower(typeHolder);
			} else {
				consumed = false;
			}
		}
		return consumed;
	}
	
	/**
	 * this method calls the associated power up selected
	 * @param type the power up number
	 */
	public static void selectPower(int type){
		if(Power.typeHolder == 0)
			Power.healthUp();
		if(Power.typeHolder == 1)
			Power.doubleUp();
		if(Power.typeHolder == 2)
			Power.rangeUp();
		if(Power.typeHolder == 3)
			Power.speedUp();
	}

	/**
	 * Overrides the isBombed method
	 */
	@Override
	public boolean isBombed(Bomb bomb) {
		// TODO Auto-generated method stub
		return false;
	}
}
