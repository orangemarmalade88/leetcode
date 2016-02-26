package math.combination.numbers;

import java.util.ArrayList;
import java.util.List;

/*

 Numbers can be regarded as product of its factors. For example,
 8 = 2 x 2 x 2;
 = 2 x 4.


 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:

 1.Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 2.You may assume that n is always positive.
 3.Factors should be greater than 1 and less than n.


 Examples:
 input: 1
 output:

 []

 input: 37
 output:
 []

 input: 12
 output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]

 input: 32
 output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]

 */

public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(n, n, 2, new ArrayList<Integer>(), result);
		return result;
	}

	private void dfs(int n, int target, int start, List<Integer> current,
			List<List<Integer>> result) {
		if (target == 1) {
			result.add(new ArrayList<>(current));
		} else {
			for (int i = start; i <= target; i++) {
				if (target % i == 0 && i != n) {
					current.add(i);
					dfs(n, target / i, i, current, result);
					current.remove(current.size() - 1);
				}
			}
		}
	}
}
