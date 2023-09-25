package tree;

import model.TreeNode;

public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return null;

		TreeNode t = new TreeNode(0);

		if (root1 == null) {
			t.left = mergeTrees(null, root2.left);
			t.right = mergeTrees(null, root2.right);
			t.val = root2.val;
		} else if (root2 == null) {
			t.left = mergeTrees(root1.left, null);
			t.right = mergeTrees(root1.right, null);
			t.val = root1.val;
		} else {
			t.left = mergeTrees(root1.left, root2.left);
			t.right = mergeTrees(root1.right, root2.right);
			t.val = root1.val + root2.val;
		}
		return t;

	}
}
