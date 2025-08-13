class Solution {
    // i will find lowerBound
    // arr[idx] >= target
    // idx --> output
    public int searchInsert(int[] nums, int target) {
        int l = 0,h = nums.length - 1;
        int mid;
        int ans = nums.length;
        while(l <= h){
            mid = l + (h - l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                ans = mid;
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}