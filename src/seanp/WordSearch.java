package seanp;

public class WordSearch {
    int rows;
    int cols;
    private char[][] board;
    private String word;
    private int dr[] = {1, -1, 0, 0};
    private int dc[] = {0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0))
                    return true;
            }
        }
        return false;

    }

    private boolean dfs(int r, int c, int index) {
        /* Step 1). check the bottom case. */
        if (index >= this.word.length())
            return true;

        /* Step 2). Check the boundaries. */
        if (r < 0 || r == this.rows || c < 0 || c == this.cols || this.board[r][c] != this.word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        boolean result = false;
        // mark the path before the next exploration
        this.board[r][c] = '#';

        for (int i = 0; i < 4; i++) {
            int rNew = r + this.dr[i];
            int cNew = c + this.dc[i];
            result = dfs(rNew, cNew, index + 1);
            if (result)
                break;
        }
        /* Step 4). clean up and return the result. */
        this.board[r][c] = word.charAt(index);
        return result;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
//        char board[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char board[][] = {{'a', 'b'}, {'c', 'd'}};
        String word = "cdba";
        System.out.println(wordSearch.exist(board, word));
    }
}
