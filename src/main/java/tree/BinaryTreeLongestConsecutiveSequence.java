package tree;

import model.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

	public int longestConsecutive(TreeNode root) {
		return longest(root)[1];
	}

	int[] longest(TreeNode root) {
		if (root == null)
			return new int[] { 0, 0 };

		int longestConsecutiveWithRoot = 1;
		int longestConsecutive = 1;

		if (root.left != null) {
			int[] maxs = longest(root.left);
			if (root.val == root.left.val - 1) {
				longestConsecutiveWithRoot = Math.max(
						longestConsecutiveWithRoot, maxs[0] + 1);
			}
			longestConsecutive = Math.max(longestConsecutiveWithRoot, maxs[1]);
		}

		if (root.right != null) {
			int[] maxs = longest(root.right);
			if (root.val == root.right.val - 1) {
				longestConsecutiveWithRoot = Math.max(
						longestConsecutiveWithRoot, maxs[0] + 1);
			}
			longestConsecutive = Math.max(
					Math.max(longestConsecutiveWithRoot, maxs[1]),
					longestConsecutive);
		}
		return new int[] { longestConsecutiveWithRoot, longestConsecutive };
	}
}
