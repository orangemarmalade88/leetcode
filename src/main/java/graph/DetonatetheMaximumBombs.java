package graph;

public class DetonatetheMaximumBombs {
	static int n;
	static int count = 0;

	public static int maximumDetonation(int[][] bombs) {
		n = bombs.length;
		boolean[][] connected = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				connected[i][j] = (long) (bombs[i][0] - bombs[j][0])
						* (bombs[i][0] - bombs[j][0])
						+ (long) (bombs[i][1] - bombs[j][1]) * (bombs[i][1]
								- bombs[j][1]) <= (long) (bombs[i][2])
										* (bombs[i][2]);
				connected[j][i] = (long) (bombs[i][0] - bombs[j][0])
						* (bombs[i][0] - bombs[j][0])
						+ (long) (bombs[i][1] - bombs[j][1]) * (bombs[i][1]
								- bombs[j][1]) <= (long) (bombs[j][2])
										* (bombs[j][2]);
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			count = 0;
			dfs(i, connected, visited);
			max = Math.max(max, count);
		}
		return max;
	}

	public static void dfs(int i, boolean[][] connected, boolean[] visited) {
		visited[i] = true;
		count++;
		for (int j = 0; j < n; j++) {
			if (!visited[j] && connected[i][j]) {
				dfs(j, connected, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = { { 1, 1, 100000 }, { 100000, 100000, 1 } };
		maximumDetonation(input);
	}
}
