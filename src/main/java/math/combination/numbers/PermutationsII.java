package math.combination.numbers;

import java.util.ArrayList;
import java.util.List;

/*

 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].

 */

public class PermutationsII {
	// Other thoughts:
	// Use set to maintain uniqueness

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> input = new ArrayList<>();
		for (int n : nums) {
			input.add(n);
		}
		List<List<Integer>> result = new ArrayList<>();
		dfs(input, 0, result);
		return result;
	}

	private void dfs(List<Integer> input, int index, List<List<Integer>> result) {
		if (index >= input.size()) {
			List<Integer> temp = new ArrayList<>(input);
			result.add(temp);
		} else {
			for (int i = index; i < input.size(); i++) {
				if (skip(input, index, i))
					continue;
				swap(input, i, index);
				dfs(input, index + 1, result);
				swap(input, i, index);
			}
		}
	}

	private boolean skip(List<Integer> input, int index, int k) {
		for (int i = index; i < k; i++) {
			if (input.get(i).equals(input.get(k))) {
				return true;
			}
		}
		return false;
	}

	private void swap(List<Integer> input, int i, int j) {
		int temp = input.get(i);
		input.set(i, input.get(j));
		input.set(j, temp);
	}
}
