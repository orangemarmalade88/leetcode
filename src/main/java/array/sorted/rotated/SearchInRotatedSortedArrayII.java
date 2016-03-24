package array.sorted.rotated;

/*

 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 */

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (nums[mid] == target)
				return true;

			// Right half is sorted
			if (nums[mid] < nums[high]) {
				if (nums[mid] < target && target <= nums[high])
					low = mid + 1;
				else
					high = mid - 1;
			} else if (nums[mid] == nums[high]) {
				high--;
			}
			// else is mid > high
			else if (nums[mid] == nums[low]) {
				low++;
			}
			// Already have nums[mid] > nums[high] and nums[mid] != nums[low]
			// So it indicates nums[low] < nums[mid]
			else {
				if (nums[low] <= target && target < nums[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return false;
	}
}
