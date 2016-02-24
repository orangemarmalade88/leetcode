package math.combination.numbers;

import java.util.ArrayList;
import java.util.List;

/*

 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 */

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(1, n, k, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfs(int start, int n, int k, List<Integer> current,
			List<List<Integer>> result) {
		if (current.size() == k) {
			result.add(new ArrayList<>(current)); // CAREFUL HERE
		} else {
			for (int i = start; i <= n; i++) {
				current.add(i);
				dfs(i + 1, n, k, current, result);
				current.remove(current.size() - 1);
			}
		}
	}
}
