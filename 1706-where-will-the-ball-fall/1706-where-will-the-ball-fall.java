class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int index = dfs(grid, 0, i, m, n);
            ans[i] = index;
        }
        return ans;
    }
    
    public int dfs(int[][] grid, int i, int j, int m, int n) {
        // System.out.println(i+" "+j);
        if(j >= n || j < 0) return -1;
        if(i == m) return j;
        if(grid[i][j] == -1) {
            if(j - 1 >= 0 && grid[i][j - 1] == -1) return dfs(grid, i + 1, j - 1, m, n);
            else return -1;
        } else {
            if(j + 1 < n && grid[i][j + 1] == 1) return dfs(grid, i + 1, j + 1, m, n);
            else return -1;
        }
    }
}