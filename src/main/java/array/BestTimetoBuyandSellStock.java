package array;

/*

 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

 */

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int max_ending_here = 0;
		int max_until_here = 0;

		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			max_ending_here = Math.max(max_ending_here + diff, 0);
			max_until_here = Math.max(max_until_here, max_ending_here);
		}

		return max_until_here;
	}
}
