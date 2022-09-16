class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];
        return recurse(nums, multipliers, n, m, 0, n - 1, 0, dp);
    }
    
    public int recurse(int[] nums, int[] multipliers, int n, int m, int l, int r, int i, int[][] dp) {
        if(i >= multipliers.length) return 0;
        if(dp[l][i] != 0) return dp[l][i];
        return dp[l][i] = Math.max(recurse(nums, multipliers, n, m, l + 1, r, i + 1, dp) + nums[l]*multipliers[i], 
                        recurse(nums, multipliers, n, m, l, r - 1, i + 1, dp) + nums[r]*multipliers[i]
                       );
    }
}