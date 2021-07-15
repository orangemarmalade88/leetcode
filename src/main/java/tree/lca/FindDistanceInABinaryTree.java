package tree.lca;

import model.TreeNode;

public class FindDistanceInABinaryTree {
	/*
	 * Given the root of a binary tree and two integers p and q, return the
	 * distance between the nodes of value p and value q in the tree.
	 * 
	 * The distance between two nodes is the number of edges on the path from
	 * one to the other.
	 * 
	 * 
	 */
	public int findDistance(TreeNode root, int p, int q) {
		TreeNode lca = lca(root, p, q);
		return findDistance(lca, p) + findDistance(lca, q);
	}

	public int findDistance(TreeNode root, int b) {
		if (root == null)
			return -1;
		if (root.val == b)
			return 0;
		int left = findDistance(root.left, b);
		int right = findDistance(root.right, b);
		if (left != -1)
			return left + 1;
		if (right != -1)
			return right + 1;
		return -1;
	}

	public TreeNode lca(TreeNode root, int p, int q) {
		if (root == null)
			return null;
		if (root.val == p || root.val == q)
			return root;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		if (left != null && right != null)
			return root;
		if (left != null)
			return left;
		return right;
	}
}
