class Solution {
    public void generator(List<Integer> temp , int[] nums,int i,List<List<Integer>> ls){
        if(i == nums.length ) {
            
            ls.add(new ArrayList<>(temp));
            return;
        }
        generator(temp,nums,i+1,ls);
        temp.add(nums[i]);  
        generator(temp,nums,i+1,ls);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generator(temp,nums,0,ls);
        return ls;
    }
}