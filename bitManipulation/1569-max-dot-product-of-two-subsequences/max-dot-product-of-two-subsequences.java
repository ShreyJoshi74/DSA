class Solution {
    int[][] dp;
    public int func(int[] nums1, int[] nums2, int i, int j ){
        if(i >= nums1.length || j >= nums2.length) return 0;

        if(this.dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        // notTake
        int nums1Nahi = func(nums1,nums2,i+1,j);
        int nums2Nahi = func(nums1,nums2,i,j+1);
        // take
        int take = nums1[i] * nums2[j] + func(nums1,nums2,i+1,j+1);

        return this.dp[i][j] = Math.max(take,Math.max(nums1Nahi,nums2Nahi));  


    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.dp = new int[nums1.length][nums2.length];
        for(int i = 0; i < nums1.length; i++) Arrays.fill(this.dp[i],Integer.MIN_VALUE);
        int output = Integer.MIN_VALUE;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int result = nums1[i] * nums2[j] + func(nums1,nums2,i+1,j+1);
                output = Math.max(output,result);
            }
        }
        return output;
    }
}