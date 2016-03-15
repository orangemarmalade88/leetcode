package array;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

public class HouseRobberIII {

	public int rob0(TreeNode root) {
		int[] result = robR(root);
		return Math.max(result[0], result[1]);
	}

	private int[] robR(TreeNode root) {
		if (root == null)
			return new int[2];
		int[] left = robR(root.left);
		int[] right = robR(root.right);
		return new int[] { root.val + left[1] + right[1],
				Math.max(left[0], left[1]) + Math.max(right[0], right[1]) };
	}

	public int rob(TreeNode root) {
		return rob(root, new HashMap<TreeNode, Integer>());
	}

	private int rob(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) {
			return 0;
		}
		if (map.containsKey(root))
			return map.get(root);

		int val = 0;

		if (root.left != null) {
			val += rob(root.left.left, map) + rob(root.left.right, map);
		}

		if (root.right != null) {
			val += rob(root.right.left, map) + rob(root.right.right, map);
		}

		val = Math.max(val + root.val,
				rob(root.left, map) + rob(root.right, map));
		map.put(root, val);
		return val;
	}
}
