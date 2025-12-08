class Solution {
    public boolean isSquare(int n){
        if(n == 1) return true;
        int i = 1;
        int j = n/2;
        while(i <= j){
            int mid = (i + j) >> 1;
            int square = mid * mid;
            if(square == n) return true;
            else if(square > n) j = mid - 1;
            else i = mid + 1;
        
        }
        return false;
    }
    public int countTriples(int n) {
        int count = 0;
        for(int i = 1; i <= n ; i++){
            for(int j = i; j <= n; j++ ){
                if(i * i + j * j <= n * n && isSquare(i * i + j * j)){
                    if(i == j) {
                        System.out.println("1 : " + i + " " + j);
                        count += 1;
                    }
                    else {
                        System.out.println("2 : " + i + " " + j);
                        count += 2;
                    }
                }
            }
        }
        return count;
    }
}