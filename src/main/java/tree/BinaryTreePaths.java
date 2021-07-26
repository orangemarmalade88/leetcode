package tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class BinaryTreePaths {
	/*
	 * Given the root of a binary tree, return all root-to-leaf paths in any
	 * order.
	 * 
	 * A leaf is a node with no children.
	 * 
	 * 
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		print(root, new StringBuilder(), res);
		return res;
	}

	public void print(TreeNode cur, StringBuilder sb, List<String> res) {
		if (cur.left == null && cur.right == null) {
			sb.append(cur.val);
			res.add(sb.toString());
		}
		if (cur.left != null) {
			StringBuilder left = new StringBuilder(sb);
			left.append(cur.val).append("->");
			print(cur.left, left, res);
		}
		if (cur.right != null) {
			StringBuilder right = new StringBuilder(sb);
			right.append(cur.val).append("->");
			print(cur.right, right, res);
		}
	}
}
