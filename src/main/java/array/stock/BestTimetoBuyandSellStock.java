package array.stock;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int p : prices) {
			if (p <= min) {
				min = p;
			} else
				max = Math.max(max, p - min);
		}
		return max;
	}
}