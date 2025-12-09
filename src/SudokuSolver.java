public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for(char a = '1'; a <= '9'; a++) {
                        if (isValid(board, i, j, a)) {
                            board[i][j] = a;
                            if (solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    if (board[i][j] == '.') return false;

                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int x, int y, char p) {
        for (int i = 0; i < board.length; i++)
            if (board[i][y] == p || board[x][i] == p)
                return false;
        int X = x/3, Y = y/3;
        X *= 3;
        Y *= 3;
        for (int i = X; i < X + 3; i++) {
            for (int j = Y; j < Y + 3; j++)
                if (board[i][j] == p)
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sudokuSolver.solveSudoku(board);

    }
}
