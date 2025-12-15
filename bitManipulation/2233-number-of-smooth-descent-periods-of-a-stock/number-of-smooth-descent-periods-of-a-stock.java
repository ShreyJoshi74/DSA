class Solution {
    public long getDescentPeriods(int[] prices) {
        long seq = 1;
        long cnt = 0;
        int prev = -1;
        for(int i = 0; i < prices.length; i++){
            if(prev - prices[i] == 1) seq+=1;
            else seq = 1;

            cnt += seq;
            prev = prices[i];

        }
        return cnt;
    }
}