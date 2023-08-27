package tree.bst;

import model.TreeNode;

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int closest = root.val;
		double diff = Math.abs(target - closest);
		while (root != null) {
			double dist = Math.abs(target - root.val);
			if (dist < diff || (dist == diff && root.val < closest)) {
				diff = dist;
				closest = root.val;
			}
			if (root.val > target) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return closest;
	}
}
