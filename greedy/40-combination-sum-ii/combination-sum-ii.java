class Solution {
    public void combi(int[] candidates, int target,int i,List<Integer> temp,List<List<Integer>> ls){
        if(target == 0) {
            ls.add(new ArrayList<>(temp));
            return;
        }
        if(target<0 ) return;
        
        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j-1]) continue;
            if(candidates[j] > target) break;
            temp.add(candidates[j]);
            combi(candidates,target-candidates[j],j+1,temp,ls);
            temp.remove(temp.size()-1);

        }


    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      List<List<Integer>> ls = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();
      combi(candidates,target , 0,temp,ls);
      return new ArrayList<>(ls);
        
    }
}