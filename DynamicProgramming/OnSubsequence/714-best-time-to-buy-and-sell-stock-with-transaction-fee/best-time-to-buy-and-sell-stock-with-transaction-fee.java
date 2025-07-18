// 0 -> buy 1 -> sell
class Solution {
    int fee;
    int[] prices;
    int[][] dp;
    public int f(int i,int action){
        if(i == prices.length-1){
            if(action == 0) return 0;
            if(action == 1) return prices[i] - fee;
        }
        if(dp[i][action] != -1) return dp[i][action];
        if(action == 0){
            return dp[i][action] = Math.max(f(i+1,action),-prices[i]+f(i+1,1));
        }else{
            return dp[i][action] = Math.max(prices[i] - fee + f(i+1,0),f(i+1,1));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++) Arrays.fill(dp[i],-1);
        return f(0,0);
    }
}