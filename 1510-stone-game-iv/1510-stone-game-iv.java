class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        int i = 2;
        while(i <= n) {
            dp[i] = chooseBestMove(dp, i);
            i++;
        }
        return dp[n];
    }
    
    public boolean chooseBestMove(boolean[] dp, int n) {
        int i = 1;
        while(i * i <= n) {
            if(!dp[n - i*i]) return true;
            i++;
        }
        return false;
    }
    
}