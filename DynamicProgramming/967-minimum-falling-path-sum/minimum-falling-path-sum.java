class Solution {
    // public void roll(int[][] dp,int[][] mat,int i,int j,int sum){
    //     if(i < 0) return;
    //     if(sum + mat[i][j] < dp[i][j]){
    //         dp[i][j] = sum + mat[i][j];
    //         for(int t= -1; t <= 1; t++){
    //             int nj = j + t;
    //             if(nj >= 0 && nj < mat[0].length){
    //                 roll(dp,mat,i-1,nj,dp[i][j]);
    //             }
    //         }
    //     }
    // }
    // public int minFallingPathSum(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     int[][] dp = new int[m][n];
    //     for(int i = 0; i < m; i++){
    //         Arrays.fill(dp[i],Integer.MAX_VALUE);
    //     }
    //     for(int i=0 ; i < n; i++){
    //         roll(dp,matrix,m-1,i,0);
    //     }
    //     int path = Integer.MAX_VALUE;
    //     for(int i=0 ; i < n; i++){
    //         path = Math.min(path,dp[0][i]);
    //     }
    //     return path;

    // }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[m-1][i] = matrix[m-1][i];
        }
        for(int i = m-2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int x = Integer.MAX_VALUE;
                if(j-1 >= 0) x = Math.min(x,dp[i+1][j-1]);
                if(j >= 0) x = Math.min(x,dp[i+1][j]);
                if(j+1 < n) x = Math.min(x,dp[i+1][j+1]);
                dp[i][j] = matrix[i][j] + x;
            }
        }
        int offset = 0;
        for(int i = 1; i < n; i++){
            if(dp[0][i] < dp[0][offset]){
                offset = i;
            }
        }
        return dp[0][offset];

    }
}