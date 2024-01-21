class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] total = new int[n];
        total[0] = nums[0]; total[1] = Math.max(nums[1], total[0]);
        for(int i=2; i<n; i++) {
            total[i] = Math.max(total[i - 1], total[i - 2] + nums[i]);
        }
        return total[n - 1];
    }
}