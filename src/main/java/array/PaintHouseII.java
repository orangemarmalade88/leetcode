package array;

/*

 There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

 Note:
 All costs are positive integers.

 Follow up:
 Could you solve it in O(nk) runtime?

 */

public class PaintHouseII {
	public int minCostII(int[][] costs) {
		int houses = costs.length;
		if (houses == 0)
			return costs[0][0];

		int colors = costs[0].length;

		int[][] dp = new int[houses + 1][colors];
		for (int i = 0; i < houses; i++) {
			for (int c = 0; c < colors; c++) {
				int min = Integer.MAX_VALUE;
				for (int other = 0; other < colors; other++) {
					if (other == c)
						continue;
					min = Math.min(min, dp[i][other]);
				}
				dp[i + 1][c] = min + costs[i][c];
			}
		}

		int globalMin = Integer.MAX_VALUE;
		for (int c = 0; c < colors; c++) {
			globalMin = Math.min(globalMin, dp[houses][c]);
		}
		return globalMin;
	}
}
