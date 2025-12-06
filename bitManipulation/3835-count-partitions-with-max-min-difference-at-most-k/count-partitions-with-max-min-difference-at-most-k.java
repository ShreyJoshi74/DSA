import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> maxDeque = new ArrayDeque<>(); // stores indices, max at front
        Deque<Integer> minDeque = new ArrayDeque<>(); // stores indices, min at front
        
        long[] dp = new long[n + 1];      // dp[i] = ways to partition nums[0..i-1]
        long[] prefix = new long[n + 1];  // prefix[i] = dp[0] + ... + dp[i]

        dp[0] = 1;
        prefix[0] = 1;

        int left = 0;

        for (int right = 0; right < n; right++) {
            int element = nums[right];

            // Maintain decreasing deque for max (store indices, compare values)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= element) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // Maintain increasing deque for min (store indices, compare values)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= element) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // Shrink window until max - min <= k
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                   nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }

            // dp[right + 1] = sum of dp[left..right]
            long ways = prefix[right];
            if (left > 0) {
                ways = (ways - prefix[left - 1] + MOD) % MOD;
            }

            dp[right + 1] = ways;
            prefix[right + 1] = (prefix[right] + dp[right + 1]) % MOD;
        }

        return (int) (dp[n] % MOD);
    }
}
