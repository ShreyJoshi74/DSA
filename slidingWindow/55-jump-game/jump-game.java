class Solution {
    public boolean canJump(int[] nums) {
        boolean state = true;
        int req = 1;
        for(int i = nums.length - 2; i>= 0; i--){
            if(nums[i] >= req){
                state = true;
                req = 1;
            }
            else{
                state = false;
                req++;
            }
        }
        return state;
    }
}