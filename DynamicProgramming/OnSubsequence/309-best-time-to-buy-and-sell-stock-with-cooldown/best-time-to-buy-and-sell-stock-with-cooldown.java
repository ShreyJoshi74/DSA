// cooldown hua toh sidha next index;
// phir ek constrain buy kr sakta hoon yaa sell kr sakta hoon
// 1 -> cooldown 0 -> can buy
// 1 -> can buy 0 -> can sell
class Solution {
    public int f(int i,int action,int cooldown,int[] prices,int[][][] dp){
        if(i == prices.length - 1){
            if(cooldown == 1) return 0;
            else{
                if(action == 0) return prices[i];
                if(action == 1) return 0;
            }
        }
        if(dp[i][action][cooldown] != -1) return dp[i][action][cooldown];
        if(cooldown == 1){
            return dp[i][action][cooldown] = f(i+1,action,0,prices,dp);
        }else{
            if(action == 1){
                return dp[i][action][cooldown] = Math.max(-prices[i] + f(i+1,0,0,prices,dp),f(i+1,action,cooldown,prices,dp));
            }else{
                return dp[i][action][cooldown] = Math.max(prices[i] + f(i+1,1,1,prices,dp),f(i+1,action,cooldown,prices,dp));
            }
        }
    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,1,0,prices,dp);
    }
}