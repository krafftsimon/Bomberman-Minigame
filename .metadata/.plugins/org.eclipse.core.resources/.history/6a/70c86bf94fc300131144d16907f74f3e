package com.wayne.bomberman.menuwindows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class Menu {

	//buttons
	
	int xPos = 600;
	int xRec =30;
	int yRec = 75;
	public Rectangle playButton = new Rectangle(xRec,yRec,200,50);//position x, position y, button width, button height
	public Rectangle levelButton = new Rectangle(xRec,2*yRec,200,50);
	public Rectangle highscoreButton = new Rectangle(xRec,3*yRec,200,50);
	public Rectangle optionsButton = new Rectangle(xRec,4*yRec,200,50);
	public Rectangle creditsButton = new Rectangle(xRec,5*yRec,200,50);
	public Rectangle exitButton = new Rectangle(xRec,6*yRec,200,50);

	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		float thickness = 5;
		Stroke stroke1 = g2d.getStroke();
		g2d.setStroke(new BasicStroke(thickness));
		
		//buttons
		Font font1 = new Font("arial", Font.BOLD, 25);
		g.setColor(Color.black);
		g.setFont(font1);
		g.fillRect(xPos, yRec, 200, 50);
		g.fillRect(xPos, 2*yRec, 200, 50);
		g.fillRect(xPos, 3*yRec, 200, 50);
		g.fillRect(xPos, 4*yRec, 200, 50);
		g.fillRect(xPos, 5*yRec, 200, 50);
		g.fillRect(xPos, 6*yRec, 200, 50);
		
		g.setColor(Color.pink);
		g.setFont(new Font("CenturyGothic", Font.BOLD, 24)); 
		g.drawString("Play", xPos+70, playButton.y+35);
		g2d.draw(playButton);
		g.drawString("Level Select", xPos+17, levelButton.y+35);
		g2d.draw(levelButton);
		g.drawString("Highscore", xPos+35, highscoreButton.y+35);
		g2d.draw(highscoreButton);
		g.drawString("Options", xPos+50, optionsButton.y+35);
		g2d.draw(optionsButton);
		g.drawString("Credits", xPos+52, creditsButton.y+35);
		g2d.draw(creditsButton);
		g.drawString("Exit Game", xPos+33, exitButton.y+35);
		g2d.draw(exitButton);
	
		g2d.setStroke(stroke1);//Rectangle border thickness
		
		xPos-= 10;
		if(xPos<=30)
			xPos=30;
	}
	
	
}
