class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int r = heights.length;
        int c = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
           return a[2] - b[2]; 
        });
        // node [x, y, effort];
        pq.add(new int[]{0, 0, 0});
        boolean[][] finalized = new boolean[r][c];
        while(!pq.isEmpty()) {
            int[] point = pq.remove();
            if(point[0] == r - 1 && point[1] == c - 1) return point[2];
            if(finalized[point[0]][point[1]]) continue;
            finalized[point[0]][point[1]] = true;
            for(int[] dir : dirs) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                if(x >= 0 && x < r && y >= 0 && y < c) {
                    int effort = Math.abs(heights[point[0]][point[1]] - heights[x][y]);
                    pq.add(new int[]{x, y, Math.max(effort, point[2])});
                }
            }
        }
        return 0;
    }
}