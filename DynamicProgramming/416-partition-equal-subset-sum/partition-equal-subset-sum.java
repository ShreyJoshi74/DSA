class Solution {
    public boolean f(int left,int right,int i,int[] nums,Boolean[][] dp){
        if(left == right) return true;
        if(dp[i][right] != null) return dp[i][right];
        if(i == 0 ){
            left += nums[0];
            right -= nums[0];
            if(left == right) return true;
            return false;

        }
        boolean notTaken = f(left,right,i-1,nums,dp);
        boolean taken = false;
        if(nums[i] <= right - nums[i]) {
            taken = f(left + nums[i],right - nums[i],i-1,nums,dp);
        }
        return dp[i][right] = taken || notTaken;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        return f(0,sum,nums.length-1,nums,dp);
    }
}