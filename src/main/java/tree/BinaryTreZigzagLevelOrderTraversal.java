package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.TreeNode;

public class BinaryTreZigzagLevelOrderTraversal {
	/*
	 * Given the root of a binary tree, return the zigzag level order traversal
	 * of its nodes' values. (i.e., from left to right, then right to left for
	 * the next level and alternate between).
	 *
	 *
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean order = true;
		while (!q.isEmpty()) {
			int size = q.size();
			LinkedList<Integer> l = new LinkedList<>();
			while (size > 0) {
				TreeNode cur = q.poll();
				if (order) {
					l.addLast(cur.val);
				} else {
					l.addFirst(cur.val);
				}
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
				size--;
			}
			res.add(l);
			order = !order;
		}
		return res;
	}

}
