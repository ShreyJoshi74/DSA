class Solution {
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for(int i = 0; i < m; i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return mov(dp,0,0);
    // }
    // public int mov(int[][] dp,int i,int j){
    //     if(i == dp.length-1 && j == dp[0].length -1) return 1;
    //     if(i >= dp.length || j >= dp[0].length) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int t = mov(dp,i+1,j);
    //     int v = mov(dp,i,j+1);
    //     dp[i][j] = t + v;
    //     return dp[i][j];

    // }
    public int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i],0);
        }
        dp[m-1][n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(j+1 <= n-1) dp[i][j] += dp[i][j+1];
                if(i+1 <= m-1) dp[i][j] += dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}