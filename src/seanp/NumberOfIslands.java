package seanp;

public class NumberOfIslands {
    private char[][] grid;
    private int rows;
    private int columns;
    private boolean visited[][];
    private int dr[] = {0, 0, 1, -1, 1, -1, 1, -1};
    private int dc[] = {1, -1, 0, 0, 1, -1, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        this.rows = grid.length;
        this.columns = grid[0].length;
        this.visited = new boolean[this.rows][this.columns];
        int count = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (!this.visited[i][j] && this.grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        this.visited[i][j] = true;
        for (int k = 0; k < this.dr.length; k++) {
            int newRow = i + this.dr[k];
            int newCol = j + this.dc[k];
            if (isValid(newRow, newCol))
                dfs(newRow, newCol);
        }
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < this.rows && j >= 0 && j < this.columns && !this.visited[i][j] && this.grid[i][j] == '1';
    }
}
