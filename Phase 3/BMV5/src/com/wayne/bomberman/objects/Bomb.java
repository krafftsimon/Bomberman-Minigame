/**
 * Bomb class for the GameObject bomb. It has its attributes, rendering and bounds.
 */
package com.wayne.bomberman.objects;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.wayne.bomberman.framework.GameObject;
import com.wayne.bomberman.framework.KeyInput;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.framework.Texture;
import com.wayne.bomberman.windows.Handler;
import com.wayne.bomberman.windows.game;

/**
 * Bomb class
 *
 */
public class Bomb extends GameObject{

	Texture tex = game.getInstance();

	private final static float defaultTimer = 3;
	public static float timer = defaultTimer;
	
	private static int defaultRange = 32;
	public static int range = defaultRange;
	
	static Random rand = new Random();
	static int dropChance;
	static int powerType;
	
	/**
	 * Constructor for the Bomb class
	 * @param p position of the bomb
	 * @param id bomb's id
	 */
	public Bomb(Position p, ObjectId id) {
		super(p, id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overrides the tick method
	 */
	@Override
	public void tick(LinkedList<GameObject> object) {
	}

	/**
	 * Overrides the render method
	 */
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.block[3], (int) position.x, (int) position.y, null);
	}

	/**
	 * Overrides the getBoounds method
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) position.x, (int)position.y, 32,32); 
	}
	
	/**
	 * this method test is used for testing and checking the x position of the bomb
	 */
	public void killTest(){
		int currentx = getPosition().getX();
		
	}
	
	/**
	 * This method checks if the bomb has exploded
	 * @param bomb the bomb used 
	 * @param object the object list
	 * @return boolean value of if bomb exploded
	 */
	public static boolean exploded(Bomb bomb,LinkedList<GameObject> object){
		if(bomb!=null&&System.currentTimeMillis()-KeyInput.tBomb>2000){
			
			for(int i=0;i<object.size();i++){
				if(object.get(i).isBombed(bomb)){
					if(object.get(i).getId() == ObjectId.Block){
						Position target = new Position(object.get(i).getPosition().getX(), object.get(i).getPosition().getY());
						//power up drop
						dropChance = rand.nextInt()%12;
						if(dropChance<10 && dropChance >=0){
							powerType=dropChance;
							Power.typeHolder = powerType;
							System.out.println(dropChance);
							Handler.power = new Power(target, powerType, ObjectId.Power);				
						}
						object.remove(i);
					}
					if(object.get(i).getId() == ObjectId.Enemy)object.remove(i);//removes enemy
					if(object.get(i).getId() == ObjectId.Player) game.player.health -=1;//loses health
				}
			}
		KeyInput.spaceEnabled=true;
		return true;
		}
		else if(bomb!=null){
			Rectangle rect1 = game.player.getBounds();
			Rectangle rect2 = bomb.getBounds();
			if(!rect1.intersects(rect2)){
				bomb.id=ObjectId.Block;
			}
			return false;
		}
		else
			return false;
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