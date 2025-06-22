class Solution {
    public int roller(int[][] grid,int[][] dp,int i,int j){
        if(i == grid.length -1 && j == grid[0].length-1) return grid[grid.length-1][grid[0].length-1];
        if(dp[i][j] != -1) return dp[i][j];
        int path = Integer.MAX_VALUE;
        if(i + 1 <= grid.length -1) path =Math.min(path,grid[i][j] + roller(grid,dp, i+1, j));
        if(j + 1 <= grid[0].length-1)  path =Math.min(path,grid[i][j] + roller(grid,dp,i,j+1));
        dp[i][j] = path;
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i],-1);
        }
        return roller(grid,dp,0,0);
    }
}