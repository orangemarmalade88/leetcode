package tree;

import model.TreeNode;

public class SubtreeofAnotherTree {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (equalTree(root, subRoot))
			return true;
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean equalTree(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;
		if (a.val != b.val)
			return false;
		return equalTree(a.left, b.left) && equalTree(a.right, b.right);
	}
}
