package graph;

public class MaximalNetworkRank {
	/*
	 * There is an infrastructure of n cities with some number of roads
	 * connecting these cities. Each roads[i] = [ai, bi] indicates that there is
	 * a bidirectional road between cities ai and bi.
	 * 
	 * The network rank of two different cities is defined as the total number
	 * of directly connected roads to either city. If a road is directly
	 * connected to both cities, it is only counted once.
	 * 
	 * The maximal network rank of the infrastructure is the maximum network
	 * rank of all pairs of different cities.
	 * 
	 * Given the integer n and the array roads, return the maximal network rank
	 * of the entire infrastructure.
	 * 
	 * 
	 */
	public int maximalNetworkRank(int n, int[][] roads) {
		boolean[][] connected = new boolean[n][n];
		int[] degree = new int[n];
		for (int[] road : roads) {
			int i = road[0];
			int j = road[1];
			degree[i]++;
			degree[j]++;
			connected[i][j] = true;
			connected[j][i] = true;
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int rank = degree[i] + degree[j];
				if (connected[i][j])
					rank--;
				max = Math.max(max, rank);
			}
		}
		return max;
	}
}
