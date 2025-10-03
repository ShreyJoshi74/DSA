class Solution {
    public int minBitFlips(int start, int goal) {
        int n = start ^ goal;
        int cnt = 0;
        while(n > 1){
            if(n % 2 == 1) cnt++;
            n = n / 2;

        }
        if(n == 1) cnt++;
        return cnt;
    }
}