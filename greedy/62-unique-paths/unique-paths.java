class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i],-1);
        }
        return mov(dp,0,0);
    }
    public int mov(int[][] dp,int i,int j){
        if(i == dp.length-1 && j == dp[0].length -1) return 1;
        if(i >= dp.length || j >= dp[0].length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int t = mov(dp,i+1,j);
        int v = mov(dp,i,j+1);
        dp[i][j] = t + v;
        return dp[i][j];

    }
}