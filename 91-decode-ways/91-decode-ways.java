class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return ways(s, 0, dp);
    }
    
    public int ways(String s, int i, int[] dp) {
        if(i == s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        int total = 0;
        if(s.charAt(i) != '0') {
            total += ways(s, i + 1, dp);
        } 
        if(i + 1 < s.length() && s.charAt(i) != '0') {
            int num = (s.charAt(i) - '0')*10 + (s.charAt(i + 1) - '0');
            if(num >= 0 && num <= 26) total += ways(s, i + 2, dp);
        }
        return dp[i] = total;
    }
}