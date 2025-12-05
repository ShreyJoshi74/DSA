class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        int count = 0;
        for(int ele : nums) sum += ele;
        
        for(int i = 0; i < nums.length - 1; i++){
            leftSum += nums[i];

            if((leftSum - (sum - leftSum)) % 2 == 0) count++;
        }
        return count;
    }
}