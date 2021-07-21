package tree;

import model.TreeNode;

public class CountGoodNodesInBinaryTree {
	/*
	 * Given a binary tree root, a node X in the tree is named good if in the
	 * path from root to X there are no nodes with a value greater than X.
	 *
	 * Return the number of good nodes in the binary tree.
	 *
	 *
	 *
	 *
	 */
	int goods = 0;

	public int goodNodes(TreeNode root) {
		dfs(root, -10000);
		return goods;
	}

	void dfs(TreeNode root, int max_so_far) {
		if (root == null)
			return;
		if (root.val >= max_so_far)
			goods++;
		int max = Math.max(root.val, max_so_far);
		dfs(root.left, max);
		dfs(root.right, max);
	}
}
