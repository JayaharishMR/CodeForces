public class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                swap(i, j, matrix);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < row; i++) {
            reverse(i, matrix, col);
        }
    }

    // swap elements across diagonal
    public static void swap(int i, int j, int[][] arr) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    // reverse a given row
    public static void reverse(int row, int[][] arr, int col) {
        int i = 0;
        int j = col - 1;
        while (i < j) {
            int temp = arr[row][i];
            arr[row][i] = arr[row][j];
            arr[row][j] = temp;
            i++;
            j--;
        }
    }
}
