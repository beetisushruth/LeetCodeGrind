class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int cur = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                count = 0;
                nums[k] = nums[i];
                k++;
            } else if(count < 2) {
                nums[k] = nums[i];
                k++;
            }
            count++;
        }
        return k;
    }
}