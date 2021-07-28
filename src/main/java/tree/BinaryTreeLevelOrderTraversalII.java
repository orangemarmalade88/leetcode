package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	/*
	 * Given the root of a binary tree, return the bottom-up level order
	 * traversal of its nodes' values. (i.e., from left to right, level by level
	 * from leaf to root).
	 *
	 *
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> l = new ArrayList<>();
			while (size-- > 0) {
				TreeNode cur = q.poll();
				l.add(cur.val);
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
			}
			res.addFirst(l);
		}
		return res;

	}
}
