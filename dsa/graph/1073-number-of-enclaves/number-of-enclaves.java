class Solution {
    public int numEnclaves(int[][] grid) {
         int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] cannotBeVisited = new boolean[rows][cols];
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
        int count = 0;
        for(int i = 1 ; i < grid.length-1 ; i++){
            for (int j = 1 ; j < grid[0].length-1 ; j++){
                if(grid[i][j]==1 && !cannotBeVisited[i][j]){
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfs(int[][] grid, int r, int c, boolean[][] cannotBeVisited){
        cannotBeVisited[r][c]= true;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] s : dir){
            int nr = r + s[0];
            int nc = c + s[1];
            if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length){
                if(grid[nr][nc] == 1 && !cannotBeVisited[nr][nc]){
                    grid[nr][nc] = 0;
                    dfs(grid,nr,nc,cannotBeVisited);
                }
            }
        }
    }
}