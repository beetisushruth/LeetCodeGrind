class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
           return a[2] - b[2]; 
        });
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == 0) pq.add(new int[]{i, j, 0});
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!pq.isEmpty()) {
            int[] curr = pq.remove();
            // System.out.println(Arrays.toString(curr));
            if(rooms[curr[0]][curr[1]] != Integer.MAX_VALUE && rooms[curr[0]][curr[1]] != 0) continue;
            rooms[curr[0]][curr[1]] = curr[2];
            for(int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x >= 0 && y >= 0 && x < m && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                    pq.add(new int[]{x, y, curr[2] + 1});
                }
            }
        }
        return;
    }
}