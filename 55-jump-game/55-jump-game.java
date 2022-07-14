class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(max >= i && nums[i] > 0) {
                max = Math.max(max, nums[i] + i);
            }
        }
        return max >= n - 1;
    }
}