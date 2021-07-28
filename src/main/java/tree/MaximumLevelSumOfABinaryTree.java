package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.TreeNode;

public class MaximumLevelSumOfABinaryTree {
	/*
	 * Given the root of a binary tree, the level of its root is 1, the level of
	 * its children is 2, and so on.
	 *
	 * Return the smallest level x such that the sum of all the values of nodes
	 * at level x is maximal.
	 *
	 *
	 */
	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int level = 1;
		int max_level = 1;
		int max = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			while (size-- > 0) {
				TreeNode cur = q.poll();
				sum += cur.val;
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
			}
			if (sum > max) {
				max_level = level;
				max = sum;
			}
			level++;
		}
		return max_level;
	}
}
