class Solution {
    int MOD = (int) Math.pow(10, 9) + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m][n][maxMove + 1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (int) recurse(m, n, startRow, startColumn, maxMove, dp);
    }
    
    public long recurse(int m, int n, int row, int col, int maxMove, long[][][] dp) {
        if(maxMove < 0) return 0; 
        if(row < 0 || row >= m) return 1;
        if(col < 0 || col >= n) return 1;
        if(dp[row][col][maxMove] != -1) return dp[row][col][maxMove];
        long total = (recurse(m, n, row - 1, col, maxMove - 1, dp) + recurse(m, n, row + 1, col, maxMove - 1, dp) + recurse(m, n, row, col - 1, maxMove - 1, dp) + recurse(m, n, row, col + 1, maxMove - 1, dp));
        return dp[row][col][maxMove] = total%MOD;
    }
}