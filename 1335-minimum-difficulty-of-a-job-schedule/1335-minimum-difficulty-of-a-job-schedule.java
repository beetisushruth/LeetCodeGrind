class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] maxArr = new int[n][n];
        for(int i=0; i<n; i++) {
            maxArr[i][i] = jobDifficulty[i];
        }
        for(int i=0; i<n; i++) {
            for(int j=i + 1; j<n; j++) {
                maxArr[i][j] = Math.max(maxArr[i][j - 1], jobDifficulty[j]);
            }
        }
        int[][] dp = new int[n][d + 1];
        for(int i=0; i<n; i++) {
            for(int j=1; j<=d; j++) {
                if(j == 1) dp[i][j] = maxArr[0][i];
                else if(j > i + 1) dp[i][j] = Integer.MAX_VALUE/2;
                else {
                    int minValue = Integer.MAX_VALUE;
                    for(int k=1; k<=i; k++) {
                        minValue = Math.min(dp[k - 1][j - 1] + maxArr[k][i], minValue);
                    }
                    dp[i][j] = minValue;
                }
            }
        }
        return dp[n - 1][d];
    }
    
}