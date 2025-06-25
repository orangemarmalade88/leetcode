package array.stock;

class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int held = Integer.MIN_VALUE;
        int empty = 0;
        for (int i : prices) {
            int prev_held  = held;
            int prev_empty = empty;
            held = Math.max(prev_held, prev_empty - i);
            empty = Math.max(prev_empty, prev_held + i - fee);
        }        
    }
}