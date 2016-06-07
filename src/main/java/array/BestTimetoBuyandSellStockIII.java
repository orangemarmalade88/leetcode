package array;

/*

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {

		if (prices.length <= 1)
			return 0;

		int[] start = new int[prices.length];

		int max_ending_here = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			max_ending_here = Math.max(max_ending_here + diff, 0);
			start[i] = Math.max(max_ending_here, start[i - 1]);
		}

		int[] end = new int[prices.length];
		int max_starting_here = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			int diff = prices[i + 1] - prices[i];
			max_starting_here = Math.max(max_starting_here + diff, 0);
			end[i] = Math.max(max_starting_here, end[i + 1]);
		}

		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, start[i] + end[i]);
		}
		return max;
	}
}
