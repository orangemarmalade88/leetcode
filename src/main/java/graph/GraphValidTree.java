package graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		if (n == 0)
			return true;

		boolean[][] graph = new boolean[n][n];
		for (int[] edge : edges) {
			graph[edge[0]][edge[1]] = true;
			graph[edge[1]][edge[0]] = true;
		}

		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			visited[current] = true;
			for (int i = 0; i < n; i++) {
				if (graph[current][i]) {
					graph[current][i] = graph[i][current] = false;
					if (visited[i])
						return false;
					queue.offer(i);
				}
			}
		}

		for (boolean visit : visited) {
			if (!visit)
				return false;
		}

		return true;
	}
}
