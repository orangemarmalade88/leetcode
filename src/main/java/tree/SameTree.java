package tree;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;

public class SameTree {
	/*
	 * Given the roots of two binary trees p and q, write a function to check if
	 * they are the same or not.
	 * 
	 * Two binary trees are considered the same if they are structurally
	 * identical, and the nodes have the same value.
	 * 
	 * 
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null) {
			if (p.val != q.val)
				return false;
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}

	public boolean isSameTree2(TreeNode p, TreeNode q) {
		Deque<TreeNode> left = new LinkedList<>();
		Deque<TreeNode> right = new LinkedList<>();
		left.push(p);
		right.push(q);

		while (!left.isEmpty() || !right.isEmpty()) {
			TreeNode l = left.pop();
			TreeNode r = right.pop();
			if (l == null && r == null)
				continue;
			if (l == null || r == null)
				return false;
			if (l.val != r.val)
				return false;
			left.push(l.left);
			left.push(l.right);
			right.push(r.left);
			right.push(r.right);
		}
		return true;
	}
}
