package tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		return null;
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public void binaryTreePaths(TreeNode root, String currentPath,
			List<String> result) {
		currentPath += "->" + root.val;
		if (isLeaf(root))
			result.add(currentPath);
		else {
			if (root.left != null)
				binaryTreePaths(root.left, currentPath, result);
			if (root.right != null)
				binaryTreePaths(root.right, currentPath, result);
		}

	}
}
