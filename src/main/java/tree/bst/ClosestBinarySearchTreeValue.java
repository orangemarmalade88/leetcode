package tree.bst;

import model.TreeNode;

/*

 Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:

 -Given target value is a floating point.
 -You are guaranteed to have only one unique value in the BST that is closest to the target.

 */

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		int value = root.val;
		double diff = Math.abs(target - value);
		if (value < target) {
			int temp;
			if (root.right != null
					&& Math.abs(target
							- (temp = closestValue(root.right, target))) < diff)
				value = temp;
		}
		if (value > target) {
			int temp;
			if (root.left != null
					&& Math.abs(target
							- (temp = closestValue(root.left, target))) < diff)
				value = temp;
		}
		return value;
	}

}
