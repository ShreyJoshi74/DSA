class Solution {
    public int f(long n, Map<Long, Integer> memo) {
        if (n == 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        int res;
        if (n % 2 == 0) {
            res = 1 + f(n / 2, memo);
        } else {
            res = 1 + Math.min(f(n + 1, memo), f(n - 1, memo));
        }
        memo.put(n, res);
        return res;
    }

    public int integerReplacement(int n) {
        return f((long) n, new HashMap<>());
    }
}
