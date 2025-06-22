class Solution {
    public int func(int[] nums,int[] dp,int index,int k){
        if(index >= k) return 0;
        if(dp[index] != -1) return dp[index];
        
            int w1 = func(nums,dp,index + 1,k);
            int w2 = nums[index] + func(nums,dp,index + 2,k);
            dp[index] = Math.max(w1,w2);
            return dp[index];
        

    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int t = nums[0] + func(nums,dp,2,nums.length-1);
        Arrays.fill(dp,-1);
        int s = func(nums,dp,1,nums.length);
        return Math.max(t,s);
    }
}