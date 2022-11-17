class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = -1;
        for(int num : nums) {
            int diff = k - num - 1;
            Integer p = set.floor(diff);
            if(p != null && p + num < k) max = Math.max(max, p + num);
            set.add(num);
        }
        return max;
    }
}