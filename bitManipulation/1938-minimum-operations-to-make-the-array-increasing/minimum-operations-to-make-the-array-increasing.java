class Solution {
    public int minOperations(int[] nums) {
        if(nums.length == 1) return 0;
        int number = nums[0];
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > number){
                number = nums[i];
                continue;
            }
            int nextNumber = number+1;
            count += number + 1 - nums[i];
            number =nextNumber;
        }
        return count;
    }
}