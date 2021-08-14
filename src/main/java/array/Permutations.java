package array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, nums, visited, new ArrayList<>());
		return res;
	}

	public void dfs(List<List<Integer>> res, int[] nums, boolean[] visited,
			List<Integer> cur) {
		if (cur.size() == visited.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				cur.add(nums[i]);
				dfs(res, nums, visited, cur);
				cur.remove(cur.size() - 1);
				visited[i] = false;
			}
		}
	}
}
