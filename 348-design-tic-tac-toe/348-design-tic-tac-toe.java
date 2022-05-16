class TicTacToe {
    public int[] rows;
    public int[] cols;
    public int diag1 = 0;
    public int diag2 = 0;
    public int n;
    public boolean win = false;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        rows[row] += getPlayerValue(player);
        cols[col] += getPlayerValue(player);
        if(row == col) diag1 += getPlayerValue(player);
        if(row == n - 1 - col) diag2 += getPlayerValue(player);
        if(check(row, col)) return player;
        return 0;
    }
    
    public int getPlayerValue(int player) {
        return player == 1 ? -1 : 1;
    }
    
    public boolean check(int row, int col) {
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n) return true;
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */