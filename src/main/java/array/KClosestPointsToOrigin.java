package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	// O(NlogK)
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(k,
				new Comparator<int[]>() {
					@Override
					public int compare(int[] h1, int[] h2) {
						return -h1[0] * h1[0] - h1[1] * h1[1] + h2[0] * h2[0]
								+ h2[1] * h2[1];
					}
				});
		for (int i = 0; i < points.length; i++) {
			pq.offer(points[i]);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}
		return res;
	}

	// Method 2: Quick Select
}
