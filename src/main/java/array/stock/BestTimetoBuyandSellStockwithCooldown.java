package array.stock;

class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int held = Integer.MIN_VALUE;
        int cd = Integer.MIN_VALUE;
        int empty = 0;
        for (int i : prices) {
            int prev_held = held;
            int prev_cd = cd;
            int prev_empty = empty;
            held = Math.max(prev_held, prev_empty-i);
            cd = prev_held + i;
            empty = Math.max(prev_empty, prev_cd);
        }
        return Math.max(0, Math.max(cd, empty));
    }
}