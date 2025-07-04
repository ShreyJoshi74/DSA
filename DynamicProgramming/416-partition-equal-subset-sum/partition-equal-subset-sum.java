class Solution {
    public boolean f(int[] nums,int left,int right,int i,Boolean[][] dp){
        if(right == left) {
            dp[i][left] = true;
            return true;
        }
        if(i == 0){
            // taken
            if(left - nums[i]== right + nums[i]){
                dp[0][left] = true;
                return true;
            }
            else {
                dp[0][left] = false;
                return false;
            }
        }
        if(dp[i][left] != null) return dp[i][left];
        boolean notTaken = f(nums,left,right,i-1,dp);
        boolean taken = false;
        if(i>0){
            taken = f(nums,left - nums[i],right + nums[i],i-1,dp);
        }
        dp[i][left] = notTaken || taken;
        return notTaken || taken;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int s : nums) sum += s;
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        
        return f(nums,sum,0,nums.length -1,dp);

    }
}