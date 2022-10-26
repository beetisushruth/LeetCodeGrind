class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            sum = (sum + nums[i])%k;
            if(map.containsKey(sum)) {
                if(i - map.get(sum) >= 2) return true;
            } else {
                map.put(sum, i);
            }
            
        }
        return false;
    }
}