class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int rep = 0;
        int mis = 0;
        for(int i=0; i<n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                rep = index + 1;
                continue;
            }
            nums[index] = -nums[index];
        }
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) mis = i + 1;
        }
        return new int[]{rep, mis};
    }
}