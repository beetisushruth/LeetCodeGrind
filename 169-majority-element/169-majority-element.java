class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int sum = 1;
        for(int i = 1; i<nums.length; i++) {
            if(sum == 0) maj = nums[i];
            if(nums[i] != maj) sum -= 1;
            else sum += 1;
        }
        return maj;
    }
}