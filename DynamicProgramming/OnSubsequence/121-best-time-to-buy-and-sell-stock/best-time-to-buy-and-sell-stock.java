class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int bestPrice = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min,prices[i]);
            bestPrice = Math.max(bestPrice,prices[i] - min);
        }
        return bestPrice;

    }
}