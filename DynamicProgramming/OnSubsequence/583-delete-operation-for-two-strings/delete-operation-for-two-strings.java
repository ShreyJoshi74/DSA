class Solution {
    int len1; // globally declaring length of strings
    int len2;
    // we will find maximum common subsequence and then return maxlength - subsequence(cnt)
    public int f(int i,int j,String str1,String str2,int[][] dp){
        if(i >= len1 || j >= len2 ) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int cnt = 0;
        if(str1.charAt(i) == str2.charAt(j)){
            cnt = 1 + f(i+1,j+1,str1,str2,dp);
            return dp[i][j] = cnt;
        }else{
            cnt = Math.max(f(i+1,j,str1,str2,dp),f(i,j+1,str1,str2,dp));
            return dp[i][j] = cnt;
        }
    }
    public int minDistance(String word1, String word2) {
        len1 = word1.length();
        len2 = word2.length();
        int[][] dp = new int[len1][len2];
        for(int i = 0; i < len1 ; i++) Arrays.fill(dp[i],-1);
        
        return len1 + len2 - 2 * f(0,0,word1,word2,dp);
        
    }
}