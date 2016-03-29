package tree;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inPosition = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inPosition.put(inorder[i], i);
		}
		return buildTree(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1, inPosition);
	}

	private TreeNode buildTree(int[] inorder, int[] postorder, int inStart,
			int inEnd, int postStart, int postEnd,
			Map<Integer, Integer> inPosition) {
		if (inStart > inEnd || postStart > postEnd)
			return null;

		int rootV = postorder[postEnd];
		int inIndex = inPosition.get(rootV);

		TreeNode root = new TreeNode(rootV);
		root.left = buildTree(inorder, postorder, inStart, inIndex - 1,
				postStart, postStart + inIndex - 1 - inStart, inPosition);
		root.right = buildTree(inorder, postorder, inIndex + 1, inEnd,
				postStart + inIndex - inStart, postEnd - 1, inPosition);
		return root;

	}
}
