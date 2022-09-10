class Solution {
    int maxTotal = 0;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k >= n/2){
             int ans = 0;
              for(int i = 1 ; i < n ; i++){
                  if(prices[i] > prices[i-1]){
                      ans += prices[i] - prices[i - 1];
                  }
              }
              return ans;
         }
        int[][][] dp = new int[101][1001][2];
        for(int i=0; i<101; i++) {
            for(int j=0; j<1001; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return recurse(k, prices, 0, 0, 0, dp);
        //return maxTotal;
    }
    
    public int recurse(int k, int[] arr, int start, int state, int buy, int[][][] dp) {
        if(k <= 0 || start >= arr.length) return 0;
        if(dp[k][start][state] != -1) return dp[k][start][state];
        int total = 0;
        for(int i=start; i<arr.length; i++) {
            if(state == 0) {
                total = Math.max(total, recurse(k, arr, i + 1, 1, arr[i], dp));
            } else if(state == 1) {
                if(arr[i] > buy) total = Math.max(arr[i] - buy + recurse(k - 1, arr, i, 0, buy, dp), total);
            }
        }
        dp[k][start][state] = total;
        return total;
    }
}