class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, maxLen = 0;
        for(int i=0; i<nums.length; i++) {
            count += nums[i];
            if(map.containsKey(count - k)) {
                maxLen = Math.max(maxLen, i - map.get(count - k));
            } 
            if(!map.containsKey(count)){
                map.put(count, i);
            }
        }
        return maxLen;
    }
}