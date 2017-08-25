/**
 * GameCover Class for initial game program graphical image
 */
package com.wayne.bomberman.menuwindows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * GameCover Class
 *
 */
public class GameCover 
{
	int Xpos = 500;

	/**
	 * Rendering method for GameCover Class
	 * @param g Graphics to render
	 */
	public void render(Graphics g) 
	{
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 22)); 
		//draws only when at this position, produces flashing text
		if(Xpos==250)
		g.drawString("Press SpaceBar to Continue", Xpos, 560);
		Xpos-=250;
		if(Xpos < 0)
			Xpos = 500;
	}
}

