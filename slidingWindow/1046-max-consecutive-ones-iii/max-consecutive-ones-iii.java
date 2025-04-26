class Solution {
    public int longestOnes(int[] nums, int k) {
        int j = 0;
        int count  = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
                maxCount = Math.max(count,maxCount);
            }else{
                if(k > 0){
                    k--;
                    count++;
                    maxCount = Math.max(count,maxCount);
                }else{
                    
                    while(nums[j] != 0){
                        j++;
                        count--;
                    }
                    j++;
                }
            }
        }
        return maxCount;
    }
}