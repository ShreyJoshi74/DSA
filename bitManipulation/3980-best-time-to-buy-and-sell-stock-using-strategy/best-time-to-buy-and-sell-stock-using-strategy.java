class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // Step 1: baseline profit
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
        }

        // Step 2: precompute gain arrays
        long[] firstGain = new long[n];
        long[] secondGain = new long[n];
        for (int i = 0; i < n; i++) {
            firstGain[i] = (long)(0 - strategy[i]) * prices[i];  // forced hold
            secondGain[i] = (long)(1 - strategy[i]) * prices[i]; // forced sell
        }

        // Step 3: prefix sums
        long[] prefFirst = new long[n + 1];
        long[] prefSecond = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefFirst[i + 1] = prefFirst[i] + firstGain[i];
            prefSecond[i + 1] = prefSecond[i] + secondGain[i];
        }

        // Step 4: check all windows
        long maxPro = base; // no modification
        for (int i = 0; i + k <= n; i++) {
            long delta = (prefFirst[i + k/2] - prefFirst[i])
                       + (prefSecond[i + k] - prefSecond[i + k/2]);
            maxPro = Math.max(maxPro, base + delta);
        }

        return maxPro;
    }
}