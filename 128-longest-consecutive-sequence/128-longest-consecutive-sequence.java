class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int count = 0;
        int maxCount = 0;
        for(int i=0; i<nums.length; i++) {
            count = 1;
            int num = nums[i];
            if(!set.contains(num - 1)) {
                while(set.contains(num + 1)) {
                    count++;
                    num++;
                }
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}