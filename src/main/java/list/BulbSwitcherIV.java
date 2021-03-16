package list;

public class BulbSwitcherIV {
	/*
	 * 1529. Bulb Switcher IV
	 * 
	 * There is a room with n bulbs, numbered from 0 to n-1, arranged in a row
	 * from left to right. Initially all the bulbs are turned off.
	 * 
	 * Your task is to obtain the configuration represented by target where
	 * target[i] is '1' if the i-th bulb is turned on and is '0' if it is turned
	 * off.
	 * 
	 * You have a switch to flip the state of the bulb, a flip operation is
	 * defined as follows:
	 * 
	 * Choose any bulb (index i) of your current configuration. Flip each bulb
	 * from index i to n-1. When any bulb is flipped it means that if it is 0 it
	 * changes to 1 and if it is 1 it changes to 0.
	 * 
	 * Return the minimum number of flips required to form target.
	 * 
	 */
	public int minFlips(String target) {
		int count = 0;
		boolean state = false;
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == '1' && !state) {
				count++;
				state = true;
			} else if (target.charAt(i) == '0' && state) {
				count++;
				state = false;
			}
		}
		return count;
	}
}
