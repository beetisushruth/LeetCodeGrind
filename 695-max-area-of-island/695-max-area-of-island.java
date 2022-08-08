class Solution {
    
    public static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int area = getArea(grid, visited, i, j);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
    
    public int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int count = 1;
        for(int[] dir : dirs) {
            count += getArea(grid, visited, i + dir[0], j + dir[1]);
        }
        return count;
    }
}