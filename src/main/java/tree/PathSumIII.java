package tree;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

public class PathSumIII {
	/*
	 * Given the root of a binary tree and an integer targetSum, return the
	 * number of paths where the sum of the values along the path equals
	 * targetSum.
	 * 
	 * The path does not need to start or end at the root or a leaf, but it must
	 * go downwards (i.e., traveling only from parent nodes to child nodes).
	 * 
	 * 
	 */

	// O(N)
	int count = 0;

	public int pathSum(TreeNode root, int targetSum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		pathSum(root, map, 0, targetSum);
		return count;
	}

	public void pathSum(TreeNode root, Map<Integer, Integer> map, int sum,
			int targetSum) {
		if (root == null)
			return;
		sum += root.val;
		if (map.containsKey(sum - targetSum)) {
			count += map.get(sum - targetSum);
		}
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		pathSum(root.left, map, sum, targetSum);
		pathSum(root.right, map, sum, targetSum);
		map.put(sum, map.get(sum) - 1);
	}
}
