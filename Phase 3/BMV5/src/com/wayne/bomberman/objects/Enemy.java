/**
 * Enemy class for the enemy. This class gives the enemy its attributes, movements, rendering and bounds. 
 */
package com.wayne.bomberman.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;
import com.wayne.bomberman.framework.GameObject;
import com.wayne.bomberman.framework.Intelligence;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.framework.Texture;
import com.wayne.bomberman.windows.Handler;
import com.wayne.bomberman.windows.game;

/**
 * Enemy class
 */
public class Enemy extends GameObject implements Intelligence {
	private int health;
	private int points;
	private int detectionRange=120;
	Texture tex = game.getInstance();

	private float width =32, height = 32;
	private Handler handler;
	public int speed = 3;
	//private Position position;
	int type;
	int bombY=0;
	int bombX=0;
	int playerX=0;
	int playerY=0;
	int action=0;
	Random randomGenerator = new Random();
	
	/**
	 * Constructor for the enemy class
	 * @param p position of the enemy
	 * @param handler GameObject handler
	 * @param type enemy type
	 * @param id enemy's id
	 */
	public Enemy(Position p, Handler handler,int type, ObjectId id) {
		super(p, id);
		this.handler = handler;
		this.type=type;
	}
	
	/**
	 * Overrides the tick method
	 * constantly checks bomb and player position
	 */
	public void tick(LinkedList<GameObject> object) {
		int test = randomGenerator.nextInt(5);
		if (detectBomb() == true) {
			avoidBomb();
		}
		else if (detectPlayer() == true) {
			followPlayer();
		}
		else {
			if(test == 1) {
				moveRandomly();
			}
		}
		
		position.x += velX;
		position.y += velY;
		
		Collision(object);
	}

