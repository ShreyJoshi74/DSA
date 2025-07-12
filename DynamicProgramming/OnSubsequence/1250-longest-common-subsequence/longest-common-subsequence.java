class Solution {
    // memo + recur
    // public int f(int i,int j,int[][] dp,String text1,String text2){
    //     if(i >= text1.length()  || j >= text2.length()) return 0;
        
    //     if(dp[i][j] != -1) return dp[i][j];
    //     // ek baar i
    //     int ikeSath = 0;
    //     if(i  <= text1.length() - 1){
    //         if(text1.charAt(i) == text2.charAt(j)) ikeSath = 1 + f(i+1,j+1,dp,text1,text2);
    //         else ikeSath = f(i+1,j,dp,text1,text2);

    //     }
    //     //ek baar j 
    //     int jkeSath = 0;
    //     if(j  <= text2.length() - 1){
    //         if(text1.charAt(i) == text2.charAt(j)) jkeSath = 1 + f(i+1,j+1,dp,text1,text2);
    //         else jkeSath = f(i,j+1,dp,text1,text2);
    //     }
        
    //     return dp[i][j] = Math.max(jkeSath , ikeSath);
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i <= text1.length(); i++) dp[i][text2.length()] = 0;
        for(int i = 0; i <= text2.length(); i++) dp[text1.length()][i] = 0;
        for(int j = text2.length() - 1 ; j >= 0; j--){
            for(int i = text1.length() - 1; i >= 0; i--){
                if(text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
                
        
            }
        }
        return dp[0][0];

        
    }
}