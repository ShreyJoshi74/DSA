import java.util.*;

public class Solution {
    public static int findWays(int num[], int tar) {
        long[] dp = new long[tar + 1];
        dp[0] = 1;
        int MOD =(int)1e9 + 7;
        int zero = 0;

        for (int nums : num) {
            if (nums == 0) {
                zero++;
                continue;
            }
            for (int goal = tar; goal >= nums; goal--) {
                dp[goal] += dp[goal - nums];
            }
        }

        return (int)((dp[tar] * (1L << zero)) % MOD);  // Safer than Math.pow
    }
}
