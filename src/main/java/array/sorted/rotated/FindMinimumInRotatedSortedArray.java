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
		while (low < high) {

			// fast-fail for no duplicate case only
			if (nums[low] < nums[high])
				return nums[low];

			int mid = (low + high) >>> 1;
			// Use the right half because no chance of low == mid

			// Right half is sorted, minimum in left half
			if (nums[mid] < nums[high]) {
				high = mid;
			}
			// Right half is rotated, minimum in right half, also can't be mid
			else {
				low = mid + 1;
			}
		}
		return nums[low];
	}
}
