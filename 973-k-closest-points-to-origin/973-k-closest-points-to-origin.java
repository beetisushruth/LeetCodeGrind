class Solution {
    //approach 1
    // public int[][] kClosest(int[][] points, int k) {
    //     Arrays.sort(points, (x, y) -> {
    //         int dist1 = x[0]*x[0] + x[1]*x[1];
    //         int dist2 = y[0]*y[0] + y[1]*y[1];
    //         return dist1 - dist2;
    //     });
    //     int[][] solution = new int[k][2];
    //     for(int i=0; i<k; i++) {
    //         solution[i][0] = points[i][0];
    //         solution[i][1] = points[i][1];
    //     }
    //     return solution;
    // }
    public int dist(int[] x) {
        return x[0]*x[0] + x[1]*x[1];
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i=0; i<points.length; i++) {
            int[] elem = {dist(points[i]), i};
            if(pq.size() < k) {
                pq.add(elem);
            } else if (elem[0] < pq.peek()[0]) {
                pq.poll();
                pq.add(elem);
            }
        }
        int[][] solution = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            int[] entry = pq.poll();
            int index = entry[1];
            solution[i] = points[index];
            i++;
        }
        return solution;
    }
    
}