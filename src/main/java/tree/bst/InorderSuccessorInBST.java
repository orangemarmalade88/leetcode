package tree.bst;

import model.TreeNode;

public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (p.right != null) {
			p = p.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}

		TreeNode lastLeft = null;
		while (root.val != p.val) {
			if (root.val < p.val) {
				root = root.right;
			} else {
				lastLeft = root;
				root = root.left;
			}
		}
		return lastLeft;

	}
}
