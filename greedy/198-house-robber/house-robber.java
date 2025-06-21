class Solution {
    public int func(int[] nums,int[] dp,int index){
        if(index >= nums.length) return 0;
        if(dp[index] != -1) return dp[index];
        for(int i = index; i < nums.length; i++){
            int w1 = func(nums,dp,i + 1);
            int w2 = nums[i] + func(nums,dp,i + 2);
            dp[i] = Math.max(w1,w2);
            return dp[i];
        }
        return -1;
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return func(nums,dp,0);
    }
}