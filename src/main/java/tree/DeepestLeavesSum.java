package tree;

import java.util.LinkedList;

public class DeepestLeavesSum {
	/*
	 * Given the root of a binary tree, return the sum of values of its deepest
	 * leaves.
	 * 
	 */
	public int deepestLeavesSum(TreeNode root) {
		List<TreeNode> cur = new LinkedList<>();
		List<TreeNode> next = new LinkedList<>();
		next.add(root);

		while (!next.isEmpty()) {
			cur.clear();
			cur.addAll(next);
			next.clear();
			for (TreeNode c : cur) {
				if (c.left != null) {
					next.add(c.left);
				}
				if (c.right != null) {
					next.add(c.right);
				}
			}
		}

		int s = 0;
		for (TreeNode c : cur) {
			s += c.val;
		}
		return s;
	}
}
