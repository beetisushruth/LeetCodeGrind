class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0] == 0) {
            q.add(new int[]{0, 0, 1});
            visited[0][0] = true;
        }
        int[] dirs = new int[]{0, -1, 1};
        while(!q.isEmpty()) {
            int[] cell = q.remove();
            if(cell[0] == n - 1 && cell[1] == n - 1) return cell[2];
            for(int dir1 : dirs) {
                for(int dir2 : dirs) {
                    int i = cell[0] + dir1;
                    int j = cell[1] + dir2;
                    if(i >= 0 && j >= 0 && i < n && j < n && !visited[i][j] && grid[i][j] == 0) {
                        visited[i][j] = true;
                        q.add(new int[]{i, j, cell[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}