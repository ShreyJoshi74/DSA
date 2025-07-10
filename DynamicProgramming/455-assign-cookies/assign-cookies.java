class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length -1;
        int j = s.length - 1;
        int cnt = 0;
        while(i>=0 && j>=0){
            if(g[i] > s[j]){
                i--;
            }else{
                i--;
                j--;
                cnt++;
            }
        }
        return cnt;
    }
}