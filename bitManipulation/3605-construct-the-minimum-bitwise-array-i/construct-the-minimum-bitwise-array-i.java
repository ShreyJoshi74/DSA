class Solution {
    public int findMin(int num){
        for(int i = 0; i <= num; i++){
            int y = (i | (i + 1));
            if(y == num)
                return i;
        }
        return -1;
    }
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] output = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++)
            output[i] = findMin(nums.get(i));
            
        return output;
    }
}