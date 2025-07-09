class Solution {
    public boolean canPartition(int[] nums) {
        // trying using 1D Array
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num : nums){
            for(int i = target ; i >= num ; i--){
                dp[i] = dp[i] | dp[i - num];
            }
        }
        return dp[target];

    }
}