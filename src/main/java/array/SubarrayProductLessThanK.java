package array;

public class SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int slow = 0;
		int prod = 1;
		int count = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			prod *= nums[fast];
			while (prod >= k && slow < fast) {
				prod /= nums[slow++];
			}
			if (prod < k)
				count += fast - slow + 1;
		}
		return count;
	}
}
