class Solution {
    int m ; // column
    int n; // row
    String[] strs;
    int[][] dp;

    public int func(int i, int prev){
        if(i == m) return 0;

        if( dp[i][prev+1] != -1) return dp[i][prev + 1];

        int notTake = func(i + 1, prev);

        int take = Integer.MIN_VALUE;

        if(prev == -1) take = 1 + func(i + 1, i);
        else{
            boolean valid = true;

            
            for (int r = 0; r < n; r++) {
                if (strs[r].charAt(prev) > strs[r].charAt(i)) {
                    valid = false;
                    break;
                }
            }

            if(valid) 
                    take = 1 + func(i+1,i);
        }

        return dp[i][prev+1] = Math.max(take,notTake);
    }


    public int minDeletionSize(String[] strs) {
        
        this.m = strs[0].length();
        this.n = strs.length;

        this.strs = strs;
        this.dp = new int[m][m+1];
        for(int i = 0; i < m ; i++) Arrays.fill(dp[i],-1);
        return strs[0].length() - func(0,-1);
    }
}