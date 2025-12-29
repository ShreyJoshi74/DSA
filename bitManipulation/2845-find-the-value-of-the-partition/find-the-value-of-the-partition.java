class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            int partition = nums[i] - nums[i - 1];
            min = Math.min(min,partition);
        }
        return min;

    }
}