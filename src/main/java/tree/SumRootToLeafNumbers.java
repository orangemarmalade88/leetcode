package tree;

import model.TreeNode;

public class SumRootToLeafNumbers {
	/*
	 * You are given the root of a binary tree containing digits from 0 to 9
	 * only.
	 *
	 * Each root-to-leaf path in the tree represents a number.
	 *
	 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
	 * Return the total sum of all root-to-leaf numbers. Test cases are
	 * generated so that the answer will fit in a 32-bit integer.
	 *
	 * A leaf node is a node with no children.
	 *
	 *
	 */
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	private int sumNumbers(TreeNode root, int v) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return v * 10 + root.val;
		return sumNumbers(root.left, v * 10 + root.val)
				+ sumNumbers(root.right, v * 10 + root.val);
	}
}
