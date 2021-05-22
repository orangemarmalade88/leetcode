package tree.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import model.Node;

public class NaryTreePreorderTraversal {
	/*
	 * Given the root of an n-ary tree, return the preorder traversal of its
	 * nodes' values.
	 *
	 * Nary-Tree input serialization is represented in their level order
	 * traversal. Each group of children is separated by the null value (See
	 * examples)
	 *
	 *
	 */
	public List<Integer> preorder(Node root) {
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node n = stack.pop();
			l.add(n.val);
			for (int i = n.children.size() - 1; i >= 0; i--) {
				stack.push(n.children.get(i));
			}
		}
		return l;
	}
}
