class Solution {
    public void combination(int[] candidates,int target,int sum,List<Integer> temp,List<List<Integer>> ls,int p){
        if(sum == target) {
            ls.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target) return;
        for(int i = p; i < candidates.length;i++){
            temp.add(candidates[i]);
            combination(candidates,target,sum+candidates[i],temp,ls,i);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
         combination(candidates,target,0,temp,ls,0);
         return ls;

    }
}