package array;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {

		int index = 0;
		for (int n : nums) {
			if (n != 0) {
				nums[index++] = n;
			}
		}

		for (; index < nums.length; index++) {
			nums[index] = 0;
		}
	}
}
