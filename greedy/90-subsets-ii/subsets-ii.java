class Solution {
    public void combi(int[] nums,int i,List<Integer> temp,List<List<Integer>> ls){
        if(i == nums.length){
            if(!ls.contains(temp))ls.add(new ArrayList<>(temp));
            return;
        }
        combi(nums,i+1,temp,ls);
        temp.add(nums[i]);
        combi(nums,i+1,temp,ls);
        temp.remove(temp.size()-1);// backtracking
        return;

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combi(nums,0,temp,ls);
        return new ArrayList<>(ls);
    }
}