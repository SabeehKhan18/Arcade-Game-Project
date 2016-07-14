package Helpers;

import java.util.Random;

/**
 * This utility class provides some useful functions for generating random
 * numbers.
 * 
 */
public abstract class RandomHelper {

	/**
	 * Returns a random integer in the range [min, max)
	 * 
	 * @param min
	 *            result will be at least this large
	 * @param max
	 *            result will be smaller than this
	 * @return random integer
	 */
	public static int randRange(int min, int max) {
		return (int) randInterval(min, max);
	}

	/**
	 * Returns a random double in the range [min, max)
	 * 
	 * @param min
	 *            result will be at least this large
	 * @param max
	 *            result will be smaller than this
	 * @return random double
	 */
	public static double randInterval(double min, double max) {
		return Math.random() * (max - min) + min;
	}
	
	/**
	 * 
	 * Returns a random boolean
	 *
	 * @return random boolean
	 */
	public static boolean randBoolean() {
		Random r = new Random();
		return r.nextBoolean();
	}

}
