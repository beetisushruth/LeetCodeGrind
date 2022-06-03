class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for( int k = 0 ; k < n * 2 ; k++ ) {
            for( int j = 0 ; j <= k/2; j++ ) {
                int i = k - j;
                if( i < n && j < n ) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}