/**
 * GameOver Class for losing game resulting graphical image
 */
package com.wayne.bomberman.menuwindows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.Scanner;

import com.wayne.bomberman.windows.game;

/**
 * GameOver Class
 * @author Wayne Tam
 *
 */
public class GameOver {

	Scanner scan = new Scanner(System.in);
	int Xpos = 500;
	int Xpos2 = 500;
	//initial Characters on Screen
	public static String[] name = {"A","A","A"};
	public Rectangle quitButton = new Rectangle(305,265,200,50);
	
	/**
	 * Rendering method for the GameOver Class
	 * @param g Graphics to render
	 */
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		//for rectangle border thickness
		float thickness = 5;
		Stroke stroke1 = g2d.getStroke();
		g2d.setStroke(new BasicStroke(thickness));
		
		g.setColor(Color.red);
		g.setFont(new Font("CenturyGothic", Font.BOLD, 24)); 
	
		g.drawString("Main Menu", quitButton.x+40, quitButton.y+35);
		g2d.draw(quitButton);
	
		g2d.setStroke(stroke1);
	
		g.setFont(new Font("TimesRoman", Font.PLAIN, 72)); 
		if(Xpos==200)
			g.drawString("GAME OVER", Xpos, 100);
		Xpos-=300;
		if(Xpos < 0)
			Xpos = 500;
		
		if(Xpos2==225)
			g.drawString("YOU LOSE!", Xpos2, 200);
		Xpos2-=275;
		if(Xpos2 < 0)
			Xpos2 = 500;
	
		g.drawString("Enter Name", 225, 400);
		g.drawString(name[0], 325, 500);
		g.drawString(name[1], 375, 500);
		g.drawString(name[2], 425, 500);
		
		g.setColor(Color.white);
		g.setFont(new Font("CenturyGothic", Font.BOLD, 22)); 
		g.drawString("Final Score: " + String.valueOf(game.score), 10, 580);
	}
}
