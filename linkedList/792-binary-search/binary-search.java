class Solution {

    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        int mid ;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(arr[mid] == target){
                ans = mid;
                return mid;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;

    }
}