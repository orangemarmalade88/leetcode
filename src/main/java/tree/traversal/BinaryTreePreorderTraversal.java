package tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import model.TreeNode;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		preorderTraversal(root, l);
		return l;
	}

	public void preorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		Deque<TreeNode> q = new ArrayDeque<>();
		q.push(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.pop();
			l.add(cur.val);
			if (cur.right != null)
				q.push(cur.right);
			if (cur.left != null)
				q.push(cur.left);
		}
		return l;
	}
}
