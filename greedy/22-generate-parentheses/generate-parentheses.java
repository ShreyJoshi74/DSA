class Solution {
    public void generater(int n, List<String> ls,String p,int right,int left){
        if(right==0 && left == 0) ls.add(p);
        if(right > 0) generater(n,ls,p + "(",right-1,left+1);
        if(left > 0) generater(n,ls,p + ")",right,left-1);

    }
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        generater(n,ls,"",n,0);
        return ls;
    }
}