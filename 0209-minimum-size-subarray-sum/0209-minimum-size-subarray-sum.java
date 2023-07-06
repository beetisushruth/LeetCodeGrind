class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = -1; int leftSum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum - leftSum >= target && left <= i) {
                ans = Math.min(ans, i - left);
                left++;
                leftSum += nums[left];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}