class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                maxArea = Math.max(dfs(grid, i, j, visited), maxArea);
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if(grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int sum = 1;
        if(i + 1 < grid.length && !visited[i + 1][j]) sum += dfs(grid, i + 1, j, visited);
        if(i - 1 >= 0 && !visited[i - 1][j]) sum += dfs(grid, i - 1, j, visited);
        if(j + 1 < grid[0].length && !visited[i][j + 1]) sum += dfs(grid, i, j + 1, visited);
        if(j - 1 >= 0 && !visited[i][j - 1]) sum += dfs(grid, i, j - 1, visited);
        return sum;
    }
}