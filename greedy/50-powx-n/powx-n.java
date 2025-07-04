class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            x = 1/x;
            N = -1 * N;
        }
        return func(x,N);
    }
    public double func(double x, long n){
        if(n == 0) return 1.0;
        double half = func(x,n/2);
        if(n % 2 ==0){
            return half * half;
        }else{
            return half * half *  x;
        }
    }
}