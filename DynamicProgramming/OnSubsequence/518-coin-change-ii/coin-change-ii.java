class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i <= amount ; i++){
            if(i % coins[0] == 0) dp[0][i] = 1;
        }
        for(int i = 1; i < coins.length; i++){
            for(int t = 0; t <= amount; t++){
                int taken = 0;
                if(coins[i] <= t) taken = dp[i][t - coins[i]];
                int notTaken = dp[i-1][t];
                dp[i][t] = taken + notTaken;
            }
        }
        return dp[coins.length - 1][amount];
    }
}