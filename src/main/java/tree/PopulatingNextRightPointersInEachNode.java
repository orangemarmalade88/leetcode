package tree;

import model.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		TreeLinkNode prev = null;
		TreeLinkNode nextHead = null;
		while (root != null) {
			nextHead = root.left;
			if (nextHead == null)
				return;
			while (root != null) {
				if (prev != null) {
					prev.next = root.left;
				}
				root.left.next = root.right;
				prev = root.right;
				root = root.next;
			}
			root = nextHead;
			prev = null;
		}
	}
}
