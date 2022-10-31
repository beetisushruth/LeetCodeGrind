class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++) {
            int j = 0;
            int k = i;
            int element = matrix[i][j];
            while(k >= 0 && k < m && j >= 0 && j < n) {
                if(matrix[k][j] != element) return false;
                k++;
                j++;
            }
        }
        for(int j=1; j<n; j++) {
            int i= 0;
            int k = j;
            int element = matrix[i][j];
            while(i >= 0 && i < m && k >= 0 && k < n) {
                if(matrix[i][k] != element) return false;
                i++;
                k++;
            }
        }
        return true;
    }
}