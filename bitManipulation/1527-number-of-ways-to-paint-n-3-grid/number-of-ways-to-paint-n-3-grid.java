class Solution {
    int[][][][] dp;
    int n;
    int MOD = 1_000_000_007;
    public int func(int row, int prev0,int prev1, int prev2){
        if(row == n) return 1;
        if(dp[row][prev0+1][prev1+1][prev2+1] != -1) return dp[row][prev0+1][prev1+1][prev2+1];

        int ways = 0;

        for(int col1 = 0; col1 < 3; col1++){
            if(col1 == prev0) continue;

            for(int col2 = 0; col2 < 3; col2++){
                if(col1 == col2 || col2 == prev1) continue;

                for(int col3 = 0; col3 < 3; col3++){
                    if(col3 == col2 || col3 == prev2) continue;

                    ways =(ways + func(row+1,col1,col2,col3)) % MOD;
                }
            }
        }
        return dp[row][prev0+1][prev1+1][prev2+1] = ways % MOD;
    }
    public int numOfWays(int n) {
        this.dp = new int[n][4][4][4];
        this.n = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }
        return func(0,-1,-1,-1);
    }
}