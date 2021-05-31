package game;

public class JumpGame {
	/*
	 * Given an array of non-negative integers nums, you are initially
	 * positioned at the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * 
	 */
	public boolean canJump(int[] nums) {
		boolean[] jumpable = new boolean[nums.length];
		jumpable[nums.length - 1] = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			boolean res = false;
			for (int j = i + 1; j < nums.length; j++) {
				res |= jumpable[j] && nums[i] >= (j - i);
			}
			jumpable[i] = res;
		}
		return jumpable[0];
	}
}
