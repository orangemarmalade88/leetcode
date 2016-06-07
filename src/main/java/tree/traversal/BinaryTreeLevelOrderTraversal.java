package tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.TreeNode;

/*

 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7



 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]

 */

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null)
			queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				temp.add(n.val);
				if (n.left != null)
					queue.offer(n.left);
				if (n.right != null)
					queue.offer(n.right);
			}
			result.add(temp);
		}
		return result;
	}
}
