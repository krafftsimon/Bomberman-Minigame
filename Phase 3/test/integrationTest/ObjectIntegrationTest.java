package integrationTest;

import org.junit.Test;

import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.objects.Block;
import com.wayne.bomberman.objects.Bomb;
import com.wayne.bomberman.objects.Crate;
import com.wayne.bomberman.objects.Enemy;
import com.wayne.bomberman.objects.ExitDoor;
import com.wayne.bomberman.objects.Player;
import com.wayne.bomberman.objects.Power;
import com.wayne.bomberman.windows.Handler;

public class ObjectIntegrationTest {
	/**
	 * @author Qianyu Liu, Clara Kang
	 */
	@Test
	public void testObject() {
		final Position position = new Position(0,0);
		final Handler handler = new Handler();
		
		final Block block = new Block(position, 0, ObjectId.Block);
		final Bomb bomb = new Bomb(position, ObjectId.Bomb);
		final Player player = new Player(position, handler, ObjectId.Player);
		final Crate crate = new Crate(position, 0, ObjectId.Crate);
		final Enemy enemy = new Enemy(position, handler, 0, ObjectId.Enemy);
		final ExitDoor exitDoor = new ExitDoor(position, ObjectId.ExitDoor);
		final Power power = new Power(position, 0, ObjectId.Power);
	}
}
