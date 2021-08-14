package tree;

import model.TreeNode;

public class CountUnivalueSubtrees {
	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		count(root);
		return count;
	}

	public void count(TreeNode root) {
		if (root == null)
			return;
		if (isUniqueValue(root))
			count++;
		count(root.left);
		count(root.right);
	}

	public boolean isUniqueValue(TreeNode root) {
		if (root.left == null && root.right == null)
			return true;
		if (root.left != null) {
			if (root.left.val != root.val)
				return false;
			if (!isUniqueValue(root.left))
				return false;
		}
		if (root.right != null) {
			if (root.right.val != root.val)
				return false;
			if (!isUniqueValue(root.right))
				return false;
		}
		return true;
	}
}
