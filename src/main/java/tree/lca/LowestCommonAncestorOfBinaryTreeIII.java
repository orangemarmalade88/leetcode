package tree.lca;

import model.Node;

public class LowestCommonAncestorOfBinaryTreeIII {
	public Node lowestCommonAncestor(Node p, Node q) {
		Node a = p;
		Node b = q;
		while (a != b) {
			a = a == null ? p : a.parent;
			b = b == null ? q : b.parent;
		}
		return a;
	}
}
