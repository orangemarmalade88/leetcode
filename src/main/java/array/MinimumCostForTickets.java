package array;

public class MinimumCostForTickets {
	int minCost = Integer.MAX_VALUE;

	public static int mincostTickets(int[] days, int[] costs) {
		int n = days.length;
		int[] dp = new int[n + 1]; // dp[i]: min cost from i -> end
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = costs[0] + dp[i + 1];

			int index7 = i;
			while (index7 < days.length && days[index7] < days[i] + 7) {
				index7++;
			}
			dp[i] = Math.min(dp[i], costs[1] + dp[index7]);

			int index30 = i;
			while (index30 < days.length && days[index30] < days[i] + 30) {
				index30++;
			}
			dp[i] = Math.min(dp[i], costs[2] + dp[index30]);
		}

		return dp[0];
	}

	public static void main(String[] args) {
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };
		mincostTickets(days, costs);
	}

}
