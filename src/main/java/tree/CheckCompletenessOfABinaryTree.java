package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.TreeNode;

public class CheckCompletenessOfABinaryTree {
	/*
	 * Given the root of a binary tree, determine if it is a complete binary
	 * tree.
	 *
	 * In a complete binary tree, every level, except possibly the last, is
	 * completely filled, and all nodes in the last level are as far left as
	 * possible. It can have between 1 and 2h nodes inclusive at the last level
	 * h.
	 *
	 *
	 */
	public boolean isCompleteTree(TreeNode root) {
		boolean found = false;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur == null)
				found = true;
			else {
				if (found)
					return false;
				q.offer(cur.left);
				q.offer(cur.right);
			}
		}
		return true;
	}
}
