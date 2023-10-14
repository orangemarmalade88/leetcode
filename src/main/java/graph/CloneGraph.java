package graph;

import java.util.HashMap;
import java.util.Map;

import model.Node;

public class CloneGraph {
	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Map<Node, Node> map = new HashMap<>();
		Node root = new Node(node.val);
		map.put(node, root);
		dfs(node, root, map);
		return root;
	}

	public void dfs(Node old, Node cur, Map<Node, Node> map) {
		for (Node n : old.neighbors) {
			if (!map.containsKey(n)) {
				Node next = new Node(n.val);
				map.put(n, next);
				dfs(n, next, map);
			}
			cur.neighbors.add(map.get(n));
		}
	}
}
