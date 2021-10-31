package seanp;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int rows;
    int columns;
    private int[] dr = {0, 0, 1, -1};
    private int[] dc = {1, -1, 0, 0};
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        this.heights = heights;
        this.rows = heights.length;
        this.columns = heights[0].length;
        boolean[][] pacificReachable = new boolean[this.rows][this.columns];
        boolean[][] atlanticReachable = new boolean[this.rows][this.columns];
        for (int j = 0; j < this.columns; j++) {
            dfs(new Coordinate(0, j), pacificReachable);
            dfs(new Coordinate(this.rows - 1, j), atlanticReachable);
        }
        for (int i = 0; i < this.rows; i++) {
            dfs(new Coordinate(i, 0), pacificReachable);
            dfs(new Coordinate(i, this.columns - 1), atlanticReachable);
        }

        //find common nodes in pacific and atlantic
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(Coordinate current, boolean[][] reachable) {
        reachable[current.x][current.y] = true;

        for (int k = 0; k < this.dr.length; k++) {
            Coordinate newCoordinate = new Coordinate(current.x + dr[k], current.y + dc[k]);
            if (!isValid(newCoordinate))
                continue;
            if (reachable[newCoordinate.x][newCoordinate.y]) {
                continue;
            }
            if (this.heights[newCoordinate.x][newCoordinate.y] < this.heights[current.x][current.y])
                continue;

            dfs(newCoordinate, reachable);
        }
    }

    private boolean isValid(Coordinate coordinate) {
        return coordinate.x < this.rows && coordinate.x >= 0 && coordinate.y < this.columns && coordinate.y >= 0;
    }

    public static void main(String[] args) {
        PacificAtlantic pa = new PacificAtlantic();
        int heights[][] = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> common = pa.pacificAtlantic(heights);
        common.stream().forEach(System.out::println);
    }
}
