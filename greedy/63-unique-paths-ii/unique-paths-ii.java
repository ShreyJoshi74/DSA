class Solution {
    public int dfs(int[][] obstacleGrid,int[][] dp,int i,int j){
        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length - 1 ) return 1;
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length ) return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int down = dfs(obstacleGrid,dp,i+1,j);
        int up = dfs(obstacleGrid,dp,i,j+1);
        dp[i][j] = down + up;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length ;i++){
            Arrays.fill(dp[i],-1);
        }
        int m = obstacleGrid.length-1;
        int n = obstacleGrid[0].length-1;
        if(obstacleGrid[m][n] == 1) return 0;
        return dfs(obstacleGrid,dp,0,0);
    }
}