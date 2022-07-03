class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n - 1];
        for(int i=1; i<n; i++) {
            diff[i - 1] = nums[i] - nums[i - 1];
        }
        boolean sign = true;
        int count = 0;
        for(int i=0; i<diff.length; i++) {
            if((diff[i] > 0 && sign) || (diff[i] < 0 && !sign)) {
                count++;
                sign = !sign;
            }
        }
        int maxCount = count;
        count = 0;
        sign = false;
        for(int i=0; i<diff.length; i++) {
            if((diff[i] > 0 && sign) || (diff[i] < 0 && !sign)) {
                count++;
                sign = !sign;
            }
        }
        return Math.max(count, maxCount) + 1;
    }
}