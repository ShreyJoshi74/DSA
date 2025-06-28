class Solution {
    // public int func(int[] ways,int count){
    //     if(count == 0) return 1;
    //     if(count < 0) return 0;
    //     if(ways[count] != -1) return ways[count];
    //     int w1 = func(ways,count-1);
        
    //     int w2 = func(ways,count-2);
        
    //     return ways[count] = w1 + w2;
       

    // }
    // public int climbStairs(int n) {
    //     int[] ways = new int[n + 1];
    //     Arrays.fill(ways,-1);

       
    //     return func(ways,n);
    // }
    // TRYING WITH TABULAR FORMAT
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        dp[0]= -1;
        dp[1] = 1;
        if(n > 1) dp[2] =  2;
        if(n <= 2) return dp[n];
        for(int i = 3 ; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}