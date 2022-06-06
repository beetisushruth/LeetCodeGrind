class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = nums.length + 1;
        while(left <= right && right < n) {
            sum += nums[right];
            while(left <= right && sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == nums.length + 1 ? 0 : minLength;
    }
}