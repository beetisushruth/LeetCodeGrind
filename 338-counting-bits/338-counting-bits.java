class Solution {
    // 
    public int[] countBits(int n) {
        if(n == 0) return new int[]{0};
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int pow = 1;
        for(int i=2; i<=n; i++) {
            if(i/pow > 0) pow *= 2;
            dp[i] = dp[i%(pow/2)] + 1;
        }
        return dp;
    }
}