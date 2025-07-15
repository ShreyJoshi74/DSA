class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];

        // Initialization
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i; // initially point to itself
        }

        int maxLen = 1;
        int lastIndex = 0;

        // Fill dp and hash arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct the sequence
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lis.add(nums[lastIndex]);
        }

        // Print in correct order
        Collections.reverse(lis);
        System.out.println("LIS: " + lis);

        return maxLen;
    }
}
