// cooldown hua toh sidha next index;
// phir ek constrain buy kr sakta hoon yaa sell kr sakta hoon
// 1 -> cooldown 0 -> can buy
// 1 -> can buy 0 -> can sell
class Solution {
    public int f(int i,int action,int[] prices,int[][]dp){
        if(i >= prices.length) return 0;
        if(i == prices.length - 1){
            
                if(action == 0) return prices[i];
                if(action == 1) return 0;
            
        }
        if(dp[i][action] != -1) return dp[i][action];
        
            if(action == 1){
                return dp[i][action] = Math.max(-prices[i] + f(i+1,0,prices,dp),f(i+1,action,prices,dp));
            }else{
                return dp[i][action] = Math.max(prices[i] + f(i+2,1,prices,dp),f(i+1,action,prices,dp));
            }
        
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            
                Arrays.fill(dp[i],-1);
            
        }
        return f(0,1,prices,dp);
    }
}