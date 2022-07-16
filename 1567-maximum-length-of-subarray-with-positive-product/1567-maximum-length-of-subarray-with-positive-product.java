class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] neg = new int[n];
        int[] pos = new int[n];
        if(nums[0] > 0) pos[0]++;
        if(nums[0] < 0) neg[0]++;
        int max = pos[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > 0) {
                pos[i] += pos[i - 1] + 1;
                neg[i] += neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
            } 
            if(nums[i] < 0) {
                pos[i] = neg[i - 1] > 0 ? neg[i - 1] + 1 : 0;
                neg[i] += pos[i - 1] + 1;
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }
}