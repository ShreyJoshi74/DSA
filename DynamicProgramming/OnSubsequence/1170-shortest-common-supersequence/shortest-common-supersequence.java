class Solution {
    int len1;
    int len2;
    public int f(int i,int j,String str1,String str2,int[][] dp){
        if(i >= len1 || j >= len2) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = 1 + f(i+1,j+1,str1,str2,dp);
        }else{
            return dp[i][j] = Math.max(f(i+1,j,str1,str2,dp),f(i,j+1,str1,str2,dp));
        }

    }
    public String shortestCommonSupersequence(String str1, String str2) {
        len1 = str1.length();
        len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++) Arrays.fill(dp[i],-1);
        int len = f(0,0,str1,str2,dp);
        String common = "";
        int i = 0,j = 0;
        while(i < len1 && j < len2){
            if(str1.charAt(i) == str2.charAt(j)){
                common += str1.charAt(i);
                i++;
                j++;
            }else{
                if(dp[i+1][j] > dp[i][j+1]){
                    common += str1.charAt(i);
                    i++;

                }else{
                    common+= str2.charAt(j);
                    j++;
                }
            }
        }
        
        while(i < len1) {
            common += str1.charAt(i);
            i++;
        }
        while(j < len2){
            common += str2.charAt(j);
            j++;
        }

        return common;
    }
}
