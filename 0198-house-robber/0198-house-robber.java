class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] total = new int[n];
        total[0] = nums[0];
        int best = nums[0];
        if(n > 1) {
            total[1] = nums[1];
            best = Math.max(best, nums[1]);
        }
        for(int i=2; i<n; i++) {
            int maxTotal = 0;
            for(int j = i - 2; j >= 0 ; j--) {
                maxTotal = Math.max(maxTotal, total[j]);
            }
            total[i] = maxTotal + nums[i];
            best = Math.max(total[i], best);
        }
        return best;
    }
}