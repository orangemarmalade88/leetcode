package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.TreeNode;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		q.offer(root);
		int last = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode cur = q.poll();
				last = cur.val;
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
			}
			l.add(last);
		}
		return l;
	}
}
