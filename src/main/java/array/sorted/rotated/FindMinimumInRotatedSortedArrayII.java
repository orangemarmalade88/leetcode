package array.sorted.rotated;

/*

 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.

 */

public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) >>> 1;
			// Use the right half because no chance of low == mid

			// Right half is sorted, minimum in left half
			if (nums[mid] < nums[high]) {
				high = mid;
			}
			// Right half is rotated, minimum in right half, also can't be mid
			else if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high--;
			}

		}
		return nums[low];
	}
}
