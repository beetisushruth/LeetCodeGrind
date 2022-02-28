class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        for(int i=1; i<=n; i++) {
            int max = 0;
            for(int j=i - 2; j>=0; j--) {
                if(nums[j] < nums[i - 1]) {
                    max = Math.max(max, dp[j + 1]);
                }
            }
            dp[i] = (max + 1);
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}