class Solution {
    static final long MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        long ways = 1;
        int seatCount = 0;
        int plantsBetweenSeats = 0;

        boolean insidePair = false;

        for (char c : corridor.toCharArray()) {

            if (c == 'S') {
                seatCount++;

                // After completing a pair
                if (seatCount == 2) {
                    insidePair = true;
                }
                // At the start of a new pair
                else if (seatCount == 3) {
                    // plantsBetweenSeats + 1 = number of valid ways to place divider
                    ways = (ways * (plantsBetweenSeats + 1)) % MOD;

                    // Reset for next pair
                    seatCount = 1;
                    plantsBetweenSeats = 0;
                }
            }
            else if (c == 'P') {
                // Only count plants AFTER completing one pair and BEFORE reaching the next seat
                if (insidePair && seatCount == 2) {
                    plantsBetweenSeats++;
                }
            }
        }

        // If total seats is not even or less than 2 → no valid way
        return seatCount < 2 ? 0 : (int) ways;
    }
}
