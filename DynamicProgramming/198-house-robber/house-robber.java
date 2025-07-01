class Solution {
    // public int func(int[] nums,int[] dp,int index){
    //     if(index >= nums.length) return 0;
    //     if(dp[index] != -1) return dp[index];
        
    //         int w1 = func(nums,dp,index + 1);
    //         int w2 = nums[index] + func(nums,dp,index + 2);
    //         dp[index] = Math.max(w1,w2);
    //         return dp[index];
        

    // }
    // public int rob(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     Arrays.fill(dp,-1);
    //     return func(nums,dp,0);
    // }
    public int rob(int[] nums){
        int[] dp = new int[nums.length + 2];
        dp[nums.length] = 0;
        dp[nums.length + 1] = 0;
        for(int i =  nums.length - 1; i>= 0; i--){
            int max = Integer.MIN_VALUE;
            if(i + 1 <= dp.length) max = Math.max(max,dp[i + 1]);
            if(i + 2 <= dp.length) max = Math.max(max,dp[i + 2] + nums[i]);
            dp[i] = max;
        }
        return dp[0];
    }
}