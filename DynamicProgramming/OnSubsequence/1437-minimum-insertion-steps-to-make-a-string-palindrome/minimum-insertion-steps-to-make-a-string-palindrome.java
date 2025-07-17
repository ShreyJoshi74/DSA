class Solution {
    public int f(int i,int j,String s,int[][] dp){
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            int cnt = 2 + f(i + 1, j - 1,s,dp);
            return dp[i][j] = cnt;
        }else{
            int cnt;
            cnt = Math.max(f(i+1,j,s,dp),f(i,j-1,s,dp));
            return dp[i][j] = cnt;
        }
    }
    public int minInsertions(String s) {
        int t = s.length();
        int[][] dp = new int[t][t];
        for(int i = 0; i < t; i++) Arrays.fill(dp[i] , -1);
        return t - f(0,t - 1,s,dp);
        
    }
}