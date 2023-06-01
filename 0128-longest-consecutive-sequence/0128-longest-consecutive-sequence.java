class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longSeq = 0;
        for(int num : nums) {
            set.add(num);
        }
        for(int num : nums) {
            if(set.contains(num - 1)) continue;
            int currentSeq = 1;
            while(set.contains(num + 1)) {
                currentSeq++;
                num = num + 1;
            }
            longSeq = Math.max(longSeq, currentSeq);
        }
        return longSeq;
    }
}