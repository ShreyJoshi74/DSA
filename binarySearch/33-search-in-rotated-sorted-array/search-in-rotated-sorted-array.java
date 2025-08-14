class Solution {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1,mid = 0;
        int ans = -1;
        while(l < h){
            mid = l + (h-l)/2;
            if(nums[mid] > nums[h]){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        int pivot = nums[l];
        if(target >= pivot && target <= nums[nums.length - 1]){
            int nl = l;
            int nh = nums.length - 1;
            int nmid;
            while(nl <= nh){
                nmid = (nl + nh) / 2;
                if(nums[nmid] == target) return nmid;
                else if(nums[nmid] > target) nh = nmid - 1;
                else nl = nmid + 1;
            }
        }
        if(target >= nums[0] && l != 0 && target <= nums[l - 1]){
            int nl = 0;
            int nh = l-1;
            int nmid;
            while(nl <= nh){
                nmid = (nl + nh) / 2;
                if(nums[nmid] == target) return nmid;
                else if(nums[nmid] > target) nh = nmid - 1;
                else nl = nmid + 1;
            }
        }
        return -1;
    }
}