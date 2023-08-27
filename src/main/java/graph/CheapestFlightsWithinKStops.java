package graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst,
			int k) {
		int[][] costs = new int[n][n];
		for (int[] f : flights) {
			costs[f[0]][f[1]] = f[2];
		}

		Queue<int[]> q = new PriorityQueue<>((i1, i2) -> i1[2] - i2[2]);
		q.offer(new int[] { src, 0, 0 });

		int[] stops = new int[n];
		Arrays.fill(stops, Integer.MAX_VALUE);

		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int index = cur[0];
			int steps = cur[1];
			int cost = cur[2];

			if (index == dst) {
				if (cost < min)
					min = cost;
				continue;
			}
			if (steps == k + 1)
				continue;
			if (steps < stops[index]) {
				stops[index] = steps;
			} else {
				continue;
			}

			for (int j = 0; j < n; j++) {
				if (costs[index][j] > 0) {
					q.offer(new int[] { j, steps + 1, cost + costs[index][j] });
				}
			}

		}
		return min == Integer.MAX_VALUE ? -1 : min;

	}
}
