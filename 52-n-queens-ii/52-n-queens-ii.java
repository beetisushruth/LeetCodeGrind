class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] matrix = new String[n][n];
        backtrack(n, matrix, 0, 0, 0, ans);
        return ans.size();
    }
    
    public void backtrack(int n, String[][] matrix, int x, int y, int count, List<List<String>> ans) {
        if(count == n) {
            ans.add(convert(matrix, n));
            return;
        }
        for(int i=x; i<n; i++) {
            for(int j=y; j<n; j++) {
                if(matrix[i][j] == null && isValid(matrix, i, j, n)) {
                    matrix[i][j] = "Q";
                    count++;
                    backtrack(n, matrix, i, 0, count, ans);
                    matrix[i][j] = null;
                    count--;
                }
            }
        }
    }
    
    public List<String> convert(String[][] matrix, int n) {
        List<String> solution = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == null) sb.append(".");
                else sb.append("Q");
            }
            solution.add(sb.toString());
        }
        return solution;
    }
    
    public boolean isValid(String[][] matrix, int i, int j, int n) {
        for(int k=0; k<n; k++) {
            if(k != i && matrix[k][j] != null) return false;
        }
        for(int k=0; k<n; k++) {
            if(k != j && matrix[i][k] != null) return false;
        }
        int x = i, y = j;
        while(x - 1 >= 0 && y - 1 >= 0) {
            if(matrix[x - 1][y - 1] != null) return false;
            x--;
            y--;
        }
        x = i; y = j;
        while(x + 1 < n && y + 1 < n) {
            if(matrix[x + 1][y + 1] != null) return false;
            x++; y++;
        }
        x = i; y = j;
        while(x - 1 >= 0 && y + 1 < n) {
            if(matrix[x - 1][y + 1] != null) return false;
            x--; y++;        
        }
        x = i; y = j;
        while(x + 1 < n && y - 1 >= 0) {
            if(matrix[x + 1][y - 1] != null) return false;
            x++; y--;        
        }
        return true;
    }
}