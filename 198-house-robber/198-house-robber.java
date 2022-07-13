class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0]; dp[1] = nums[1];
        int ans = Math.max(dp[0], dp[1]);
        for(int i=2; i<nums.length; i++) {
            for(int j=i-2; j>=0; j--) {
                dp[i] = Math.max(nums[i] + dp[j], dp[i]);
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}