package array.stock;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[] left = new int[n];
		int left_min = Integer.MAX_VALUE;
		int leftp_max = 0;
		for (int i = 0; i < n; i++) {
			if (prices[i] <= left_min)
				left_min = prices[i];
			else {
				leftp_max = Math.max(leftp_max, prices[i] - left_min);
			}
			left[i] = leftp_max;
		}

		int[] right = new int[n + 1];
		int right_max = 0;
		int rightp_max = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (prices[i] >= right_max)
				right_max = prices[i];
			else {
				rightp_max = Math.max(rightp_max, right_max - prices[i]);
			}
			right[i] = rightp_max;
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(left[i] + right[i + 1], max);
		}
		return max;
	}
}
