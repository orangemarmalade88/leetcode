package tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class PathSumII {
	/*
	 * Given the root of a binary tree and an integer targetSum, return all
	 * root-to-leaf paths where each path's sum equals targetSum.
	 *
	 * A leaf is a node with no children.
	 *
	 *
	 *
	 *
	 */
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return res;
		List<Integer> new_path = new ArrayList<>();
		new_path.add(root.val);
		pathSum(root, root.val, targetSum, new_path);
		return res;
	}

	public void pathSum(TreeNode root, int curSum, int targetSum,
			List<Integer> curPath) {
		if (root.left == null && root.right == null) {
			if (curSum == targetSum) {
				res.add(curPath);
			}
			return;
		}
		if (root.left != null) {
			List<Integer> new_path = new ArrayList<>(curPath);
			new_path.add(root.left.val);
			pathSum(root.left, curSum + root.left.val, targetSum, new_path);
		}
		if (root.right != null) {
			List<Integer> new_path = new ArrayList<>(curPath);
			new_path.add(root.right.val);
			pathSum(root.right, curSum + root.right.val, targetSum, new_path);
		}
	}
}
