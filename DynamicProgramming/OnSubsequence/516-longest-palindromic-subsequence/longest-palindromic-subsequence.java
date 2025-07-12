class Solution {
    public int f(int i,int j,String s,int[][] dp){
        if(i > j) return 0;
        if(i == j){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            int cnt = 2 + f(i+1,j-1,s,dp);
            return dp[i][j] = cnt;
        }else{
            int max = 0;
            max = Math.max( f(i+1,j,s,dp) , f(i,j-1,s,dp));
            return dp[i][j] = max;
        }
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(dp[i],-1);
        }
        // for(int i = 0; i < s.length(); i++){
        //     for(int j = 0; j <= i ; j++){
        //         if(i == j) dp[i][j] = 1;
        //         else dp[i][j] = 0;
        //     }
        // }
        return f(0,s.length()-1,s,dp);
    }
}