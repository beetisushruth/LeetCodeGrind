class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        int move = -1;
        for(int i=0; i<moves.length; i++) {
            board[moves[i][0]][moves[i][1]] = move;
            move = -move;
        }
        // check horizontal & vertical
        for(int i=0; i<3; i++) {
            if(board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return board[i][0] == 1 ? "B" : "A";
            }
            if(board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return board[0][i] == 1 ? "B" : "A";
            }
        }
        if(board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            return board[0][0] == 1 ? "B" : "A";
        if(board[0][2] != 0  && board[0][2] == board[1][1] && board[0][2] == board[2][0])
            return board[1][1] == 1 ? "B" : "A";
        return moves.length == 9 ? "Draw" : "Pending";
    }
}