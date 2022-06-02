class Solution {
    public int[][] transpose(int[][] matrix) {
        /*
            1 2 3
            4 5 6
        */
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sol = new int[n][m];
        
        for(int i=0; i<n; i++) {
            int[] row = new int[m];
            for(int j=0; j<m; j++) {
                row[j] = matrix[j][i];
            }
            sol[i] = row;
        }
        return sol;
    }
}