class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i < n ; i++) {
            sum += nums[i];
            sum = sum%p;
        }
        int rem = sum;
        // System.out.println("rem: "+rem);
        if(rem == 0) return 0;
        sum = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<n; i++) {
            sum = (sum + nums[i]) % p;
            int find = sum - rem >= 0 ? sum - rem : sum - rem + p;
            if(map.containsKey(find)) {
                min = Math.min(min, i - map.get(find));
            }
            map.put(sum, i);
        }
        return min != Integer.MAX_VALUE && min != n ? min : -1;
    }
        
}

// 10 + 26 - 19

// [0,19,4,18,10,14,21,22,0,23,16,24,8,14,14,17]

// 0, 19, 4, 18, 10, 14

// [0, 19, 11, 14, 18, 4, 7, 1, 4, 23, 19, 8, 10, 6, 0, 3]