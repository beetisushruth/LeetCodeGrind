class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
        
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();
        visited[0][0] = true;
        traverse(matrix, visited, ans, 0, 0, dirs[3]);
        return ans;
    }
    
    public void traverse(int[][] matrix, boolean[][] visited, List<Integer> ans, int i, int j, int[] dir) {
        ans.add(matrix[i][j]);
        int newI = i + dir[0];
        int newJ = j + dir[1];
        if(newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length && !visited[newI][newJ]) {
            visited[newI][newJ] = true;
            traverse(matrix, visited, ans, newI, newJ, dir);
        } else {
            for(int k=0; k<dirs.length; k++) {
                newI = i + dirs[k][0];
                newJ = j + dirs[k][1];
                if(newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length &&     !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    traverse(matrix, visited, ans, newI, newJ, dirs[k]);
                }
            }
        }
    } 
    
}