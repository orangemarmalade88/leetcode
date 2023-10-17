package tree;

import model.TreeNode;

public class LowestCommonAncestorofaBinaryTree {
	TreeNode ans;

	// only one node will have p and q in different branch (or itself)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		helper(root, p, q);
		return ans;
	}

	// return true if you can find p or q under root
	public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return false;

		boolean left = helper(root.left, p, q);
		boolean right = helper(root.right, p, q);

		boolean cur = p == root || q == root;

		if (left && right || (cur && (left || right))) {
			ans = root;
		}

		return left || right || cur;
	}
}
