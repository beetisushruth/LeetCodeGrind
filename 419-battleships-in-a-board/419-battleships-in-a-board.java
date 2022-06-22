class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                boolean leftEmpty = i - 1 >= 0 ? board[i - 1][j] == 'X' ? false : true : true;
                boolean upEmpty = j - 1 >= 0 ? board[i][j - 1] == 'X' ? false : true : true;
                if(board[i][j] == 'X' && leftEmpty && upEmpty) count++;
            }
        }
        return count;
    }
}