package seanp;

public class SetMatrixZero {
    public static void main(String[] args) {
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        int matrix[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setMatrixZero.setZeroes(matrix);
    }

    private void printMatrix(int matrix[][]) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    for (int j1 = 0; j1 < col; j1++) {
                        if (matrix[i][j1] != 0)
                            matrix[i][j1] = Integer.MIN_VALUE;
                    }
                    for (int i1 = 0; i1 < row; i1++) {
                        if (matrix[i1][j] != 0)
                            matrix[i1][j] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        printMatrix(matrix);
        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE)
                    matrix[i][j] = 0;
            }
        }
        printMatrix(matrix);
    }
}
