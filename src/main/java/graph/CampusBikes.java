package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBikes {
	/*
	 * On a campus represented as a 2D grid, there are N workers and M bikes,
	 * with N <= M. Each worker and bike is a 2D coordinate on this grid.
	 *
	 * Our goal is to assign a bike to each worker. Among the available bikes
	 * and workers, we choose the (worker, bike) pair with the shortest
	 * Manhattan distance between each other, and assign the bike to that
	 * worker. (If there are multiple (worker, bike) pairs with the same
	 * shortest Manhattan distance, we choose the pair with the smallest worker
	 * index; if there are multiple ways to do that, we choose the pair with the
	 * smallest bike index). We repeat this process until there are no available
	 * workers.
	 *
	 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2)
	 * = |p1.x - p2.x| + |p1.y - p2.y|.
	 *
	 * Return a vector ans of length N, where ans[i] is the index (0-indexed) of
	 * the bike that the i-th worker is assigned to.
	 *
	 *
	 */
	class Data {
		int worker;
		int bike;
		int distance;

		Data(int w, int b, int d) {
			this.worker = w;
			this.bike = b;
			this.distance = d;
		}
	}

	private final PriorityQueue<Data> queue = new PriorityQueue<>(
			new Comparator<>() {
				@Override
				public int compare(Data a, Data b) {
					if (a.distance != b.distance)
						return a.distance - b.distance;
					else if (a.worker != b.worker)
						return a.worker - b.worker;
					return a.bike - b.bike;
				}
			});

	private final Set<Integer> assigned_workers = new HashSet<>();
	private final Set<Integer> assigned_bikes = new HashSet<>();

	public int[] assignBikes(int[][] workers, int[][] bikes) {
		int[] ans = new int[workers.length];
		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int distance = Math.abs(workers[i][0] - bikes[j][0])
						+ Math.abs(workers[i][1] - bikes[j][1]);
				queue.add(new Data(i, j, distance));
			}
		}

		while (!queue.isEmpty()) {
			Data d = queue.poll();
			if (!assigned_workers.contains(d.worker)
					&& !assigned_bikes.contains(d.bike)) {
				ans[d.worker] = d.bike;
				assigned_workers.add(d.worker);
				assigned_bikes.add(d.bike);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] workers = { { 240, 446 }, { 745, 948 }, { 345, 136 },
				{ 341, 68 }, { 990, 165 }, { 165, 580 }, { 133, 454 },
				{ 113, 527 } };
		int[][] bikes = { { 696, 140 }, { 95, 393 }, { 935, 185 }, { 767, 205 },
				{ 387, 767 }, { 214, 960 }, { 804, 710 }, { 956, 307 } };

		CampusBikes c = new CampusBikes();
		c.assignBikes(workers, bikes);

	}
}
