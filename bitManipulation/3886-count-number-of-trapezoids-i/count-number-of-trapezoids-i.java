class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;
        final long INV_TWO = 500000004;
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }
        ArrayList<Long>ls = new ArrayList<>();
        for (int count : map.values()) {
            if (count >= 2) {
                ls.add(1L * count * (count - 1) / 2);
            }
        }
        int n = ls.size();
        if(n <= 1) return 0;
        long cnt = 0;
        long totalSum = 0;
    long sumSquares = 0;

    for (long val : ls) {
        totalSum = (totalSum + val) % MOD;
        sumSquares = (sumSquares + val * val % MOD) % MOD;
    }

    long total = (totalSum * totalSum % MOD - sumSquares + MOD) % MOD;
    total = (total * INV_TWO) % MOD;  // Divide by 2 under modulo

    return (int) total;

        
    }
}