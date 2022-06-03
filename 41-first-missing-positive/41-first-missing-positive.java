class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains = false;
        for(int num : nums) {
            if(num == 1) {
                contains = true;
                break;
            }
        }
        if(!contains) return 1;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0 || nums[i] > n || nums[i] < 0) nums[i] = 1;
        }
        for(int i=0; i<n; i++) {
            int index = Math.abs(nums[i]);
            nums[index - 1] *= (nums[index - 1] > 0 ? -1 : 1);
        }
        for(int i=1; i<n; i++) {
            if(nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}