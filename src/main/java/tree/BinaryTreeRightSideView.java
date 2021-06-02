package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import model.TreeNode;

public class BinaryTreeRightSideView {
	/*
	 * Given the root of a binary tree, imagine yourself standing on the right
	 * side of it, return the values of the nodes you can see ordered from top
	 * to bottom.
	 * 
	 * 
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			TreeNode last = null;
			while (size-- > 0) {
				TreeNode cur = q.poll();
				last = cur;
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
			}
			res.add(last.val);
		}
		return res;
	}
}
