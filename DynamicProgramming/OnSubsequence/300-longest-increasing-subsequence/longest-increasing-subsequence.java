class Solution {
    public int giveposi(ArrayList<Integer> ls,int number){
        int i = 0,j = ls.size();
        while(i < j){
           int  m = i + (j - i)/2;
            if(ls.get(m) < number){
                i = m + 1;
            }else{
                j = m;
            }
        }
        return i;
    }
    
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ls = new ArrayList<>();
        for(int k : nums){
            int p = giveposi(ls,k);
            if( p == ls.size()) ls.add(k);
            else{
                ls.set(p,k);
            }
        }
        return ls.size();
        
    }
}
