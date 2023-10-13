package tree;

import model.TreeNode;

public class HouseRobberIII {

	public int rob(TreeNode root) {
		int[] res = robH(root);
		return Math.max(res[0], res[1]);
	}

	public int[] robH(TreeNode root) {
		if (root == null)
			return new int[] { 0, 0 };
		int[] left = robH(root.left);
		int[] right = robH(root.right);
		int[] res = new int[2];
		res[0] = root.val + left[1] + right[1];
		res[1] = left[0] + right[0];
		return res;
	}
}
