class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n =  (int) Math.ceil(nums.length/2);
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > n) return num;
        }
        return 0;
    }
}