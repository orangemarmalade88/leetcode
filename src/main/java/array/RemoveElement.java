package array;

/*

 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 */

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int slow = 0;
		int fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != val)
				nums[slow++] = nums[fast++];
			else
				fast++;
		}
		return slow;
	}
}
