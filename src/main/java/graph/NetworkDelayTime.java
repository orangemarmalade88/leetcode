package graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
	public static int networkDelayTime(int[][] times, int n, int k) {
		int[][] graph = new int[n + 1][n + 1];
		boolean[][] exist = new boolean[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int[] time : times) {
			graph[time[0]][time[1]] = time[2];
			exist[time[0]][time[1]] = true;
		}

		int t = 0;
		int visit_count = 0;

		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		pq.add(new int[] { 0, k });
		while (!pq.isEmpty()) {
			int[] head = pq.poll();
			int cur = head[1];
			if (visited[cur]) {
				continue;
			}
			t = head[0];
			visited[cur] = true;
			visit_count++;
			if (visit_count == n)
				return t;
			for (int i = 1; i <= n; i++) {
				// Mistake: edge with 0 cost
				if (!visited[i] && graph[cur][i] >= 0 && exist[cur][i]) {
					pq.add(new int[] { t + graph[cur][i], i });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] input = { { 3, 5, 78 }, { 2, 1, 1 }, { 1, 3, 0 }, { 4, 3, 59 },
				{ 5, 3, 85 }, { 5, 2, 22 }, { 2, 4, 23 }, { 1, 4, 43 },
				{ 4, 5, 75 }, { 5, 1, 15 }, { 1, 5, 91 }, { 4, 1, 16 },
				{ 3, 2, 98 }, { 3, 4, 22 }, { 5, 4, 31 }, { 1, 2, 0 },
				{ 2, 5, 4 }, { 4, 2, 51 }, { 3, 1, 36 }, { 2, 3, 59 } };
		networkDelayTime(input, 5, 5);
	}
}
