package math.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<Integer>(), set);
		List<List<Integer>> result = new ArrayList<>(set);
		return result;
	}

	private void dfs(int[] nums, int i, List<Integer> current,
			Set<List<Integer>> set) {
		if (i >= nums.length)
			set.add(current);
		else {
			List<Integer> contained = new ArrayList<Integer>(current);
			contained.add(nums[i]);
			dfs(nums, i + 1, contained, set);
			List<Integer> notContained = new ArrayList<Integer>(current);
			dfs(nums, i + 1, notContained, set);
		}
	}

}
