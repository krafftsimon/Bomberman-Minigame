/**
 * MouseInput Class for the mouse functions
 * 
 * 
 */
package com.wayne.bomberman.framework;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.wayne.bomberman.windows.game;
/**
 * MouseInput Class
 * @author HattoriHanzo
 *
 */
public class MouseInput implements MouseListener{

	public static int levelNum;
	public static Position exitPosition;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overrides the mouseEntered method
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Overrides the mouseExited Method
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Overrides the mousePressed method
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	
		int mx = e.getX();
		int my = e.getY();
		
		// inputs for game cover
		//changes the state from GameCover to Menu
		if(game.State == STATE.GAMECOVER)
			game.State = STATE.MENU;
		
		//Mouse inputs for MENU
		
		if(game.State==STATE.MENU)
		{
			//target click to play game
			if(mx >=30 && mx<= 230)
			{
				if(my >=75 && my<= 125)
				{
					KeyInput.inputCount = 0;
					levelNum=1;
					game.State= STATE.GAME;
					exitPosition = new Position(512,416);
					game.score = 0;
					
				}
			}
			//target click to levelSelect
			if(mx >=30 && mx<= 230)
			{
				if(my >=150 && my<= 200)
				{
					game.State= STATE.LEVELSELECT;
				}
			}
			//target click to HighScore
			if(mx >=30 && mx<= 230)
			{
				if(my >=225 && my<= 275)
				{
					game.State= STATE.HIGHSCORE;
				}
			}
			//target click to HowToPlay
			if(mx >=30 && mx<= 230)
			{
				if(my >=300 && my<= 350)
				{
					game.State= STATE.HOWTOPLAY;
				}
			}
			//target click to Credits
			if(mx >=30 && mx<= 230)
			{
				if(my >=375 && my<= 425)
				{
					game.State = STATE.CREDITS;
				}
			}
			//target click to exit
			if(mx >=30 && mx<= 230)
			{
				if(my >=450 && my<= 500)
				{
					System.exit(1);
				}
			}
		}

		
			//Mouse buttons for LEVEL SELECT
		if(game.State==STATE.LEVELSELECT){
				//target click to Menu
				if(mx >=365 && mx<= 520)
				{
					if(my >= 475 && my<= 525)
					{
						game.State = STATE.MENU;
					}
				}
			
				//target click to Level 1
				if(mx >=450 && mx<= 575)
				{
					if(my >= 125 && my<= 175)
					{
						game.State = STATE.GAME;
						levelNum=1;
						exitPosition=new Position(512,416);
					}
				}
				
				//target click to Level 2
				if(mx >=450 && mx<= 575)
				{
					if(my >= 200 && my<= 250)
					{
						game.State = STATE.GAME;
						levelNum=2;
						exitPosition=new Position(512,416);
					}
				}
				
				//target click to Level 3
				if(mx >=450 && mx<= 575)					{
					if(my >= 275 && my<= 325)
					{
						game.State = STATE.GAME;
						levelNum=3;
						exitPosition=new Position(512,416);
					}
				}
				
				//target click to Level 4
				if(mx >=450 && mx<= 575)
				{
					if(my >= 350 && my<= 400)
					{
						game.State = STATE.GAME;
						levelNum=4;
						exitPosition=new Position(512,416);
					}
				}
				
				//target click to Level 5
				if(mx >=450 && mx<= 575)
				{
					if(my >= 425 && my<= 475)
					{
						game.State = STATE.GAME;
						levelNum=5;
						exitPosition=new Position(512,416);
					}
				}
				//target click to Level 6
				if(mx >=650 && mx<= 775)
				{
					if(my >= 125 && my<= 175)
					{
						game.State = STATE.GAME;
						levelNum=6;
						exitPosition=new Position(512,416);
					}
				}
				
				//target click to Level 7
				if(mx >=650 && mx<= 775)
				{
					if(my >= 200 && my<= 250)
					{
						game.State = STATE.GAME;
						levelNum=7;
						exitPosition=new Position(512,416);
					}
				}
				
				//target click to Level 8
				if(mx >=650 && mx<= 775)
				{
					if(my >= 275 && my<= 325)
					{
						game.State = STATE.GAME;
						levelNum=8;
						exitPosition=new Position(64,256);
					}
				}
				
				//target click to Level 9
				if(mx >=650 && mx<= 775)
				{
					if(my >= 350 && my<= 400)
					{
						game.State = STATE.GAME;
						levelNum=9;
						exitPosition = new Position(608,352);
					}
				}
				
				//target click to Level 10
				if(mx >=650 && mx<= 775)
				{
					if(my >= 425 && my<= 475)
					{
						game.State = STATE.GAME;
						levelNum=10;
						exitPosition = new Position(608,352);	
					}
				}
			
				//target for menu 
				if(mx >=535 && mx<= 690)
				{
					if(my >= 500 && my<= 550)
					{
						game.State = STATE.MENU;
					}
				}
		}
		//Mouse buttons for How To Play
		if(game.State==STATE.HOWTOPLAY){
			//target to menu
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.MENU;
				}
			}
		
		}
		//Mouse buttons for high scores
		if(game.State==STATE.HIGHSCORE){
			//target for menu
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.MENU;
				}
			}
		}
		
		//Mouse buttons for credits
		if(game.State==STATE.CREDITS){
			//target for menu
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.MENU;
				}
			}
		}
		
		//Mouse buttons for credits
		if(game.State==STATE.PAUSE){
			//target for game
			if(mx >=325 && mx<= 475)
			{
				if(my >= 125 && my<= 175)
				{
					game.State = STATE.GAME;
				}
			}
			
			//target for PauseOptions
			if(mx >=325 && mx<= 475)
			{
				if(my >= 215 && my<= 265)
				{
					game.State = STATE.PAUSEOPTIONS;
				}
			}
			
			//target for Menu
			if(mx >=325 && mx<= 475)
			{
				if(my >= 305 && my<= 355)
				{
					game.State = STATE.MENU;
				}
			}
		}
		//Mouse inputs for options from pause
		if(game.State==STATE.PAUSEOPTIONS){
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.PAUSE;
				}
			}
		}

		//Mouse buttons for options from pause
		if(game.State==STATE.GAMEOVER){
			if(mx >=305 && mx<= 505)
				{
				if(my >= 265 && my<= 315)
				{
					game.State = STATE.MENU;
				}
			}
		}
	}

	/**
	 * Overrides the mouseReleased method
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
