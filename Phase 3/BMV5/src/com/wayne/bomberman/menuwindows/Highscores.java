/**
 * HighScores class for high scores graphical image
 */
package com.wayne.bomberman.menuwindows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * HighScores class
 *
 */
public class Highscores {
	
	public static int finalScore=501;
	String scoreList[][] = new String[10][2];
	java.net.URL url = this.getClass().getResource("/highscores.txt");//file from res folder
	
	//positioning values
	int x=40;
	int y=80;
	int w=300;
	int h=50 ;
	
	ArrayList<String> words = new ArrayList<String>();
	public Rectangle title = new Rectangle(x, 30,2*w,h);
	public Rectangle[] nameBox = new Rectangle[10];
	public Rectangle[] scoreBox = new Rectangle[10];
	public Rectangle backButton = new Rectangle(650,540,120,40);

	/**
	 * Rendering method for HighScores class
	 * @param g Graphics to render
	 */
	public void render(Graphics g){
		//for rectangle drawing	
		Graphics2D g2d = (Graphics2D) g;
		
		//for border thickness on rectangles
		float thickness = 5;
		Stroke stroke1 = g2d.getStroke();
		g2d.setStroke(new BasicStroke(thickness));
	
		g.setColor(Color.pink);
		g.setFont(new Font("CenturyGothic", Font.BOLD, 20));
		g.drawString("Back", 685, 565);
		g2d.draw(backButton);
		g2d.draw(title);
		
		for(int i=0; i<nameBox.length;i++){
			Rectangle nameList = new Rectangle(x,y+i*h,w,h);
			nameBox[i] = nameList;
			g2d.draw(nameBox[i]);
		}
		for(int i=0; i<scoreBox.length;i++){
			Rectangle scoreList = new Rectangle(x+w,y+i*h,w,h);
			scoreBox[i] = scoreList;
			g2d.draw(scoreBox[i]);
		}
		
		g.setFont(new Font("CenturyGothic", Font.BOLD, 40));
		g.drawString("H I G H S C O R E S", title.x+120, title.y+40);
		scoreList();
		
		g.setFont(new Font("CenturyGothic", Font.BOLD, 20));
		for(int i = 0; i < 10; i++) {
	
			g.drawString(words.get(i).substring(0, 3), nameBox[i].x + 100, nameBox[i].y + 40);
			
			g.drawString(words.get(i).substring(4, words.get(i).length()), nameBox[i].x + w+100, nameBox[i].y + 40);
		}
		
		g2d.setStroke(stroke1);// rectangle width
		
	}
	
	/**
	 * this method draws the top score list on the HighScore Rectangle
	 *
	 */
	public void scoreList(){
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(url.getPath()));
			
			String line = null;
			while((line = br.readLine()) != null) {
				words.add(new String(line));
			}
			
			for(int i = 0; i < 10; i++) {
				if(Integer.parseInt(words.get(i).substring(4, words.get(i).length())) < finalScore){
					words.add(i, GameOver.name[0] + GameOver.name[1] +GameOver.name[2] + finalScore );
					addList();
					br.close();
					break;
				}
			}
			br.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("file was not found");
		}
	}
	
	/**
	 * this method adds the new high score onto the list of top 10
	 */
	public void addList(){
	
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(url.getPath()));
		
			for(int i = 0; i<10 ; i++){
				bw.write(words.get(i)+" "+finalScore);
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
	}

}
