class Solution {
    /*
    [0,0,1,0,1],
    [0,1,1,0,1],
    [0,1,0,0,1],
    [0,0,0,0,0],
    [0,0,0,0,0]]
    */
    public static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> is = new ArrayList<>();
        boolean[][] group = new boolean[m][n];
        boolean groupfound = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, is, group);
                    groupfound = true;
                    break;
                }
            }
            if(groupfound) break;
        }
        // System.out.println(is.size());
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<is.size(); i++) {
            int[] point = is.get(i);
            visited[point[0]][point[1]] = true;
            q.add(new int[]{point[0], point[1], 0});
        }
        int count = 0;
        while(!q.isEmpty()) {
            int[] point = q.remove();
            // System.out.println(Arrays.toString(point));
            if(grid[point[0]][point[1]] == 1 && !group[point[0]][point[1]]) {
                return point[2] - 1;
            }
            for(int[] dir : dirs) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y, point[2] + 1});
                }
            }
        }
        return 0;
    }
    
    public void dfs(int[][] grid, int x, int y, List<int[]> is, boolean[][] visited) {
        // System.out.println(x+" "+y);
        visited[x][y] = true;
        is.add(new int[]{x, y});
        for(int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1 && !visited[i][j]) {
                dfs(grid, i, j, is, visited);
            }
        }
        
    }
}