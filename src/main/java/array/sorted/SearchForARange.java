package array.sorted;

/*

 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 */

public class SearchForARange {

	// Other thoughts:
	// search for target, and just reuse low and high already found
	// search in that range for lower bound and higher bound [3 binary search]

	public int[] searchRange(int[] nums, int target) {
		int first = findFirst(nums, target);
		if (first == -1)
			return new int[] { -1, -1 };
		return new int[] { first, findLast(nums, target) };
	}

	private int findFirst(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int first = -1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (nums[mid] == target) {
				first = mid;
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return first;
	}

	private int findLast(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int last = -1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (nums[mid] == target) {
				last = mid;
				low = mid + 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return last;
	}
}
