class Solution {
    public int f(int ind,int past,int[] nums,int[][] dp){
        if(ind >= nums.length) return nums[past];
        if(ind + 1 >= nums.length) return Math.max(nums[past],nums[ind]);
        if(dp[ind][past] != -1) return dp[ind][past];

        int best = Integer.MAX_VALUE;

        best = Math.min(Math.max(nums[past],nums[ind]) + f(ind + 2,ind+1,nums,dp),best);
        best = Math.min(Math.max(nums[ind],nums[ind+1]) + f(ind + 2,past,nums,dp),best);
        best = Math.min(Math.max(nums[past],nums[ind+1]) + f(ind + 2,ind,nums,dp),best);
        return dp[ind][past] = best;
    }
    public int minCost(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i],-1);
        return f(1,0,nums,dp);
    }
}