package tree.bst;

import model.TreeNode;

public class ValidateBinarySearchTree {
	/*
	 * Given the root of a binary tree, determine if it is a valid binary search
	 * tree (BST).
	 * 
	 * A valid BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 * 
	 */
	// O(N)
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, Integer low, Integer high) {
		if (root == null)
			return true;

		if (low != null && root.val <= low)
			return false;

		if (high != null && root.val >= high)
			return false;

		return isValidBST(root.left, low, root.val)
				&& isValidBST(root.right, root.val, high);
	}
}
