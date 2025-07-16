class Solution {
    public int f(int i,int action,int k,int[] prices,int[][][] dp){
        // 1 == buy && 0 == sale
        if(k == 0) return 0;
        if(i == prices.length - 1){
            if(action == 1) return 0;
            if(action == 0) return prices[i];
        }
        if(dp[i][action][k] != -1) return dp[i][action][k];
        if(action == 1){
            int x;
            x = -prices[i] + f(i + 1,0,k,prices,dp);
            x = Math.max(x,f(i + 1,1,k,prices,dp));
            return dp[i][action][k] = x;
        }else{
            int x;
            x = prices[i] + f(i + 1, 1,k-1,prices,dp);
            x = Math.max(x,f(i + 1,0,k,prices,dp));
            return dp[i][action][k] = x;
        }

    }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,1,k,prices,dp);
    }
}