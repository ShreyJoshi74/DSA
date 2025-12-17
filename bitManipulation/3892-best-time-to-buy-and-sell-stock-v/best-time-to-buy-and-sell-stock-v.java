class Solution {
    int[] prices;
    int n;
    long[][][] dp;
    static final long NEG_INF = -(long)1e18;

    long dfs(int i, int state, int k) {
        if (k == 0 && state != 0) return NEG_INF;
        if (i == n) return state == 0 ? 0 : NEG_INF;

        if (dp[i][state][k] != Long.MIN_VALUE)
            return dp[i][state][k];

        long ans = NEG_INF;

        if (state == 0) {
            // do nothing
            ans = dfs(i + 1, 0, k);
            // open long
            ans = Math.max(ans, -prices[i] + dfs(i + 1, 1, k));
            // open short
            ans = Math.max(ans, prices[i] + dfs(i + 1, 2, k));
        }
        else if (state == 1) { // holding long
            // hold
            ans = dfs(i + 1, 1, k);
            // sell
            ans = Math.max(ans, prices[i] + dfs(i + 1, 0, k - 1));
        }
        else { // holding short
            // hold
            ans = dfs(i + 1, 2, k);
            // buy back
            ans = Math.max(ans, -prices[i] + dfs(i + 1, 0, k - 1));
        }

        return dp[i][state][k] = ans;
    }

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        this.n = prices.length;

        dp = new long[n][3][k + 1];
        for (int i = 0; i < n; i++)
            for (int s = 0; s < 3; s++)
                Arrays.fill(dp[i][s], Long.MIN_VALUE);

        return dfs(0, 0, k);
    }
}
