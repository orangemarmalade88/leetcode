package graph;

public class NumberofProvinces {
	int n;

	public int findCircleNum(int[][] isConnected) {
		n = isConnected.length;
		int count = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(isConnected, visited, i);
				count++;
			}

		}
		return count;
	}

	public void dfs(int[][] isConnected, boolean[] visited, int index) {
		visited[index] = true;
		for (int i = 0; i < n; i++) {
			if (isConnected[i][index] == 1 && !visited[i])
				dfs(isConnected, visited, i);
		}
	}
}
