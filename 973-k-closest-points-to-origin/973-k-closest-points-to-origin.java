class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (x, y) -> {
            int dist1 = x[0]*x[0] + x[1]*x[1];
            int dist2 = y[0]*y[0] + y[1]*y[1];
            return dist1 - dist2;
        });
        int[][] solution = new int[k][2];
        for(int i=0; i<k; i++) {
            solution[i][0] = points[i][0];
            solution[i][1] = points[i][1];
        }
        return solution;
    }
}