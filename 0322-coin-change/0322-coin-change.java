class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
            }
        }
        for(int i=0; i<=m; i++) {
            dp[i][0] = 0;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[m][n] < Integer.MAX_VALUE/2 ? dp[m][n] : -1; 
    }
}