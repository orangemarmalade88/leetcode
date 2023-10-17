package tree;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

public class SmallestSubtreewithalltheDeepestNodes {
	Map<TreeNode, Integer> map = new HashMap<>();

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		calHeight(root);
		return helper(root);
	}

	public TreeNode helper(TreeNode root) {
		if (root == null)
			return null;
		int hl = map.getOrDefault(root.left, 0);
		int hr = map.getOrDefault(root.right, 0);
		if (hl == hr)
			return root;
		if (hl < hr)
			return helper(root.right);
		return helper(root.left);
	}

	public int calHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int val = Math.max(calHeight(root.left), calHeight(root.right)) + 1;
		map.put(root, val);
		return val;
	}
}
