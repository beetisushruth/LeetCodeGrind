class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length == 1) return true;
        int count = 0;
        if(nums[0] > nums[1]) {
            nums[0] = nums[1] - 1;
            count = 1;
        }
        int next_min = nums[0];
        for(int i=2; i<nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                if(nums[i] < next_min) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
                count++;
            }
            // System.out.println(Arrays.toString(nums));
            next_min = nums[i - 1];
            if(count > 1) return false;
        }
        return true;
    }
}