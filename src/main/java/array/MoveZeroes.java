package array;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int zeros = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				zeros++;
			else
				nums[i - zeros] = nums[i];
		}

		for (int i = nums.length - zeros; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
