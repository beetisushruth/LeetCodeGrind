class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] dp = new int[map.size() + 1];
        dp[0] = 0;
        int i = 1;
        System.out.println(map.keySet());
        for(int key : map.keySet()) {
            if(!map.containsKey(key - 1)) {
                dp[i] = dp[i - 1] + map.get(key) * key;
            } else {
                dp[i] = Math.max(dp[i - 1], dp[Math.max(i - 2, 0)] + map.get(key)*key);
            }
            i++;
        }
        return dp[dp.length - 1];
    }
}