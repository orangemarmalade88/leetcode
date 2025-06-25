package math;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, new ArrayList<>(), result);
		return result;
	}

	public void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	// 1, 2, 3
	public void dfs(int[] nums, int index, List<Integer> cur,
			List<List<Integer>> result) {
		if (cur.size() == nums.length) {
			result.add(cur);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, index, i);
			List<Integer> next = new ArrayList<>(cur);
			next.add(nums[index]);
			dfs(nums, index + 1, next, result);
			swap(nums, index, i);
		}

	}
}
