package array;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		int zero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0 && i > zero) {
				nums[zero++] = nums[i];
				nums[i] = 0;
			}
		}
	}
}
