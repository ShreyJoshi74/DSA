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
        int prev2= 1;
        int prev1 = 2;
        if(n == 1) return prev2;
        if(n == 2) return prev1;
        int curr = 0;
        for(int i = 3 ; i <= n; i++){
            curr = prev1 + prev2;
            prev2= prev1;
            prev1 = curr;
        }
        return prev1;
    }
}