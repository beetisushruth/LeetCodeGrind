class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    x.add(i); y.add(j);
                }
            }
        }
        Collections.sort(y);
        int med_x = x.get(x.size()/2);
        int med_y = y.get(y.size()/2);
        int total = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    total += Math.abs(i - med_x) + Math.abs(j - med_y);
                }
            }
        }
        return total;
    }
}