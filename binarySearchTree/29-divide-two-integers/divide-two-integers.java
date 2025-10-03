class Solution {
    public int divide(int dividend, int divisor) {
        // Special overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;

        // Determine sign
        boolean sign = (dividend >= 0) == (divisor >= 0);

        // Use long to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int quotient = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            quotient += 1 << cnt;
            n -= d << cnt;
        }

        return sign ? quotient : -quotient;
    }
}
