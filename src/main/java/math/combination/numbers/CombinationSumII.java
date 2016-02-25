package math.combination.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 The solution set must not contain duplicate combinations.


 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]

 */

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, new ArrayList<Integer>(), 0, 0, result);
		return result;
	}

	private void dfs(int[] candidates, int target, List<Integer> current,
			int startIdx, int partialSum, List<List<Integer>> result) {
		if (partialSum == target) {
			result.add(new ArrayList<>(current));
		} else if (partialSum > target) {
			return;
		} else {
			for (int i = startIdx; i < candidates.length; i++) {
				current.add(candidates[i]);
				dfs(candidates, target, current, i + 1, partialSum
						+ candidates[i], result);
				current.remove(current.size() - 1);
				while (i < candidates.length - 1
						&& candidates[i] == candidates[i + 1])
					i++;
			}
		}
	}
}
