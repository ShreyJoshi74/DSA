class Solution {
    public int fO(int[] arr,int target){
        int ans = -1;
        int l = 0, h = arr.length - 1;
        int mid;
        while(l <= h){
            mid = l + (h - l)/2;
            if(arr[mid] == target){
                ans = mid;
                h = mid - 1;
            }else if(arr[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int lO(int[] arr,int target){
        int ans = -1;
        int l = 0, h = arr.length - 1;
        int mid;
        while(l <= h){
            mid = l + (h - l)/2;
            if(arr[mid] == target){
                ans = mid;
                l = mid + 1;
            }else if(arr[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[2];
        output[0] = fO(nums,target);
        output[1] = lO(nums,target);
        return output;
    }
}
