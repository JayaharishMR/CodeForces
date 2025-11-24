public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for ( int i= 0; i< board.length; i++) {
            for ( int j= 0; j< board[0].length; j++) {
                if ( solve( board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean solve(char[][] board, String word, int r, int c, int index) {
// base conditition
        if ( index == word.length()) {
            return true;
        }

        if ( r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }

        if ( board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';  //mark visted

        boolean found =
                solve(board, word, r + 1, c, index + 1) ||
                        solve(board, word, r - 1, c, index + 1) ||
                        solve(board, word, r, c + 1, index + 1) ||
                        solve(board, word, r, c - 1, index + 1);


        board[r][c] = temp; // unmark



        return found;
    }


}