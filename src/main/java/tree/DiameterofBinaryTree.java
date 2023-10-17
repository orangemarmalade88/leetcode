package tree;

import model.TreeNode;

public class DiameterofBinaryTree {

	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		getHeight(root);
		return max;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}
}
