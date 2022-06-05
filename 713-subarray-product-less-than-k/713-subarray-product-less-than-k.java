class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, ans = 0, product = 1;
        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while(product >= k) {
                product /= nums[left++];
            }
            ans += (right - left + 1);
        }
        return ans;
    }
}