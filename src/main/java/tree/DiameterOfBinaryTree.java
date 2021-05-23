package tree;

import model.TreeNode;

public class DiameterOfBinaryTree {
	/*
	 * Given the root of a binary tree, return the length of the diameter of the
	 * tree.
	 *
	 * The diameter of a binary tree is the length of the longest path between
	 * any two nodes in a tree. This path may or may not pass through the root.
	 *
	 * The length of a path between two nodes is represented by the number of
	 * edges between them.
	 *
	 *
	 */
	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return diameter;
	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		int d = left + right;
		diameter = Math.max(diameter, d);

		return Math.max(left, right) + 1;
	}
}
