class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;
        for(int i=prices.length - 1; i>=0; i--) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
        }
        return profit;
    }
}