class Solution {
    public int gcd(int a,int b){
        if(a < b) return gcd(b,a);
        if(a % b == 0) return b;
        return gcd(b,a%b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> output = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(gcd(i,j) == 1 )
                    output.add(j + "/" + i);
            }
        }
        return output;
    }
}