package tree;

import model.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = null;
		TreeLinkNode prev = null;
		TreeLinkNode cur = root;

		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					}
					prev = cur.left;
					if (head == null)
						head = cur.left;
				}
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					}
					prev = cur.right;
					if (head == null)
						head = cur.right;
				}
				cur = cur.next;
			}
			cur = head;
			head = null;
			prev = null;
		}
	}
}
