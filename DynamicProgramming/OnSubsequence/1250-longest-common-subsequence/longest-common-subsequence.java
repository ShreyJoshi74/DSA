class Solution {
    public int f(int i,int j,int[][] dp,String text1,String text2){
        if(i >= text1.length()  || j >= text2.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
  
        if(text1.charAt(i) == text2.charAt(j)) return dp[i][j]= 1 + f(i+1,j+1,dp,text1,text2);
        else {
               return dp[i][j] =  Math.max(f(i+1,j,dp,text1,text2),f(i,j+1,dp,text1,text2));
        }
       

        
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++) Arrays.fill(dp[i],-1);
        return f(0,0,dp,text1,text2);

        
    }
}