package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.TreeNode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int depth = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode cur = q.poll();
				if (cur.left == null && cur.right == null)
					return depth;
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
			}
			depth++;
		}
		return -1;
	}
}
