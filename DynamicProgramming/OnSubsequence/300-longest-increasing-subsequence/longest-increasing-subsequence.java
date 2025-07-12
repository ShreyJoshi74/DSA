class Solution {
    public int f(int i,int j,int[] nums,int[][] dp){
        if(i == nums.length - 1){
            if(j == -1 || nums[i] > nums[j]) return 1;
            return 0;
        }
        if(dp[i][j + 1] != -1) return dp[i][j+1];
        // notTaken
        int notTaken = f(i + 1,j,nums,dp);
        int taken = 0;
        if(j == -1 || nums[i] > nums[j]) taken = 1 + f(i + 1,i,nums,dp);
        return dp[i][j + 1] = Math.max(notTaken,taken);
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int i = 0; i < nums.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(0,-1,nums,dp);
    }
}