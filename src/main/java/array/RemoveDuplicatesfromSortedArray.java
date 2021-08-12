package array;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		int fast = 1;
		int slow = 0;
		while (fast < nums.length) {
			if (nums[fast] == nums[slow]) {
				fast++;
			} else {
				nums[++slow] = nums[fast++];
			}
		}
		return slow + 1;
	}
}
