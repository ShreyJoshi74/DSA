class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void bitToList(int bit,int[] nums){
        int i = nums.length - 1;
        List<Integer> ls = new ArrayList<>();
        while(i >= 0){
            if((bit & 1) == 1) ls.add(nums[i]);
            bit = bit>>1;
            i--;
        }
        result.add(ls);
    }
    public void f(int i,int bit,int[] nums){// i want the number that tells me which subset to form
        if(i == nums.length){
            bitToList(bit>>1,nums);
            return;
        }
        // not taken
        f(i+1,bit<<1,nums);
        bit = bit | 1;
        f(i+1,bit<<1,nums);
        return;
    }   
    public List<List<Integer>> subsets(int[] nums) {
        f(0 , 0 , nums);
        return result;

    }
}