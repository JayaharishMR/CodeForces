import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/n-queens/solutions/7231864/java-solution-with-dry-run-example-of-n-rpmk7
public class Nqueen {
    public static boolean isPossible(char[][] board, int col, int row, List<List<String>> ans) {
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; (i >= 0 && j >= 0); i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; (j < board.length && i >= 0); i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void helperQueen(char[][] board, List<List<String>> ans, int row, int totalNoOfQueen){
        if (totalNoOfQueen == row) {
            List<String> temp = new ArrayList<>();
            for (char[] arr : board) {
                temp.add(new String(arr));
            }
            ans.add(temp);
            return;
        }
        for (int i =0; i < totalNoOfQueen; i++) {
            if (isPossible(board, i, row, ans )) {
                board[row][i] = 'Q';
                helperQueen(board, ans, row+1, totalNoOfQueen);
                board[row][i] = '.';
            }
        }
    }
    public static  List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j =0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helperQueen(board, ans, 0, n);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }
}
