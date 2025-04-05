class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] cannotBeVisited = new boolean[rows][cols];

        // Traverse border cells
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, cannotBeVisited);
            }
            if (grid[i][cols - 1] == 1) {
                dfs(grid, i, cols - 1, cannotBeVisited);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j, cannotBeVisited);
            }
            if (grid[rows - 1][j] == 1) {
                dfs(grid, rows - 1, j, cannotBeVisited);
            }
        }

        // Count remaining 1s that are not marked
        int count = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 1 && !cannotBeVisited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int r, int c, boolean[][] cannotBeVisited) {
        int rows = grid.length;
        int cols = grid[0].length;

        cannotBeVisited[r][c] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                grid[nr][nc] == 1 && !cannotBeVisited[nr][nc]) {
                dfs(grid, nr, nc, cannotBeVisited);
            }
        }
    }
}
