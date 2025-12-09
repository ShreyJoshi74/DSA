class Solution {
    private static final int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for (int v : nums) {
            if (v > maxVal) maxVal = v;
        }

        long[] left = new long[maxVal + 1];
        long[] right = new long[maxVal + 1];

        // Initialize right frequency
        for (int v : nums) {
            right[v]++;
        }

        long ans = 0L;

        for (int j = 0; j < n; j++) {
            int x = nums[j];
            // Remove current element from right side
            right[x]--;

            int target = x << 1; // 2 * x
            if (target <= maxVal) {
                long leftCount = left[target];
                long rightCount = right[target];
                ans = (ans + (leftCount % MOD) * (rightCount % MOD)) % MOD;
            }

            // Add current element to left side
            left[x]++;
        }

        return (int) ans;
    }
}
