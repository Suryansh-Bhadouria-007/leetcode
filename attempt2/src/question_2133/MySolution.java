package question_2133;

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    public boolean checkValid(int[][] matrix) {
        if (null == matrix || matrix.length == 0)
            return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<Integer> validValues = new HashSet<>();
        for (int i = 1; i <= rows; i++) {
            validValues.add(i);
        }
        for (int i = 0; i < rows; i++) {
            HashSet<Integer> validValsRow = new HashSet<>(validValues);
            HashSet<Integer> validValsCol = new HashSet<>(validValues);

            for (int j = 0; j < cols; j++) {
                validValsRow.remove(matrix[i][j]);
                validValsCol.remove(matrix[j][i]);
            }
            if (validValsRow.size() != 0 || validValsCol.size() != 0)
                return false;
        }
        return true;
    }

}
