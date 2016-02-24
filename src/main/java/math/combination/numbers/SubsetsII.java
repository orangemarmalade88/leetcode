package math.combination.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note:

 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.


 For example,
 If nums = [1,2,2], a solution is:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 */

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfs(int[] nums, int i, List<Integer> current,
			List<List<Integer>> result) {
		result.add(new ArrayList<>(current));
		for (int s = i; s < nums.length; s++) {

			current.add(nums[s]);
			dfs(nums, s + 1, current, result);
			current.remove(current.size() - 1);
			while (s < nums.length - 1 && nums[s] == nums[s + 1])
				s++;
		}
	}
}
