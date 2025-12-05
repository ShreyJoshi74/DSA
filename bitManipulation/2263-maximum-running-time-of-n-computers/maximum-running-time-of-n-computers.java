class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += b;
        }

        long low = 0, high = total / n;

        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            if (canRun(mid, n, batteries)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canRun(long time, int n, int[] batteries) {
        long usable = 0;
        for (int b : batteries) {
            usable += Math.min((long) b, time);
        }
        return usable >= time * n;
    }
}
