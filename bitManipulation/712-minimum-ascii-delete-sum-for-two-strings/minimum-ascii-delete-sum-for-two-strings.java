class Solution {
    public int func(int i, int j, String s1, String s2, int[][] dp){
        if(i == s1.length() && j == s2.length())   
            return 0;
        if(i == s1.length()){
            int rem = 0;
            while(j < s2.length()) rem += (int) s2.charAt(j++);
            return rem;
        }
        if(j == s2.length()){
            int rem = 0;
            while(i < s1.length()) rem += (int) s1.charAt(i++);
            return rem;
        }
            
        if(dp[i][j] != -1)
            return dp[i][j];
        
        // i nhi
        int iNhi = (int) s1.charAt(i) + func(i+1,j,s1,s2,dp);

        // j nhi
        int jNhi = (int) s2.charAt(j) + func(i,j+1,s1,s2,dp);

        int take = Integer.MAX_VALUE;

        if(s1.charAt(i) == s2.charAt(j))
            take = func(i+1,j+1,s1,s2,dp);
        
        return dp[i][j] = Math.min(take,Math.min(iNhi,jNhi));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // for(int i = 0; i < s1.length(); i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return func(0,0,s1,s2,dp);

        // trying bottom up approach

        int lenS1 = s1.length();
        int lenS2 = s2.length();
        dp[lenS1][lenS2] = 0;

        int rem = 0;
        for(int j = lenS2 - 1; j >= 0; j--){
            rem += (int) s2.charAt(j);
            dp[lenS1][j] = rem;
        }

        rem = 0;
        for(int i = lenS1 - 1; i >= 0; i--){
            rem += (int) s1.charAt(i);
            dp[i][lenS2] = rem;
        }

        for(int i = lenS1 - 1; i >= 0; i--){
            for(int j = lenS2 - 1; j>=0; j--){
                int take = Integer.MAX_VALUE;
                if(s1.charAt(i) == s2.charAt(j)) take = dp[i+1][j+1];
                dp[i][j] = Math.min(s1.charAt(i) + dp[i+1][j],
                                Math.min(s2.charAt(j) + dp[i][j+1], take)
                            );
            }
        }
        return dp[0][0];



    }
}