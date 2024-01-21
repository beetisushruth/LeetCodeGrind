class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int prev1 = nums[0]; int prev2 = Math.max(nums[1], nums[0]);
        for(int i=2; i<n; i++) {
            int tmp = prev2;
            prev2 = Math.max(prev1 + nums[i], prev2);
            prev1 = tmp;
        }
        return prev2;
    }
}