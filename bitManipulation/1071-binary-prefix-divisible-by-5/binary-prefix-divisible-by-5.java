class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        long rem = 0;

        List<Boolean> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            rem = rem * 2 + nums[i];

            

            if(rem%5 == 0) {
                output.add(true);
                
            }
            else output.add(false);

            rem = rem % 5;
        }

        return output;
    }
}