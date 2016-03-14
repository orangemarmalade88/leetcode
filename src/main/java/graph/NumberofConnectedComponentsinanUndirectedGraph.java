package graph;

/*
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to find the number of connected components in an undirected graph.

 Example 1:

 0          3
 |          |
 1 --- 2    4


 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:

 0           4
 |           |
 1 --- 2 --- 3


 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 */

public class NumberofConnectedComponentsinanUndirectedGraph {
	// Union find approach
	public int countComponents(int n, int[][] edges) {
		int[] root = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			root[i] = i;
			count++;
		}

		for (int[] edge : edges) {
			int rootx = find(edge[0], root);
			int rooty = find(edge[1], root);
			if (rootx != rooty) {
				root[rootx] = rooty;
				count--;
			}
		}
		return count;
	}

	private int find(int x, int[] root) {
		if (root[x] != x) {
			root[x] = find(root[x], root);
		}
		return root[x];
	}

	// Union find approach
	public int countComponents2(int n, int[][] edges) {
		boolean[][] adj = adjacencyGraph(n, edges);
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(adj, i, visited);
				count++;
			}
		}
		return count;
	}

	private void dfs(boolean[][] adj, int i, boolean[] visited) {
		visited[i] = true;
		for (int j = 0; j < visited.length; j++) {
			if (adj[i][j] && !visited[j])
				dfs(adj, j, visited);
		}
	}

	private boolean[][] adjacencyGraph(int n, int[][] edges) {
		boolean[][] adj = new boolean[n][n];
		for (int[] edge : edges) {
			adj[edge[0]][edge[1]] = true;
			// Mistake: Add both directions for undirected graph
			adj[edge[1]][edge[0]] = true;
		}
		return adj;
	}
}
