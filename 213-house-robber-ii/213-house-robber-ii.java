class Solution {
    public int rob(int[] nums) {
        //[x x x x x]
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n-1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int ans = dp[n - 2];
        dp = new int[n];
        dp[0] = 0; dp[1] = nums[1];
        for(int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(ans, dp[n - 1]);
    }
}