class Solution {
    public int f(int ind,int T,int[] coins,int[][] dp){
        if(T == 0) return 0;

        if(ind == 0){
            if(T % coins[0] == 0) return T/coins[0];
            else return (int)1e9;
        }
        if(dp[ind][T] != -1) return dp[ind][T];
        int notTaken = f(ind - 1,T,coins,dp);
        int taken = (int) 1e9;
        if(coins[ind] <= T){
            taken = 1 + f(ind,T - coins[ind],coins,dp);
        }
        return dp[ind][T] = Math.min(notTaken,taken);

    }
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length][amount + 1];
        
        for(int i = 0; i < coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int out = f(coins.length -1,amount,coins,dp);
        return (out >= 1e9) ? -1 : out;
    }
}