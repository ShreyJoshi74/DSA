class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int mid = (n + 1) / 2;
        int left = mid - 1;       // end of first half (smaller elements)
        int right = n - 1;        // end of second half (larger elements)

        // Fill nums from largest to smallest in a zig-zag manner
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--];
            } else {
                nums[i] = sorted[right--];
            }
        }
    }
}
