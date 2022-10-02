class Solution {
    int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recurse(n, k, target, dp);
    }
    
    public int recurse(int n, int k, int target, int[][] dp) {
        if(target == 0 && n == 0) return 1;
        if(target <= 0 || n < 0) return 0;
        if(dp[n][target] != -1) return dp[n][target];
        long total = 0;
        for(int i=1; i<=k; i++) {
            total = (total + recurse(n - 1, k, target - i, dp))%MOD;
        }
        return dp[n][target] = (int)total;
    }
}