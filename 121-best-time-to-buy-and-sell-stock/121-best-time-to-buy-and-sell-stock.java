class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            max = Math.max(max, prices[i]);
            if(min > prices[i]) {
                min = prices[i];
                max = prices[i];
            }
            profit = Math.max(profit, max - min);
        }
        return profit;
    }
}