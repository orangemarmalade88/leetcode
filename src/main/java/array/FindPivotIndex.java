package array;

public class FindPivotIndex {
	public int pivotIndex(int[] nums) {
		int total = 0;
		for (int i : nums) {
			total += i;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (sum == total - nums[i] - sum)
				return i;
			sum += nums[i];
		}
		return -1;
	}
}
