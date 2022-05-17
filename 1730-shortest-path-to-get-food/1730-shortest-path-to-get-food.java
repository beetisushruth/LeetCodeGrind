class Solution {
    public int getFood(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] start = new int[3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '*') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int i = current[0];
            int j = current[1];
            int cost = current[2];
            if(grid[i][j] == '#') return cost;
            if(i >= 1 && !visited[i - 1][j] && grid[i - 1][j] != 'X') {
                q.add(new int[]{i - 1, j, cost + 1});
                visited[i - 1][j] = true;
            }
            if(j >= 1 && !visited[i][j - 1] && grid[i][j - 1] != 'X') {
                q.add(new int[]{i, j - 1, cost + 1});
                visited[i][j - 1] = true;
            }
            if(i < n - 1 && !visited[i + 1][j] && grid[i + 1][j] != 'X') {
                q.add(new int[]{i + 1, j, cost + 1});
                visited[i + 1][j] = true;
            }
            if(j < m - 1 && !visited[i][j + 1] && grid[i][j + 1] != 'X') {
                q.add(new int[]{i, j + 1, cost + 1});
                visited[i][j + 1] = true;
            }
        }
        return -1;
    }
}