	/**
	 * This method give the enemy collision and consequences for the player when they collide
	 * @param object GameObjects used
	 */
	private void Collision(LinkedList<GameObject> object){
		
	
			for(int i = 0; i< handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ObjectId.Block){
					
					if(getBoundsTop().intersects(tempObject.getBounds()))
					{
						position.y = tempObject.getPosition().getY() + 32;
					
					}
					
					if(getBounds().intersects(tempObject.getBounds()))
					{
						position.y = (int) (tempObject.getPosition().getY() - height);
					
					}
				
					//right
					if(getBoundsRight().intersects(tempObject.getBounds()))
					{
						position.x = (int) (tempObject.getPosition().getX() - width);
					
					}
					//left
					if(getBoundsLeft().intersects(tempObject.getBounds()))
					{
						position.x = tempObject.getPosition().getX() + 32;
						
					}
				}
				if(Handler.bomb!=null && Handler.bomb.getId() == ObjectId.Block){

					if(getBoundsTop().intersects(Handler.bomb.getBounds()))
					{
						position.y = Handler.bomb.getPosition().getY() + 32;
					
					}
					
					if(getBounds().intersects(Handler.bomb.getBounds()))
					{
						position.y = (int) (Handler.bomb.getPosition().getY() - height);
					
					}
				
					//right
					if(getBoundsRight().intersects(Handler.bomb.getBounds()))
					{
						position.x = (int) (Handler.bomb.getPosition().getX() - width);
					
					}
					//left
					if(getBoundsLeft().intersects(Handler.bomb.getBounds()))
					{
						position.x = Handler.bomb.getPosition().getX() + 32;
						
					}
				}
				if(tempObject.getId() == ObjectId.Player){
					if(!Player.invincible){
					
					if(getBoundsTop().intersects(tempObject.getBounds()))
					{
						Player.tHit = System.currentTimeMillis();
						Player.health--;
					}
					
					if(getBounds().intersects(tempObject.getBounds()))
					{
						Player.tHit = System.currentTimeMillis();
						Player.health--;
					}
				
					//right
					if(getBoundsRight().intersects(tempObject.getBounds()))
					{
						
						Player.tHit = System.currentTimeMillis();
						Player.health--;
					}
					//left
					if(getBoundsLeft().intersects(tempObject.getBounds()))
					{
						Player.tHit = System.currentTimeMillis();
						Player.health--;
					}
				}
				}
				
			}
	}

	/**
	 * Overrides the render method
	 * draws out the enemies depending on type
	 */
	public void render(Graphics g) {
		if(type == 0)
			g.drawImage(tex.enemy[0], position.x, position.y, null);
		if(type == 1)
			g.drawImage(tex.enemy[1], position.x, position.y, null);
		if(type == 2)
			g.drawImage(tex.enemy[2], position.x, position.y, null);
	
	}
	
	/**
	 * Bounds for the enemy are created with rectangles
	 */
	public Rectangle getBounds() {
		return new Rectangle((int) (position.getX()+(width/2)-((width/2)/2)), (int) ((int) position.getY()+(14)), (int) width/2, (int) height/2);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) (position.getX()+(width/2)-((width/2)/2)), (int) position.getY(), (int) width/2, (int) height/2);
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int) (position.getX()+width-5), (int) position.getY()+5, (int) 4, (int) height-12);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) position.getX(), (int) position.getY()+1, (int) 4, (int) height-4);
	}


	/**
	 * Getter method for enemy points value
	 * @return points
	 */
	public int getValue() {
		return this.points;
	}

	/**
	 * Setter method for enemy points value
	 * @return points
	 */
	public void setValue(int pointsWorth) {
		this.points = pointsWorth;
	}



	/**
	 * Getter method for enemy points value
	 * @return speed
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * Setter method for enemy points value
	 * @return speed
	 */
	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}


	/**
	 * Getter method for enemy health value
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Setter method for enemy health value
	 * @return health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * this method checks if enemy is hit by bomb
	 * @param hit boolean value
	 */
	public void isHit(boolean hit) {
		this.health--;
	}

	// new move methods for the AI
	// helper methods
	/**
	 * this method moves the ai up
	 */
	public void moveUpAI() {
		try {
			moveUp(this.speed);
			Thread.sleep(1);
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt(); 
		}
		finally {
			//moveUp(0);
		}
	}
	/**
	 * this method moves the ai down
	 */
	public void moveDownAI() {
		try {
			moveDown(this.speed);
			Thread.sleep(1);
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt(); 
		}
		finally {
			//moveDown(0);
		}
	}
	/**
	 * this method moves the ai to the right
	 */
	public void moveRightAI() {
		try {
			moveRight(this.speed);
			Thread.sleep(1);
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt(); 
		}
		finally {
			//moveRight(0);
		}
	}
	/**
	 * this method moves the ai to the left
	 */
	public void moveLeftAI() {
		try {
			moveLeft(this.speed);
			Thread.sleep(1);
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt(); 
		}
		finally {
			//moveLeft(0);
		}
	}

	/**
	 * Setter for range of detection for ai
	 */
	public void setDetectionRange(int range) {
		this.detectionRange = range;
	}
	/**
	 * Getter for range of detection for ai
	 */
	public int getDetectionRange() {
		return this.detectionRange;
	}
	
	/**
	 * this method detects if the player is in range position 
	 * @return true if detected
	 */
	public boolean detectPlayer() {
		int range = getDetectionRange();
		for(int i=0; i<handler.object.size();i++) {
			if(handler.object.get(i) instanceof Player) {
				if((((handler.object.get(i).position.getX()-this.position.getX()) * (handler.object.get(i).position.getX()-this.position.getX()))
				    +((handler.object.get(i).position.getY()-this.position.getY()) * (handler.object.get(i).position.getY()-this.position.getY())))
					<=(range * range)) {
					this.playerX = handler.object.get(i).position.getX();
					this.playerY = handler.object.get(i).position.getY();
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * this method follows the player's position
	 */
	public void followPlayer() {
		int enemyX = this.position.getX();
		int enemyY = this.position.getY();
		int xDist = Math.abs(enemyX - playerX);
		int yDist = Math.abs(enemyY - playerY);

		if (xDist > yDist) {
			if (enemyX > playerX) {
				moveLeftAI();
			}
			else {
				moveRightAI();
			}
		} 
		else {
			if (enemyY > playerY) {
				moveUpAI();
			}
			else {
				moveDownAI();
			}
		}
	}
	
	/**
	 * this method checks if bomb is detected inside range
	 * @return true if bomb is in range
	 */
	public boolean detectBomb() {
		int range = getDetectionRange();
		for(int i=0; i<handler.object.size();i++) {
			if(handler.object.get(i) instanceof Bomb) {
				if((((handler.object.get(i).position.getX()-this.position.getX()) * (handler.object.get(i).position.getX()-this.position.getX()))
				    +((handler.object.get(i).position.getY()-this.position.getY()) * (handler.object.get(i).position.getY()-this.position.getY())))
					<=(range * range)) {
					this.bombX = handler.object.get(i).position.getX();
					this.bombY = handler.object.get(i).position.getY();
					return true;
				}
			}
		}
		return false;
	}
		

	/**
	 * detects if there is a block on the right
	 * @return true if there is a block
	 */
	public boolean detectBlockOnRight() {
		for(int i=0; i<handler.object.size();i++) {
			if(handler.object.get(i) instanceof Block) {
				if((Math.abs(handler.object.get(i).position.getX()-this.position.getX()) < getDetectionRange()) && (handler.object.get(i).position.getX()-this.position.getX() > this.position.getX())) {   //checks if there is a block that is directly to the right of the enemy amongst all blocks on the map
					return true;
				}
			}
		}
	 	return false;
	}


	/**
	 * detects if there is a block on the left
	 * @return true if there is a block
	 */
	public boolean detectBlockOnLeft() {
		for(int i=0; i<handler.object.size();i++) {
			if(handler.object.get(i) instanceof Block) {
				if((Math.abs(handler.object.get(i).position.getX()-this.position.getX()) < getDetectionRange()) && (handler.object.get(i).position.getX()-this.position.getX() < this.position.getX())) {    //checks if there is a block that is directly to the left of the enemy amongst all blocks on the map
					return true;
				}
			}
		}
	 	return false;
	}


	/**
	 * detects if there is a block above
	 * @return true if there is a block
	 */
	public boolean detectBlockAbove() {
		for(int i=0; i<handler.object.size();i++) {
			if(handler.object.get(i) instanceof Block) {
				if((Math.abs(handler.object.get(i).position.getY()-this.position.getY()) < getDetectionRange()) && (handler.object.get(i).position.getY()-this.position.getY() < this.position.getY())) {    //checks if there is a block that is directly above the enemy amongst all blocks on the map
					return true;
				}
			}
		}
	 	return false;
	}

	/**
	 * detects if there is a block under
	 * @return true if there is a block
	 */
	public boolean detectBlockUnder() {
		for(int i=0; i<handler.object.size();i++) {
			if(handler.object.get(i) instanceof Block) {
				if((Math.abs(handler.object.get(i).position.getY()-this.position.getY()) < getDetectionRange()) && (handler.object.get(i).position.getX()-this.position.getX() > this.position.getX())) {	 //checks if there is a block that is directly under the enemy amongst all blocks on the map
					return true;
				}
			}
		}
	 	return false;
	}



	/**
	 * this method gives the ai ability to avoid the bomb
	 */
	public void avoidBomb() {
		int bombX = this.bombX;
		int bombY = this.bombY;
		int enemyX = this.position.getX();
		int enemyY = this.position.getY();
		while (detectBomb()) {
			if((Math.abs((bombY - enemyY)) >= Math.abs((bombX - enemyX))) && (bombY < enemyY)) {      //Bomb is above the enemy
				if(!detectBlockUnder())
					moveDownAI();
				else if(!detectBlockOnRight())
					moveRightAI();
				else 
					moveLeftAI();
			}
			
			else if((Math.abs((bombY - enemyY)) >= Math.abs((bombY - enemyY))) && (bombY > enemyY)) {   //Bomb is under
				if(!detectBlockAbove())
					moveUpAI();
				else if(!detectBlockOnRight())
					moveRightAI();
				else 
					moveLeftAI();
			}
			
			else if((Math.abs((bombY - enemyY)) <= Math.abs((bombY - enemyY))) && (bombX < enemyX)) {    //Bomb is to the left
				if(!detectBlockOnRight())
					moveRightAI();
				else if(!detectBlockAbove())
					moveUpAI();
				else 
					moveDownAI();
			}
			
			else if((Math.abs((bombY - enemyY)) <= Math.abs((bombY - enemyY))) && (bombX > enemyX)) {    //Bomb is to the right    
				if(!detectBlockOnLeft())
					moveLeftAI();
				else if(!detectBlockAbove())
					moveUpAI();
				else 
					moveDownAI();
			}
					
		}
	}
	/**
	 * this methods gives the ai random movement
	 */
	public void moveRandomly() {
		this.action = randomGenerator.nextInt(30);
		if(this.action == 0){
			moveUpAI();
		}
		else if(this.action == 1){
			moveDownAI();
		}
		else if(this.action == 2){
			moveLeftAI();
		}
		else if(this.action == 3) {
			moveRightAI();
		}
		else {

		}
	}
	/**
	 * Overrides the isBombed method
	 * checks to see if bomb explosion intersects
	 */
	@Override
	public boolean isBombed(Bomb bomb) {
		Rectangle rect1=new Rectangle(bomb.position.x-bomb.range,bomb.position.y,32+2*bomb.range,32);
		Rectangle rect2=new Rectangle(bomb.position.x,bomb.position.y-bomb.range,32,32+2*bomb.range);
		Rectangle rect3=new Rectangle(this.position.x,this.position.y,32,32);
		if(rect1.intersects(rect3)||rect2.intersects(rect3)){
			game.score+=100;
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Overrides the detectPlayer method
	 */
	@Override
	public boolean detectPlayer(Player bomberman1) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overrides the followPlayer method
	 */
	@Override
	public void followPlayer(Player bomberman1, int range) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Overrides the detectBomb method
	 */
	@Override
	public boolean detectBomb(Bomb bomb1) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Overrides the avoidBomb method
	 */
	@Override
	public void avoidBomb(Bomb bomb1) {
		// TODO Auto-generated method stub
		
	}
	
}