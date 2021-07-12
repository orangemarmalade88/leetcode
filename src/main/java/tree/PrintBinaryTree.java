package tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class PrintBinaryTree {
	/*
	 * Given the root of a binary tree, construct a 0-indexed m x n string
	 * matrix res that represents a formatted layout of the tree. The formatted
	 * layout matrix should be constructed using the following rules:
	 * 
	 * The height of the tree is height and the number of rows m should be equal
	 * to height + 1. The number of columns n should be equal to 2height+1 - 1.
	 * Place the root node in the middle of the top row (more formally, at
	 * location res[0][(n-1)/2]). For each node that has been placed in the
	 * matrix at position res[r][c], place its left child at
	 * res[r+1][c-2height-r-1] and its right child at res[r+1][c+2height-r-1].
	 * Continue this process until all the nodes in the tree have been placed.
	 * Any empty cells should contain the empty string "". Return the
	 * constructed matrix res.
	 * 
	 * 
	 */
	public List<List<String>> printTree(TreeNode root) {
		List<List<String>> res = new ArrayList<>();
		int height = height(root);
		int rows = height + 1;
		int cols = (int) Math.pow(2, height + 1) - 1;

		for (int i = 0; i < rows; i++) {
			List<String> ro = new ArrayList<>();
			for (int j = 0; j < cols; j++) {
				ro.add("");
			}
			res.add(ro);
		}
		populate(root, 0, (cols - 1) / 2, height, res);
		return res;
	}

	private void populate(TreeNode root, int r, int c, int height,
			List<List<String>> res) {
		if (root == null)
			return;
		res.get(r).set(c, String.valueOf(root.val));
		populate(root.left, r + 1, c - (int) Math.pow(2, height - r - 1),
				height, res);
		populate(root.right, r + 1, c + (int) Math.pow(2, height - r - 1),
				height, res);
	}

	private int height(TreeNode root) {
		if (root == null)
			return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}
