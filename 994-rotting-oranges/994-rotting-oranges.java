class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        int time = bfs(grid, visited, q);
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
    
    public int bfs(int[][] grid, boolean[][] visited, Queue<int[]> q) {
        int count = 0;
        while(!q.isEmpty()) {
            int[] pos = q.remove();
            int x = pos[0];
            int y = pos[1];
            int dist = pos[2];
            count = Math.max(count, dist);
            if(x + 1 < visited.length && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
                q.add(new int[]{x + 1, y, dist + 1});
                visited[x + 1][y] = true;
            }
            if(x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
                q.add(new int[]{x - 1, y, dist + 1});
                visited[x - 1][y] = true;
            }
            if(y + 1 < visited[0].length && grid[x][y + 1] == 1 && !visited[x][y + 1]) {
                q.add(new int[]{x, y + 1, dist + 1});
                visited[x][y + 1] = true;
            }
            if(y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
                q.add(new int[]{x, y - 1, dist + 1});
                visited[x][y - 1] = true;
            }
        }
        return count;
    }
}