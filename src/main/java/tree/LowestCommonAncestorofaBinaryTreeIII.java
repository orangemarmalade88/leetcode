package tree;

import model.Node;

public class LowestCommonAncestorofaBinaryTreeIII {
	public Node lowestCommonAncestor(Node p, Node q) {
		int sp = getHeight(p);
		int sq = getHeight(q);
		while (sp > sq) {
			p = p.parent;
			sp--;
		}
		while (sq > sp) {
			q = q.parent;
			sq--;
		}
		while (p != q) {
			p = p.parent;
			q = q.parent;
		}
		return p;
	}

	private int getHeight(Node p) {
		int h = 0;
		while (p != null) {
			p = p.parent;
			h++;
		}
		return h;
	}
}
