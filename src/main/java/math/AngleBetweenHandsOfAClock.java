package math;

public class AngleBetweenHandsOfAClock {
	/*
	 * Given two numbers, hour and minutes. Return the smaller angle (in
	 * degrees) formed between the hour and the minute hand.
	 * 
	 * 
	 */
	public double angleClock(int hour, int minutes) {
		double m = minutes / 60.0 * 360.0;
		double h = hour / 12.0 * 360 + minutes / 60.0 * 360.0 / 12.0;
		double angle = Math.abs(m - h);
		return angle > 180 ? 360 - angle : angle;
	}
}
