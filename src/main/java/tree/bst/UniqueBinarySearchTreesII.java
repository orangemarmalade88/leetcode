package tree.bst;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/*

 Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.
 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 */

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0)
			return new ArrayList<>();
		return buildTree(1, n);
	}

	private List<TreeNode> buildTree(int begin, int end) {

		List<TreeNode> result = new ArrayList<>();

		if (begin > end) {
			result.add(null);
		}

		for (int i = begin; i <= end; i++) {
			List<TreeNode> lefts = buildTree(begin, i - 1);
			List<TreeNode> rights = buildTree(i + 1, end);

			for (TreeNode l : lefts) {
				for (TreeNode r : rights) {
					TreeNode current = new TreeNode(i);
					current.left = l;
					current.right = r;
					result.add(current);
				}
			}
		}
		return result;
	}

}
