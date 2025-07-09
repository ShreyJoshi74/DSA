class Solution {
    public boolean f(int[] nums,int right,int i,Boolean[][] dp){
        if(right == 0) {
            return dp[i][right] = true;
        }
        if(i == 0){
            // taken
            if(nums[0] == right) return true;
            return false;
        }
        if(dp[i][right] != null) return dp[i][right];
        boolean notTaken = f(nums,right,i-1,dp);
        boolean taken = false;
        if(nums[i] <= right){
            taken = f(nums,right - nums[i],i-1,dp);
        }
        dp[i][right] = notTaken || taken;
        return notTaken || taken;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int s : nums) sum += s;
        if(sum % 2 != 0) return false;
        int target = sum / 2; // humne target ko aadha kr diya yaha pe
        Boolean[][] dp = new Boolean[nums.length][target+1];
        
        return f(nums,target,nums.length -1,dp);

    }
}