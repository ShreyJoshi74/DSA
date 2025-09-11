class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1)/2;
        int n = n1 + n2;
        while(low <= high){
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            r1 = (mid1 < n1) ? nums1[mid1] :Integer.MAX_VALUE;
            r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;
            l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1) return Math.max(l1,l2);
                return (double) (Math.max(l1,l2) + Math.min(r1,r2))/2;
            }
            else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
}