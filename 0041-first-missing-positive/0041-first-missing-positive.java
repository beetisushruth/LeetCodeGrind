class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int start = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
        n = start;
        for(int i=0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(index < n) {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}