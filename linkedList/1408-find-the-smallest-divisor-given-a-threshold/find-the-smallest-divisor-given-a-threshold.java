class Solution {
    public int outputAtDivisor(int[] arr, int divisor){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += (arr[i] + divisor - 1)/divisor;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int h = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) h = Math.max(nums[i],h);
        int ans = -1;
        while(l <= h){
            int mid = (l + h)/2;
            int result = outputAtDivisor(nums,mid);
            if(result <= threshold){
                ans = mid;
                h = mid -1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}