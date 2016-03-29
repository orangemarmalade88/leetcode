package tree;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

/*

 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inPosition = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inPosition.put(inorder[i], i);
		}

		return buildTree(preorder, inorder, 0, preorder.length - 1, 0,
				inorder.length - 1, inPosition);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int preStart,
			int preEnd, int inStart, int inEnd, Map<Integer, Integer> inPosition) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int rootV = preorder[preStart];
		int inIndex = inPosition.get(rootV);

		TreeNode root = new TreeNode(rootV);
		root.left = buildTree(preorder, inorder, preStart + 1, preStart
				+ (inIndex - inStart), inStart, inIndex - 1, inPosition);
		root.right = buildTree(preorder, inorder, preStart
				+ (inIndex - inStart + 1), preEnd, inIndex + 1, inEnd,
				inPosition);
		return root;
	}
}
