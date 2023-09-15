class Solution {
    public int minCostConnectPoints(int[][] points) {
        int size = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
           return a[1] - b[1]; 
        });
        pq.add(new int[]{0, 0});
        boolean[] finalized = new boolean[size];
        int total = 0;
        while(pq.size() > 0) {
            int[] point = pq.remove();
            int index = point[0];
            int distance = point[1];
            if(finalized[index]) {
                continue;
            }
            total += distance;
            finalized[index] = true;
            for(int i=0; i<points.length; i++) {
                if(!finalized[i]) {
                    int dist = Math.abs(points[index][0] - points[i][0]) + Math.abs(points[index][1] - points[i][1]);
                    pq.add(new int[]{i, dist});
                }
            }
        }
        return total;
    }
}