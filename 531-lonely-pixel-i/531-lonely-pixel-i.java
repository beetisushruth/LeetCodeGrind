class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);
        for(int i=0; i<m; i++) {
            int black = 0;
            int x = -1; int y = -1;
            for(int j=0; j<n; j++) {
                if(picture[i][j] == 'B') {
                    black++;
                    x = i; y = j;
                } 
            }
            if(black == 1) {
                col[y] = x;
            }
        }
        for(int i=0; i<n; i++) {
            int black = 0;
            int x = -1; int y = -1;
            for(int j=0; j<m; j++) {
                if(picture[j][i] == 'B') {
                    black++;
                    x = j;
                    y = i;
                }
            }
            if(black == 1) row[x] = y;
        }
        // System.out.println(Arrays.toString(row));
        // System.out.println(Arrays.toString(col));
        int count = 0;
        for(int i=0; i<row.length; i++) {
            if(row[i] != -1 && col[row[i]] == i) count++;
        }
        return count;
    }
}