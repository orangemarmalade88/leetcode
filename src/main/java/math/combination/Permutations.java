package math.combination;

import java.util.ArrayList;
import java.util.List;

/*

 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

 */

public class Permutations {
	// Other thoughts:
	// Add each new number to all possible locations to all previous results
	// [1] -> [2 1] [1 2] -> [3 2 1] [2 3 1] [2 1 3] ...

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int n : nums) {
			list.add(n);
		}
		List<List<Integer>> result = new ArrayList<>();
		dfs(list, 0, result);
		return result;
	}

	private void dfs(List<Integer> array, int index, List<List<Integer>> result) {
		if (index >= array.size()) {
			List<Integer> list = new ArrayList<Integer>(array);
			result.add(list);
		} else {
			for (int i = index; i < array.size(); i++) {
				swap(array, index, i);
				dfs(array, index + 1, result);
				swap(array, index, i);
			}
		}
	}

	private void swap(List<Integer> array, int i, int j) {
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
}
