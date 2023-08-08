package array;

import java.util.Arrays;

public class TwoCityScheduling {

	public static int twoCitySchedCost(int[][] costs) {
		int[] diff = new int[costs.length];
		int sum = 0;

		for (int i = 0; i < costs.length; i++) {
			sum += costs[i][0];
			diff[i] = costs[i][0] - costs[i][1];
		}

		Arrays.sort(diff);
		for (int j = costs.length - 1; j >= costs.length / 2; j--) {
			sum -= diff[j];
		}
		return sum;

	}

	public static void main(String[] args) {
		int[][] input = new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 },
				{ 184, 139 }, { 840, 118 }, { 577, 469 } };
		twoCitySchedCost(input);
	}
}
