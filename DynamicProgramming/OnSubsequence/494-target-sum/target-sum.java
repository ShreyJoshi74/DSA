class Solution {
    // this question can be reduce to partition of array in to two subset such that there differece is D;
    public static long f(int ind,int target,int[] nums,long[][] dp){
		if(ind == 0){
			if(target == 0 && nums[0] == 0) return 2;
			if(target == 0) return 1;
			if(target == nums[ind]) return 1;
			return 0;
		}
		if(dp[ind][target] != -1) return dp[ind][target];
		long notTaken = f(ind - 1,target,nums,dp);
		long taken = 0;
		if(nums[ind] <= target) taken = f(ind -1,target - nums[ind],nums,dp);

		return dp[ind][target] = taken + notTaken;
	}
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i : nums) total += i;
        int newTarget;
        if(total - target >= 0 && (total - target) % 2 == 0) newTarget = (total - target) / 2;
        else return 0;
        long[][] dp = new long[nums.length][newTarget + 1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return (int) f(nums.length - 1,newTarget,nums,dp);
    }
}