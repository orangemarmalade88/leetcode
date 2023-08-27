package graph;

public class GraphValidTree {
	public static boolean validTree(int n, int[][] edges) {
		boolean[] visited = new boolean[n];
		boolean[][] graph = new boolean[n][n];
		for (int[] edge : edges) {
			graph[edge[0]][edge[1]] = true;
			graph[edge[1]][edge[0]] = true;
		}

		if (!dfs(0, graph, visited))
			return false;

		for (int i = 0; i < n; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	public static boolean dfs(int i, boolean[][] graph, boolean[] visited) {
		visited[i] = true;
		for (int j = 0; j < visited.length; j++) {
			if (graph[i][j]) {
				if (visited[j])
					return false;
				if (!dfs(j, graph, visited))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] input = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int n = 5;
		validTree(n, input);
	}
}
