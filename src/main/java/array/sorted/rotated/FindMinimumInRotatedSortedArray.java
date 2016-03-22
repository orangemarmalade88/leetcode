package array.sorted.rotated;

/*

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 */

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (nums[low] > nums[high]) {
			int mid = (low + high) >>> 1;
			// Mistake: the equal sign! low could be == mid
			if (nums[low] <= nums[mid]) // left side is sorted, right side is
										// rotated
				low = mid + 1;
			else
				// left side including mid is rotated, right side is sorted
				high = mid;
		}
		return nums[low];
	}
}
