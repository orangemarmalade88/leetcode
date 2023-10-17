package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import model.TreeNode;

public class AllNodesDistanceKinBinaryTree {

	Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();

	public void buildGraph(TreeNode parent, TreeNode root) {
		if (root == null)
			return;
		Set<TreeNode> s = new HashSet<>();
		if (parent != null)
			s.add(parent);
		if (root.left != null)
			s.add(root.left);
		if (root.right != null)
			s.add(root.right);
		graph.put(root, s);
		buildGraph(root, root.left);
		buildGraph(root, root.right);
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		buildGraph(null, root);
		Queue<TreeNode> q = new LinkedList<>();
		Set<TreeNode> visited = new HashSet<>();
		q.offer(target);
		visited.add(target);
		List<Integer> res = new ArrayList<>();
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode cur = q.poll();
				Set<TreeNode> nei = graph.get(cur);
				if (nei != null) {
					for (TreeNode t : nei) {
						if (!visited.contains(t)) {
							q.offer(t);
							visited.add(t);
						}
					}
				}
				if (k == 0) {
					res.add(cur.val);
				}
			}
			if (k == 0)
				return res;
			k--;
		}
		return res;
	}
}
