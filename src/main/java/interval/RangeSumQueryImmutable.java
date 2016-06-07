package interval;

/*

 Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive.

 Example:

 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3

 Note:

 1.You may assume that the array does not change.
 2.There are many calls to sumRange function.

 */

public class RangeSumQueryImmutable {
	// O(N) init, O(1) query, O(N) update

	public class NumArray {

		int[] partialSums;

		public NumArray(int[] nums) {

			if (nums.length == 0)
				return;

			partialSums = new int[nums.length];
			partialSums[0] = nums[0];

			for (int i = 1; i < nums.length; i++) {
				partialSums[i] = partialSums[i - 1] + nums[i];
			}
		}

		public int sumRange(int i, int j) {
			if (i == 0)
				return partialSums[j];
			else
				return partialSums[j] - partialSums[i - 1];
		}
	}
}
