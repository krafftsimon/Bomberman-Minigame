/**
 * ExitDoor class for door exit. It has its bounds, rendering and attributes.
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
 * ExitDoor class
 */
public class ExitDoor extends GameObject {
	
	Texture tex = game.getInstance();
	
	/**
	 * Constructor for the ExitDoor class
	 * @param p position of the object
	 * @param id enemy's id
	 */
	public ExitDoor(Position p, ObjectId id) {
		super(p, id);
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
		g.drawImage(tex.exitDoor[0], (int) position.x, (int) position.y, null);
	}

	/**
	 * Overrides the getBounds method
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) position.x, (int)position.y, 32,32); 
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