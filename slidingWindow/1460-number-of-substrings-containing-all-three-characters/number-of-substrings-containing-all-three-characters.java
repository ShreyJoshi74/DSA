// The Potli Approach
// a , b , c ko imagine kro ek potli me bandh liya aur min index a,b,c ki nikalo
// phir count update kro "min index + 1"
class Solution {
   public int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
}

    public int numberOfSubstrings(String s) {
        int a = -1,b = -1,c = -1;
        int r  = 0;
        int t;
        int cnt = 0;
        while(r < s.length()){
            if(s.charAt(r) == 'a') a = r;
            if(s.charAt(r) == 'b') b = r;
            if(s.charAt(r) == 'c') c = r;
            t = min(a,b,c);
            if(a != -1 && b != -1 && c != -1){
                cnt += t + 1;
            }
            r++;
        }
        return cnt;
    }
}