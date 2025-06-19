class Solution {
    public void combi(int k, int target,int i,List<List<Integer>> ls,List<Integer> temp){
        if(target == 0 && k == 0) {
            ls.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || k == 0 || i == 10) return;
        combi(k,target,i+1,ls,temp);
        temp.add(i);
        combi(k-1,target - i,i+1,ls,temp);
        temp.remove(temp.size() - 1);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combi(k,n,1,ls,temp);
        return ls;
    }
}