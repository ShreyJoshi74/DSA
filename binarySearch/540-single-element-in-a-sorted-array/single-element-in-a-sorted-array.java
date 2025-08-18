class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int l = 0,h = n - 1,mid = 0;
        while(l <= h){
            mid = (l + h)/2;
            if(arr[mid-1] != arr[mid] && arr[mid+1] != arr[mid] ) return arr[mid];
            if(mid % 2 == 0 && arr[mid] == arr[mid + 1] || mid % 2 == 1 && arr[mid] == arr[mid - 1]) l = mid + 1;
            else h = mid - 1;
        }
        return -1;
    }
}