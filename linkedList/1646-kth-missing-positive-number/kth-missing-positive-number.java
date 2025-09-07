class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing;
        // at 0th posi checking if missing is already greater or equal to required
        missing = arr[0] - 1;
        if(missing >= k) return arr[0] - (missing - k + 1);
        int l = 0;
        int h = arr.length - 1;
        int mid = -1,ans = -1;
        while(l <= h){
            mid = (l + h)/2;
            missing = arr[mid] - (mid + 1);
            if(missing < k){
                ans = mid;
                l = mid + 1;
            }else h = mid - 1;
        }
        missing = arr[ans] - (ans + 1);
        return arr[ans] + (k - missing);
    }
}