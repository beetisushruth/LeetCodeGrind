class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1], 0});
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()) {
            int[] curr = q.remove();
            if(curr[0] == 0 || curr[0] == m - 1 || curr[1] == 0 || curr[1] == n - 1) {
             if(!(curr[0] == entrance[0] && curr[1] == entrance[1])) return curr[2];
            }
            for(int[] dir : dirs) {
                int x = curr[0] + dir[0]; // -1
                int y = curr[1] + dir[1]; // 2
                if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && maze[x][y] == '.') {
                    visited[x][y] = true;
                    q.add(new int[]{x, y, curr[2] + 1});
                }
            }
        }
        return -1;
    }
}