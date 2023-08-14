package tree;

import java.util.LinkedList;
import java.util.Queue;

import model.TreeNode;

public class CheckCompletenessofaBinaryTree {
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean hasEmpty = false;
		while (!q.isEmpty()) {
			int size = q.size();

			while (size-- > 0) {
				TreeNode cur = q.poll();
				if (cur != null) {
					if (hasEmpty)
						return false;
					q.offer(cur.left);
					q.offer(cur.right);
				} else {
					hasEmpty = true;
				}
			}
		}
		return true;
	}
}
