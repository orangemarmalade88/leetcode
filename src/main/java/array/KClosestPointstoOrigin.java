package array;

public class KClosestPointstoOrigin {
	public int[][] kClosest(int[][] points, int k) {
		int[][] res = new int[k][2];
		quickSelectKLargest(points, 0, points.length - 1,
				points.length - k + 1);
		for (int i = 0; i < k; i++) {
			res[i][0] = points[i][0];
			res[i][1] = points[i][1];
		}
		return res;
	}

	public void swap(int[][] points, int i, int j) {
		int t1 = points[i][0];
		int t2 = points[i][1];
		points[i][0] = points[j][0];
		points[i][1] = points[j][1];
		points[j][0] = t1;
		points[j][1] = t2;
	}

	public boolean compare(int[][] points, int i, int j) {
		int dist1 = points[i][0] * points[i][0] + points[i][1] * points[i][1];
		int dist2 = points[j][0] * points[j][0] + points[j][1] * points[j][1];
		return dist1 < dist2;
	}

	public void quickSelectKLargest(int[][] points, int start, int end, int k) {

		int swap_index = start;
		for (int i = start; i < end; i++) {
			if (compare(points, i, end)) {
				swap(points, i, swap_index);
				swap_index++;
			}
		}

		swap(points, swap_index, end);
		if (k == end - swap_index + 1)
			return;
		if (k > end - swap_index + 1)
			quickSelectKLargest(points, start, swap_index - 1,
					k - (end - swap_index + 1));
		else
			quickSelectKLargest(points, swap_index + 1, end, k);
	}
}
