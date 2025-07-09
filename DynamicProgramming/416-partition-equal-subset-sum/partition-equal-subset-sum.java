class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum += i;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for(int i = 0; i < nums.length; i++) dp[i][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true;
        for(int i = 1; i < nums.length; i++){
            for(int goal= 1; goal <= target; goal++){
                //not taken
                boolean notTaken = dp[i-1][goal];
                //Taken
                boolean taken = false;
                if(nums[i] <= goal) taken = dp[i-1][goal - nums[i]];
                dp[i][goal] = taken || notTaken;
            }
        }
        return dp[nums.length - 1][target];
    }
}