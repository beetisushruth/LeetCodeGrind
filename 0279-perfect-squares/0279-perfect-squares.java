class Solution {
    public int numSquares(int n) {
        int[] dp = new int[10001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=1; i<=100; i++) {
            dp[i*i] = 1;
        }
        for(int i=2; i<=n; i++) {
            if(dp[i] != 1) {
                for(int j=1; j<=i/2; j++){
                    dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
                }
            }
        }
        return dp[n];
    }
}