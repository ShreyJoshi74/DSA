class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE,profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min) min = prices[i];
            else if(i == prices.length - 1|| prices[i + 1] < prices[i] ){
                profit += prices[i] - min;
                min = Integer.MAX_VALUE;
            }
        }
        return profit;
    }
}