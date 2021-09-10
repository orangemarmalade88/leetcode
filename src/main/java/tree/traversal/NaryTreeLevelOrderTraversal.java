package tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Node;

public class NaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();
			while (size-- > 0) {
				Node cur = q.poll();
				level.add(cur.val);
				for (Node n : cur.children) {
					q.offer(n);
				}
			}
			res.add(level);
		}
		return res;
	}
}
