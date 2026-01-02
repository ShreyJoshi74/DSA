class Solution {

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    boolean isPossible(long T, int[] d, int[] r) {
        long cap1 = T - T / r[0];
        long cap2 = T - T / r[1];

        if (cap1 < d[0] || cap2 < d[1]) return false;

        long commonBlocked = T / lcm(r[0], r[1]);
        long usable = T - commonBlocked;

        return usable >= (long)d[0] + d[1];
    }

    public long minimumTime(int[] d, int[] r) {
        long low = 0;
        long high = (long)(d[0] + d[1]) * Math.max(r[0], r[1]) * 2;
        long ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (isPossible(mid, d, r)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
