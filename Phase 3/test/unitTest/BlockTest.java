package unitTest;

import java.awt.Rectangle;

import org.junit.Test;
import org.junit.Assert;

import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.objects.Block;
import com.wayne.bomberman.objects.Bomb;

	public class BlockTest {
		
		/**
		 * Test method for 
		 * {@link com.wayne.bomberman.objects.Block#Block(Position, Int, ObjectId)}.
		 * 
		 */
		@Test
		public void testBlockPositionIntObjectId() {
			final Position position = new Position(0,0);
			final int type = 0;
			final ObjectId id = ObjectId.Block;
			
			Block block = new Block(position, type, id);
			
			Assert.assertEquals(position, block.getPosition());
			Assert.assertEquals(type, 0);
			Assert.assertEquals(id, block.getId());
		}
		
		
		
		/**
		 * Test method for 
		 * {@link com.wayne.bomberman.objects.Block.getBounds()}.
		 * 
		 */
		@Test
		public void testGetBounds() {
			final Position position = new Position(0,0);
			final int type = 0;
			final ObjectId id = ObjectId.Block;
			Block block = new Block(position, type, id);
			
			final Rectangle blockRect = new Rectangle(position.x, position.y, 32 ,32);
			Assert.assertEquals(block.getBounds(), blockRect);
		}
		
		
		/**
		 * Test method for 
		 * {@link com.wayne.bomberman.objects.Block.isBombed(Bomb)}.
		 * 
		 */
		@Test
		public void testIsBombedBomb() {
			final Position position = new Position(0,0);
			final int type = 0;
			final ObjectId id = ObjectId.Block;
			Block block = new Block(position, type, id);
			
			Bomb bomb = new Bomb(position, ObjectId.Bomb);
			
			Assert.assertFalse(block.isBombed(bomb));
		}
		
		
	}
