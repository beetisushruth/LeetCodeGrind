class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int left = 0;
        int maxSum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            while(set.contains(nums[i]) && left < i) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[i]);
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}