public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int[] rowArr = new int[matrix.length];
        int[] colArr = new int[matrix[0].length];

        for (int i =0 ; i < matrix.length; i++) {
            for (int j =0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowArr[i] = -1;
                    colArr[j] = -1;
                }
            }
        }

        for (int i =0 ; i < matrix.length; i++) {
            for (int j =0; j < matrix[0].length; j++) {
                if (rowArr[i] == -1 || colArr[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
