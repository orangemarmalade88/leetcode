package array;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	public int maxPoints(int[][] points) {
		int max = 1;
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<>();
			int inf = 0;
			for (int j = i + 1; j < points.length; j++) {
				int y = points[j][1] - points[i][1];
				int x = points[j][0] - points[i][0];
				if (x == 0) {
					inf++;
					max = Math.max(max, inf + 1);
				} else {
					double slope = (double) y / (double) x;
					int count = map.getOrDefault(slope, 0) + 1;
					max = Math.max(max, count + 1);

					map.put(slope, count);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] points = { { 2, 3 }, { 3, 3 }, { -5, 3 } };
		MaxPointsOnALine m = new MaxPointsOnALine();
		m.maxPoints(points);
	}
}
