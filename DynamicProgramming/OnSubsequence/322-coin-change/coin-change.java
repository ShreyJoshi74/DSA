class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int t = 0; t <= amount ; t++){
            if(t % coins[0] == 0) dp[0][t] = t / coins[0];
            else dp[0][t] = (int) 1e9;
        }
        for(int i = 1; i < coins.length; i++){
            for(int t = 0; t <=  amount; t++){
                //taken
                int taken = (int) 1e9;
                if(t - coins[i] >= 0)
                    taken = 1 + dp[i][t - coins[i]];
                //not Taken
                int notTaken = dp[i-1][t];
                dp[i][t] = Math.min(taken,notTaken);
            }
        }
        int output = dp[coins.length - 1][amount];
        return (output != 1e9) ? output : -1;
    }
}