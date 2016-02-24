package math.combination.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 Given a set of distinct integers, nums, return all possible subsets.

 Note:

 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.


 For example,
 If nums = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 */

public class Subsets {
	// Other thoughts: use bit map to generate all possible sets
	// 111 -> [1, 2, 3] 101 -> [1, 3] 000 -> []

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfs(int[] nums, int i, List<Integer> current,
			List<List<Integer>> result) {
		if (i >= nums.length)
			result.add(current);
		else {
			List<Integer> contained = new ArrayList<Integer>(current);
			contained.add(nums[i]);
			dfs(nums, i + 1, contained, result);
			List<Integer> notContained = new ArrayList<Integer>(current);
			dfs(nums, i + 1, notContained, result);
		}
	}

	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int l = 1 << nums.length;
		for (int i = 0; i < l; i++) {
			int temp = i;
			List<Integer> list = new ArrayList<>();
			while (temp != 0) {
				int index = Integer.numberOfTrailingZeros(temp);
				list.add(nums[index]);
				temp ^= (1 << index);
			}
			result.add(list);
		}
		return result;
	}

}
