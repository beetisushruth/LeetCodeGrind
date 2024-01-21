class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev1 = 0; int prev2 = 0;
        for(int i=0; i<n; i++) {
            int tmp = prev2;
            prev2 = Math.max(prev1 + nums[i], prev2);
            prev1 = tmp;
        }
        return prev2;
    }
}