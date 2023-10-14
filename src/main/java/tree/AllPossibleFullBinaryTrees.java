package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.TreeNode;

public class AllPossibleFullBinaryTrees {

	Map<Integer, List<TreeNode>> m = new HashMap<>();

	public List<TreeNode> allPossibleFBT(int n) {
		List<TreeNode> list = new ArrayList<>();
		n--;
		if (n % 2 != 0)
			return list;
		if (n == 0) {
			TreeNode node = new TreeNode(0);
			list.add(node);
			return list;
		}
		for (int i = 1; i < n; i = i + 2) {
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(n - i);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode node = new TreeNode(0);
					node.left = l;
					node.right = r;
					list.add(node);
				}
			}
		}
		return list;

	}
}
