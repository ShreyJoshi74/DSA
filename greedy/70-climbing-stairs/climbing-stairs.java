class Solution {
    public int func(int[] ways,int count){
        if(count == 0) return 1;
        if(count < 0) return 0;
        if(ways[count] != -1) return ways[count];
        int w1 = func(ways,count-1);
        
        int w2 = func(ways,count-2);
        
        return ways[count] = w1 + w2;
       

    }
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        Arrays.fill(ways,-1);

       
        return func(ways,n);
    }
}