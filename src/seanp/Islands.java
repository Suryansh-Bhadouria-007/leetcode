package seanp;
// Java program to count islands in boolean 2D matrix

public class Islands {
    int ROW, COL;
    int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    boolean isSafe(char M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == '1' && !visited[row][col]);
    }

    void DFS(char M[][], int row, int col, boolean visited[][]) {
        visited[row][col] = true;
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    int countIslands(char M[][]) {
        ROW = M.length;
        COL = M[0].length;
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == '1' && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    ++count;
                }
        return count;
    }

    // Driver method
    public static void main(String[] args) throws java.lang.Exception {
        char M[][] = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        Islands I = new Islands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
