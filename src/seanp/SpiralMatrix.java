package seanp;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static List<Integer> spiralPrint(int matrix[][]) {
        List<Integer> spiralOrder = new ArrayList<>();
        if (matrix == null)
            return spiralOrder;
        int endRow = matrix.length;
        if (endRow == 0)
            return spiralOrder;
        int endCol = matrix[0].length;
        if (endCol == 0)
            return spiralOrder;
        int i, startRow = 0, startCol = 0;

        /*  startRow - starting row index
        endRow - ending row index
        startCol - starting column index
        endCol - ending column index
        i - iterator
        */

        while (startRow < endRow && startCol < endCol) {
            // Print the first row from the remaining rows
            for (i = startCol; i < endCol; ++i) {
                System.out.print(matrix[startRow][i] + " ");
                spiralOrder.add(matrix[startRow][i]);
            }
            startRow++;

            // Print the last column from the remaining
            // columns
            for (i = startRow; i < endRow; ++i) {
                System.out.print(matrix[i][endCol - 1] + " ");
                spiralOrder.add(matrix[i][endCol - 1]);

            }
            endCol--;

            // Print the last row from the remaining rows */
            if (startRow < endRow) {
                for (i = endCol - 1; i >= startCol; --i) {
                    System.out.print(matrix[endRow - 1][i] + " ");
                    spiralOrder.add(matrix[endRow - 1][i]);
                }
                endRow--;
            }

            // Print the first column from the remaining
            // columns */
            if (startCol < endCol) {
                for (i = endRow - 1; i >= startRow; --i) {
                    System.out.print(matrix[i][startCol] + " ");
                    spiralOrder.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }
        return spiralOrder;
    }
}
