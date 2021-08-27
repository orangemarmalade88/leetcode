package graph;

public class IsGraphBipartite {
	boolean valid = true;

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];

		for (int start = 0; start < n; start++) {
			dfs(graph, color, start);

		}
		return valid;
	}

	void dfs(int[][] graph, int[] color, int index) {
		if (!valid)
			return;
		if (color[index] == 0)
			color[index] = 1;
		for (int i : graph[index]) {
			if (color[i] == 0) {
				color[i] = color[index] == 1 ? -1 : 1;
				dfs(graph, color, i);
			} else if (color[i] + color[index] != 0) {
				valid = false;
				return;
			}
		}
	}
}
