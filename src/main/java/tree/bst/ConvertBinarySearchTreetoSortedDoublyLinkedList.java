package tree.bst;

import model.Node;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

	Node first = null;
	Node prev = null;

	public Node treeToDoublyList(Node root) {
		if (root == null)
			return root;
		dfs(root);
		first.left = prev;
		prev.right = first;
		return first;
	}

	public void dfs(Node root) {
		if (root == null)
			return;
		dfs(root.left);
		if (prev == null) {
			first = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		dfs(root.right);
	}
}
