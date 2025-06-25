package tree;

import model.TreeNode;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null)
			return root;
		if (root.left == null) {
			return root;
		}
		TreeNode next = upsideDownBinaryTree(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		return next;
	}
}
