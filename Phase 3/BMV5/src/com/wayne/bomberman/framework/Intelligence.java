/**
 * intelligence class for enemy behaviors
 * 
 * @since April 13, 2014
 */
package com.wayne.bomberman.framework;

import com.wayne.bomberman.objects.Bomb;
import com.wayne.bomberman.objects.Player;
/**
 * Intelligence Class
 * @author Simon krafft, Alistar Russell
 *
 */
public interface Intelligence {
	int detectionRange = 0;
	void setDetectionRange(int range);
	int getDetectionRange();
	boolean detectPlayer(Player bomberman1);
	void followPlayer(Player bomberman1, int range);
	boolean detectBomb(Bomb bomb1);
	void avoidBomb(Bomb bomb1);
 }