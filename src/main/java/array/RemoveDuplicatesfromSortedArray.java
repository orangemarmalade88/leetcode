package array;

/*

 Given a sorted array, remove the duplicates in place such that each element appear only once and
 return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 */

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int fast = 0;
		int slow = 0;
		int last = Integer.MIN_VALUE;

		while (fast < nums.length) {
			int current = nums[fast];
			fast++;
			if (current != last) {
				nums[slow++] = current;
				last = current;
			}
		}

		return slow;
	}

	// Improvement: slow points to last element that is valid
	// rather than, the insert position
	public int removeDuplicates2(int[] nums) {
		if (nums.length <= 1)
			return nums.length;

		int fast = 1;
		int slow = 0;

		while (fast < nums.length) {
			if (nums[fast] != nums[slow]) {
				nums[++slow] = nums[fast];
			}
			fast++;
		}

		return slow + 1;
	}
}
