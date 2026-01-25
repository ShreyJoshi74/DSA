class Solution {
    public int minimumDifference(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0;
        int j = k - 1;
        while(j < nums.length){
            min = Math.min(min, nums[j] - nums[i]);
            i++;
            j++;
        }
        return min;
    }
}