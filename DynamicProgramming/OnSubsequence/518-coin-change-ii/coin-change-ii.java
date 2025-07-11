class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i =0; i < coins.length; i++){
            Arrays.fill(dp[i],-1);
        }
        // for(int i = 0; i <= amount ; i++){
        //     if(i % coins[0] == 0) dp[0][i] = 1;
        // }
        // for(int i = 1; i < coins.length; i++){
        //     for(int t = 0; t <= amount; t++){
        //         int taken = 0;
        //         if(coins[i] <= t) taken = dp[i][t - coins[i]];
        //         int notTaken = dp[i-1][t];
        //         dp[i][t] = taken + notTaken;
        //     }
        // }
        return f(coins.length - 1,amount,coins,dp);
    }
    public int f(int ind,int target,int[] coins,int[][] dp){
        if(target == 0) return 1;
        if(ind == 0){
            if(target % coins[ind] == 0) return 1;
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int notTaken = f(ind-1,target,coins,dp);
        int taken = 0;
        if(coins[ind] <= target) taken = f(ind,target - coins[ind],coins,dp);
        return dp[ind][target] = taken + notTaken;
    }
}