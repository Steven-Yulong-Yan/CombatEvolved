package deco.combatevolved.util;

public class MathUtil {
	
	public static final float EPSILON = 0.001f;
	
	
	private MathUtil(){
	}
	
	public static boolean floatEquality(float x, float y) {
		return Math.abs(x - y) < EPSILON;
	}
	public static boolean floatEquality(float x, float y, float e) {
		return Math.abs(x - y) < e;
	}

}
