class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxCount = 0;
        for(int num : nums) {
            int count = 1;
            if(!set.contains(num - 1)) {
                while(set.contains(num + 1)) {
                    count++;
                    num = num + 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}