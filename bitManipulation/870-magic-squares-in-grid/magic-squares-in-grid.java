class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) count++;
            }
        }
        return count;
    }

    private boolean isMagic(int[][] g, int r, int c) {
        boolean[] seen = new boolean[10];

        // center must be 5
        if (g[r+1][c+1] != 5) return false;

        // check numbers 1..9 exactly once
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int v = g[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }

        int sum = g[r][c] + g[r][c+1] + g[r][c+2];

        return
            g[r+1][c] + g[r+1][c+1] + g[r+1][c+2] == sum &&
            g[r+2][c] + g[r+2][c+1] + g[r+2][c+2] == sum &&
            g[r][c] + g[r+1][c] + g[r+2][c] == sum &&
            g[r][c+1] + g[r+1][c+1] + g[r+2][c+1] == sum &&
            g[r][c+2] + g[r+1][c+2] + g[r+2][c+2] == sum &&
            g[r][c] + g[r+1][c+1] + g[r+2][c+2] == sum &&
            g[r+2][c] + g[r+1][c+1] + g[r][c+2] == sum;
    }
}
