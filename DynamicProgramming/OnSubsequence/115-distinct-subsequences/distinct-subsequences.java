class Solution {
    String str1,str2;
    int len1,len2;
    // public int f(int i,int j,int[][] dp){
    //     if(j >= len2) return 1;
    //     if(i >= len1 ) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
        
        
        
    //     int notTaken = f(i + 1,j,dp);
    //     int taken = 0;
    //     if(str1.charAt(i) == str2.charAt(j)){
    //         taken = f(i+1,j+1,dp);
    //     }
    //     return taken+notTaken;

    // }
    public int numDistinct(String s, String t) {
        str1 = s;
        str2 = t;
        len1 = s.length();
        len2 = t.length();
        // int[][] dp = new int[str1.length()][str2.length()];
        // for(int i = 0; i < len1; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return f(0,0,dp);
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len2; i++) dp[len1][i] = 0;
        for(int i = 0; i <= len1 ; i++){
            dp[i][len2] = 1;
        }
        for(int i = len1 - 1 ; i >= 0; i--){
            for(int j = len2 -1; j >= 0; j--){
                int notTaken = dp[i+1][j];
                int taken = 0;
                if(str1.charAt(i) == str2.charAt(j)){
                    taken = dp[i+1][j+1];
                }
                dp[i][j] = taken + notTaken;
            }
        }
        return dp[0][0];
        

    }
}