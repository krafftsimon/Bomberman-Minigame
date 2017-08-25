/**
 * Handler class. Handles GameObject's positioning, bounderies, rendering
 */
package com.wayne.bomberman.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import com.wayne.bomberman.framework.GameObject;
import com.wayne.bomberman.framework.MouseInput;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.STATE;
import com.wayne.bomberman.objects.*;

/**
 * Handler class
 */
public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	private GameObject tempObject;
	
	public static Bomb bomb = null;	
	public static Power power = null;
	
	/**
	 * this method updates the bomb explosion, powerup consumption and player invincibility
	 */
	public void tick(){
		for(int i=0;i<object.size(); i++){
			tempObject = object.get(i);
			tempObject.tick(object);
			if(tempObject.getId() == ObjectId.Player){
				if(tempObject.position.x == MouseInput.exitPosition.x&&
				   tempObject.position.y == MouseInput.exitPosition.y){
					game.score += game.timeLeft;
					System.out.println("exited");
					game.levelCompleted=true;
				}
				if(game.player.health <= 0){
					object.clear();
					game.gameLoop=1;
					game.State=STATE.GAMEOVER;
			}
		}
		// bomb is null when exploded		
		if(Bomb.exploded(bomb, object)){
			bomb=null;			
		}
		
		if(System.currentTimeMillis()-Player.tHit < 3000){
			Player.invincible = true;
		}
		else{
			Player.invincible = false;
		}
		
		if(Power.consumed(power, object)) {
			power=null;
		}
		}
		
	}
	
	/**
	 * renders the graphical image
	 * @param g graphics to render 
	 */
	public void render(Graphics g){
		for(int i=0;i<object.size(); i++){
			tempObject = object.get(i);
			tempObject.render(g);
		}
		if(bomb!=null){
		bomb.render(g);
		}
		if(power!=null){
			power.render(g);
		}
		g.setColor(Color.red);
		g.drawImage(game.tex.hud[0], 0, 476, null);//score hud
		g.setFont(new Font("TimesRoman", Font.PLAIN, 38));
		g.drawString(game.player.health.toString(), 650, 590);
	}
	
	/**
	 * adds the GameObject
	 * @param object
	 */
	public void addObject(GameObject object){
		
		this.object.add(object);
	}

	/**
	 * removes the GameObject
	 * @param object
	 */
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}