package math.combination.numbers;

import java.util.ArrayList;
import java.util.List;

/*

 Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]

 */

public class CombinationSumIII {

	// Other thoughts:
	// if only want # of solutions, use DP + dfs

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(k, n, 0, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfs(int k, int target, int num, List<Integer> current,
			List<List<Integer>> result) {
		if (target < 0) {
			return;
		} else if (k == 0) {
			if (target == 0) {
				result.add(new ArrayList<>(current));
			} else {
				return;
			}
		} else {
			for (int i = num + 1; i <= 9; i++) {
				current.add(i);
				dfs(k - 1, target - i, i, current, result);
				current.remove(current.size() - 1);
			}
		}
	}
}
