package tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {

		List<TreeNode> res = new ArrayList<>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode n = new TreeNode(i);
					n.left = l;
					n.right = r;
					res.add(n);
				}
			}
		}
		return res;
	}
}
