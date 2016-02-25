package math.combination.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
 where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ..., ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 The solution set must not contain duplicate combinations.


 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]

 */

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
				if (i > 0 && candidates[i] == candidates[i - 1])
					continue;
				current.add(candidates[i]);
				dfs(candidates, target, current, i, partialSum + candidates[i],
						result);
				current.remove(current.size() - 1);
			}
		}
	}
}
