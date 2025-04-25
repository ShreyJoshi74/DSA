class Solution {
    public int subArrays(int[] nums,int goal){
        int r = 0,j = 0,cnt = 0,sum = 0;
        while(r < nums.length){
            if(goal < 0) return 0;
            sum += nums[r];
            while(sum > goal){
                sum -= nums[j];
                j++;
            }
            cnt = cnt + (r - j + 1);
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
    
        
        return subArrays(nums,goal) - subArrays(nums,goal - 1);
    }
}