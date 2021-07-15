package tree.lca;

import java.util.HashSet;
import java.util.Set;

import model.TreeNode;

public class LowestCommonAncestorOfABinaryTreeIV {
	TreeNode lca = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		Set<TreeNode> s = new HashSet<>();
		for (TreeNode n : nodes) {
			s.add(n);
		}
		lca(root, s);
		return lca;
	}

	public int lca(TreeNode root, Set<TreeNode> s) {
		if (root == null)
			return 0;
		int left = lca(root.left, s);
		int right = lca(root.right, s);
		int total = left + right;
		if (s.contains(root))
			total++;
		if (total == s.size() && lca == null)
			lca = root;
		return total;
	}
}
