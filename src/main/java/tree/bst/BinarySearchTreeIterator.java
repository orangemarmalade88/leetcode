package tree.bst;

import java.util.Stack;

import model.TreeNode;

public class BinarySearchTreeIterator {

	Stack<TreeNode> s = new Stack<>();

	public BinarySearchTreeIterator(TreeNode root) {
		s.push(root);
		helper();
	}

	private void helper() {
		while (s.peek().left != null) {
			s.push(s.peek().left);
		}
	}

	public int next() {
		TreeNode cur = s.pop();
		if (cur.right != null) {
			s.push(cur.right);
			helper();
		}
		return cur.val;
	}

	public boolean hasNext() {
		return s.size() > 0;
	}
}
