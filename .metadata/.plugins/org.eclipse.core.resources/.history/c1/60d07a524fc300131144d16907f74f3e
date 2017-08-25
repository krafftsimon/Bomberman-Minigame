package com.wayne.bomberman.menuwindows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class levelSelect {
	

	int x=450;
	int x2=650;
	int y=50;
	int yy=75;
	
	int w = 125;
	int h = 50;
	
	public Rectangle level1Button = new Rectangle(x,y+yy,w,h);//position x, position y, button width, button height
	public Rectangle level2Button = new Rectangle(x,y+2*yy,w,h);
	public Rectangle level3Button = new Rectangle(x,y+3*yy,w,h);
	public Rectangle level4Button = new Rectangle(x,y+4*yy,w,h);
	public Rectangle level5Button = new Rectangle(x,y+5*yy,w,h);
	public Rectangle level6Button = new Rectangle(x2,y+yy,w,h);
	public Rectangle level7Button = new Rectangle(x2,y+2*yy,w,h);
	public Rectangle level8Button = new Rectangle(x2,y+3*yy,w,h);
	public Rectangle level9Button = new Rectangle(x2,y+4*yy,w,h);
	public Rectangle level10Button = new Rectangle(x2,y+5*yy,w,h);
	public Rectangle backButton = new Rectangle(535,y+6*yy,155,h);

	public void render(Graphics g){
			
		Graphics2D g2d = (Graphics2D) g;
		
		float thickness = 5;
		Stroke stroke1 = g2d.getStroke();
		g2d.setStroke(new BasicStroke(thickness));
		
		g.setColor(Color.black);
		g.fillRect(x, y+yy, w, h);
		g.fillRect(x, y+2*yy, w, h);
		g.fillRect(x, y+3*yy, w, h); 
		g.fillRect(x, y+4*yy, w, h);
		g.fillRect(x, y+5*yy, w, h);
		g.fillRect(x2, y+yy, w, h);
		g.fillRect(x2, y+2*yy, w, h);
		g.fillRect(x2, y+3*yy, w, h);
		g.fillRect(x2, y+4*yy, w, h);
		g.fillRect(x2, y+5*yy, w, h);
		g.fillRect(535, y+6*yy, 155, h);
	
		int a = 15;//horizontal position
		int b = 35;//vertical position
		
		g.setColor(Color.pink);
		Font font1 = new Font("arial", Font.BOLD, 25);
		g.setFont(font1);;
		g.drawString("Level 1", level1Button.x+a, level1Button.y+b);
		g2d.draw(level1Button);
		g.drawString("Level 2", level2Button.x+a, level2Button.y+b);
		g2d.draw(level2Button);
		g.drawString("Level 3", level3Button.x+a, level3Button.y+b);
		g2d.draw(level3Button);
		g.drawString("Level 4", level4Button.x+a, level4Button.y+b);
		g2d.draw(level4Button);
		g.drawString("Level 5", level5Button.x+a, level5Button.y+b);
		g2d.draw(level5Button);
		g.drawString("Level 6", level6Button.x+a, level6Button.y+b);
		g2d.draw(level6Button);
		g.drawString("Level 7", level7Button.x+a, level7Button.y+b);
		g2d.draw(level7Button);
		g.drawString("Level 8", level8Button.x+a, level8Button.y+b);
		g2d.draw(level8Button);
		g.drawString("Level 9", level9Button.x+a, level9Button.y+b);
		g2d.draw(level9Button);
		g.drawString("Level 10", level10Button.x+a, level10Button.y+b);
		g2d.draw(level10Button);
		g.drawString("Main Menu", backButton.x+a, backButton.y+b);
		g2d.draw(backButton);

		g2d.setStroke(stroke1);
	}
}



