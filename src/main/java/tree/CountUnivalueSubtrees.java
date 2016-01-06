package tree;

import model.TreeNode;

/*

 Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,

 5
 / \
 1   5
 / \   \
 5   5   5

 return 4.

 */

public class CountUnivalueSubtrees {

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;

		int leftC = countUnivalSubtrees(root.left);
		int rightC = countUnivalSubtrees(root.right);

		return leftC + rightC + (isUnivalTree(root) ? 1 : 0);
	}

	public boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return false;

		boolean left = root.left == null
				|| (isUnivalTree(root.left) && root.val == root.left.val);
		boolean right = root.right == null
				|| (isUnivalTree(root.right) && root.val == root.right.val);

		return left && right;
	}

	// Improvement, redundant visits O(NlgN), now improved to be O(N)
	// Use a new structure to return 2 variables
	public class Info {
		boolean isUnivalue;
		int count;

		public Info(boolean isUnivalue, int count) {
			this.isUnivalue = isUnivalue;
			this.count = count;
		}
	}

	public int countUnivalSubtrees2(TreeNode root) {
		return count(root).count;
	}

	public Info count(TreeNode root) {
		if (root == null)
			return new Info(false, 0);

		Info leftInfo = count(root.left);
		boolean left = root.left == null
				|| (leftInfo.isUnivalue && root.val == root.left.val);

		Info rightInfo = count(root.right);
		boolean right = root.right == null
				|| (rightInfo.isUnivalue && root.val == root.right.val);

		boolean rootB = left && right;
		int rootC = leftInfo.count + rightInfo.count + (rootB ? 1 : 0);

		return new Info(rootB, rootC);
	}
}
