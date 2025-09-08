class Solution {
    public int f(int[] arr,int pages){
        int std = 1;
        int pagesStudent = 0;
        for(int i = 0; i < arr.length; i++){
            if(pagesStudent + arr[i] > pages){
                std++;
                pagesStudent = 0;
            }
            pagesStudent += arr[i];
        }
        return std;
    }
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i = 0;i < nums.length; i++){
            low = Math.max(nums[i],low);
            high += nums[i];
        }
        while(low <= high){
            int mid = (low + high)/2;
            int countStudent = f(nums,mid);
            if(countStudent > k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}