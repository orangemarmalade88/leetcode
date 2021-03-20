package tree;

import model.TreeNode;

/* 865. Smallest Subtree with all the Deepest Nodes

Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.

 */

public class SmallestSubtreeWithAllTheDeepestNodes {
	// Could have used Pair to remove some duplicate calculation on depth.
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null)
			return root;
		if (root.left == null && root.right == null)
			return root;
		if (root.left == null)
			return subtreeWithAllDeepest(root.right);
		if (root.right == null)
			return subtreeWithAllDeepest(root.left);
		int depth_left = depth(root.left);
		int depth_right = depth(root.right);
		if (depth_left == depth_right)
			return root;
		else if (depth_left < depth_right)
			return subtreeWithAllDeepest(root.right);
		else
			return subtreeWithAllDeepest(root.left);
	}

	public int depth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			return 1 + Math.max(depth(root.left), depth(root.right));
		}
	}
}
