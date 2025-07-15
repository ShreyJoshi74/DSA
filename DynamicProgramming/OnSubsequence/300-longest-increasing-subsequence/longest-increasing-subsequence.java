class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        for(int i  =0 ; i < nums.length; i++){
            dp[i] = 1;
            hash[i] = i;
        }
        if(nums.length == 1) return 1;
        int max = 1;
        int lastIndex = 0;
        for(int i = 0; i <nums.length; i++){
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }

        }
       
        while(hash[lastIndex] != lastIndex){
            System.out.print(nums[lastIndex] + " ");
            lastIndex = hash[lastIndex];
        }
        System.out.println(nums[lastIndex]);
        return max;
    }
}