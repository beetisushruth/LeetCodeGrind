class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int start = 0; int cur = 1;
        map.put(nums[0], 1);
        int maxLength = 1;
        while(cur < n) {
            map.put(nums[cur], map.getOrDefault(nums[cur], 0) + 1);
            while(map.get(nums[cur]) > k && start < cur) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, cur - start + 1);
            cur++;
        }
        return maxLength;
    }
}