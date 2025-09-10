class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int cnt = -1;
        int target2 = (n1 + n2) / 2;
        int i = 0;
        int j = 0;
        double ele1 = -1;
        double ele2 = -1;
        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                ele1 = ele2;
                ele2 = nums1[i++];
                cnt++;
            }else{
                ele1 = ele2;
                ele2 = nums2[j++];
                cnt++;
            }
            if(cnt == target2){
                if((n1 + n2) % 2 == 0) return (ele1 + ele2)/2;
                else return ele2;
            }
        }
        while(i < n1){
            ele1 = ele2;
            ele2 = nums1[i++];
            cnt++;
            if(cnt == target2){
                if((n1 + n2) % 2 == 0) return (ele1 + ele2)/2;
                else return ele2;
            }

        }
        while(j < n2){
            ele1 = ele2;
            ele2 = nums2[j++];
            cnt++;
            if(cnt == target2){
                if((n1 + n2) % 2 == 0) return (ele1 + ele2)/2;
                else return ele2;
            }

        }
        return 0;
    }
}