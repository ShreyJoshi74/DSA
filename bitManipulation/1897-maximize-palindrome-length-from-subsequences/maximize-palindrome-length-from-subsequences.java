class Solution {
    int dp[][];

    public int func(String boss,int i, int j){
        if(i == j ) return 1;
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];    

        if(boss.charAt(i) == boss.charAt(j)){
     
            return this.dp[i][j] = 2 + func(boss,i+1,j-1);
        }
        else{
            int first = func(boss, i + 1, j);
            int second = func(boss,i,j-1);
            return this.dp[i][j] =  Math.max(first,second);
        }
        
    }
    public int longestPalindrome(String word1, String word2) {
        String boss = word1 + word2;
        int n = boss.length();
        this.dp = new int[n][n];
        for(int i = 0; i < n ; i++) Arrays.fill(dp[i],-1);
        int ans = 0;
        String s = boss;
        int split = word1.length();
        func(boss, 0 , n-1);
         for (int i = 0; i < split; i++) {
            for (int j = split; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}