class Solution {
    public int subArrays(int[] nums,int k){
        int r = 0, j = 0, cnt = 0, sum = 0;
        while( r < nums.length){
            if(k < 0) return 0;
            if(nums[r] % 2 != 0) cnt++;
            while(cnt > k ){
                if(nums[j] % 2 != 0) cnt--;
                j++;
            }
            sum = sum + r - j + 1;
            r++;
        }
        return sum;
    }
    public int numberOfSubarrays(int[] nums, int k) {
            return subArrays(nums,k) - subArrays(nums,k-1);
    }
}