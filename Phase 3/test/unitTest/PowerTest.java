package unitTest;

import java.awt.Rectangle;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.wayne.bomberman.framework.*;
import com.wayne.bomberman.objects.Block;
import com.wayne.bomberman.objects.Bomb;
import com.wayne.bomberman.objects.Player;
import com.wayne.bomberman.objects.Power;
import com.wayne.bomberman.windows.Handler;
import com.wayne.bomberman.windows.game;

public class PowerTest {


	/**
	 * Test method for 
	 * {@link com.wayne.bomberman.objects.Power#Power(Position, Int, ObjectId)}.
	 * 
	 */
	@Test
	public void testPowerPositionIntObjectId() {
		final Position position = new Position(0,0);
		final int type = 0;
		final ObjectId id = ObjectId.Block;
		
		Power power = new Power(position, type, id);
		
		Assert.assertEquals(position, power.getPosition());
		Assert.assertEquals(type, 0);
		Assert.assertEquals(id, power.getId());
	}
	
	/**
	 * Test method for 
	 * {@link com.wayne.bomberman.objects.Power#getBounds()}.
	 * 
	 */
	@Test
	public void testGetBounds() {
		final Position position = new Position(0,0);
		final int type = 0;
		final ObjectId id = ObjectId.Power;
		Power power = new Power(position, type, id);
		
		final Rectangle powerRect = new Rectangle(position.x, position.y, 32 ,32);
		Assert.assertEquals(power.getBounds(), powerRect);
	}
	/**
	 * Test method for
	 * {@link com.wayne.bomberman.objects.Power#speedUp(int)#doubleUp(int)#healthUp(int)#rangeUp(int)}. 
	 * 
	 */
	public void testSpeedDoubleHealthRangleUp(){
		game.score = 1;
		Power.doubleUp(0);
		Assert.assertEquals(2, game.score);
		
		Player.speed = 1;
		Power.speedUp(1);
		Assert.assertEquals(2, Player.speed);
		
		Player.health = 1;
		Integer doubledHealth = 2;
		Power.healthUp(2);
		Assert.assertEquals(doubledHealth, Player.health);
		
		Bomb.range = 32;
		Power.rangeUp(3);
		Assert.assertEquals(64, Bomb.range);	
	}
	
	/**
	 * Test method for 
	 * {@link com.wayne.bomberman.objects.Power#selectPower(int)}.
	 * 
	 */
	public void testSelectPower() {
		game.score = 1;
		Power.selectPower(0);
		Assert.assertEquals(2, game.score);
	}
	
	/**
	 * Test method for 
	 * {@link com.wayne.bomberman.objects.Power#consumed(Power,LinkedList)}.
	 * 
	 */
	public void testConsumed(){
		final Position position = new Position(0,0);
		final Handler handler = new Handler();
		final ObjectId idPlayer = ObjectId.Player;
		final ObjectId idPower = ObjectId.Power;
		
		final Player player = new Player(position,handler,idPlayer);
		final Power power = new Power(position, 0, idPower);
		
		final LinkedList<GameObject> object = new LinkedList<GameObject>();
		object.add(player);
		
		Assert.assertTrue(Power.consumed(power, object));		
	}
	
	
	
	/**
	 * Test method for 
	 * {@link com.wayne.bomberman.objects.Power#isBombed(Bomb)}.
	 * 
	 */
	@Test
	public void testIsBombedBomb() {
		final Position position = new Position(0,0);
		final int type = 0;
		final ObjectId id = ObjectId.Power;
		Power power = new Power(position, type, id);
		
		Bomb bomb = new Bomb(position, ObjectId.Bomb);
		
		Assert.assertFalse(power.isBombed(bomb));
	}
	

}
