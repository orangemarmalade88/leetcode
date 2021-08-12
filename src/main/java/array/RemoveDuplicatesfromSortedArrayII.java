package array;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		int slow = 0;
		int fast = 1;
		int count = 1;
		while (fast < nums.length) {
			if (nums[slow] == nums[fast]) {
				count++;
				if (count > 2) {
					fast++;
				} else {
					slow++;
					nums[slow] = nums[fast];
					fast++;
				}
			} else {
				slow++;
				nums[slow] = nums[fast];
				fast++;
				count = 1;
			}

		}
		return slow + 1;
	}
}
