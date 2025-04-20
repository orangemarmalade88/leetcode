package tree;

import model.TreeNode;

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		gainFromNode(root);
		return max;
	}

	public int gainFromNode(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(gainFromNode(root.left), 0);
		int right = Math.max(gainFromNode(root.right), 0);
		int gain = left + right + root.val;
		max = Math.max(gain, max);
		return Math.max(left + root.val, right + root.val);
	}
}
