package tree;

import model.TreeNode;

public class PathSum {
	/*
	 * Given the root of a binary tree and an integer targetSum, return true if
	 * the tree has a root-to-leaf path such that adding up all the values along
	 * the path equals targetSum.
	 * 
	 * A leaf is a node with no children.
	 * 
	 * 
	 */
	// O(N)
	public boolean hasPathSum(TreeNode root, int targetSum) {
		return hasPathSum(root, 0, targetSum);
	}

	public boolean hasPathSum(TreeNode root, int cur, int target) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			return cur + root.val == target;
		}
		return hasPathSum(root.left, cur + root.val, target)
				|| hasPathSum(root.right, cur + root.val, target);

	}
}
