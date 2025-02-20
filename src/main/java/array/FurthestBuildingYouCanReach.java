package array;

import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach {

	// O(NlogN), have a couple alternative solutions, skipped for now.
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		int n = heights.length;
		int[] diff = new int[n];
		for (int i = 1; i < n; i++) {
			diff[i] = heights[i] - heights[i - 1];
		}
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 1; i < n; i++) {
			if (diff[i] > 0) {
				if (q.size() < ladders)
					q.offer(diff[i]);
				else if (!q.isEmpty() && diff[i] > q.peek()) {
					q.offer(diff[i]);
					bricks -= q.poll();
					if (bricks < 0)
						return i - 1;
				} else {
					bricks -= diff[i];
					if (bricks < 0)
						return i - 1;
				}
			}
		}
		return n - 1;
	}
}
