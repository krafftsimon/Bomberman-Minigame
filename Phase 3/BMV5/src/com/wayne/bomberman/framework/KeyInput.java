/**
 * KeyInput Class for all keyboard functions
 *
 */
package com.wayne.bomberman.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import com.wayne.bomberman.menuwindows.GameOver;
import com.wayne.bomberman.objects.Bomb;
import com.wayne.bomberman.objects.Player;
import com.wayne.bomberman.windows.Handler;
import com.wayne.bomberman.windows.game;
/**
 * KeyInput Class
 * @author Wayne Tam, Qianyu Liu, Heng Kang
 *
 */
public class KeyInput extends KeyAdapter {

	long time1;
	public static long tBomb;
	Handler handler;
	Timer timer;//bomb timer
	static int inputCount =0;//counter for name input on GameOver
	public static boolean spaceEnabled = true;// for Space pressing 
	
	/**
	 * Constructor for KeyInput Class
	 * @param handler GameObject Handler
	 */
	public KeyInput(Handler handler){
		this.handler = handler;
	}

	/**
	 * KeyPressed Methods
	 */
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		// if escape key is pressed
		//this condition has no game.state conditions
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
		// game state keys
		if(game.State==STATE.GAME)
		{
			//the following keys are only for the player GameObject
			for(int i=0; i<handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId()== ObjectId.Player)
				{
					//movements
					if(Player.speed>8) Player.speed=8;//max speed is 8, greater than 8 produces bug/glitch of ending outside of game grid
					if(key == KeyEvent.VK_D) tempObject.moveRight(Player.speed);
					if(key == KeyEvent.VK_A) tempObject.moveLeft(Player.speed);
					if(key == KeyEvent.VK_W) tempObject.moveUp(Player.speed);
					if(key == KeyEvent.VK_S) tempObject.moveDown(Player.speed);
					
					//bomb drop
					if(key==KeyEvent.VK_SPACE && spaceEnabled)
					{
						Position target = new Position(tempObject.getPosition().getX(), tempObject.getPosition().getY());
						Handler.bomb = new Bomb(target, ObjectId.Bomb);
						tBomb = System.currentTimeMillis();
						
						spaceEnabled = false;
						
					}
					//for pausing the game
					if(key==KeyEvent.VK_P){
						game.State = STATE.PAUSE;
					}
				}
			}
		}
		//GameCover keys
		if(game.State==STATE.GAMECOVER)
		{
			if(key == KeyEvent.VK_SPACE){
				game.State = STATE.MENU;
			}
		}
	
		//GameOver keys
		if(game.State==STATE.GAMEOVER)
		{
			//keys between A-Z
			if(key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z){
				Object nameInput = new Integer(key);
				String keyString = KeyEvent.getKeyText((Integer)nameInput);
				GameOver.name[inputCount] = keyString;
				
			}
			//to increment name character input
			if(key == KeyEvent.VK_ENTER){
				
					inputCount++;
					System.out.println(inputCount);
				//if(inputCount>2)
				//	game.State = STATE.HIGHSCORE;// changes state once 3 inputs are added
				
				}
			
			
	}
		
	}
	/**
	 * Overrides the KeyReleased method
	 */
	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		//game state keys
		if(game.State==STATE.GAME)
		{
			//player keys
			for(int i=0; i<handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				
				//movement keys for player
				if(tempObject.getId()== ObjectId.Player)
				{
					if(key == KeyEvent.VK_D && tempObject.velX > 0) tempObject.setVelX(0);
					if(key == KeyEvent.VK_A && tempObject.velX < 0) tempObject.setVelX(0);
					if(key == KeyEvent.VK_W && tempObject.velY < 0) tempObject.setVelY(0);
					if(key == KeyEvent.VK_S && tempObject.velY > 0)tempObject.setVelY(0);
					
				}
			}
		}

	}
}
