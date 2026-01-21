class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] output = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++){
            int num = nums.get(i);
            if(num == 2){
                output[i] = -1;
                continue;
            }
            int res = -1;
            int factor = 1;
            while((num & factor) != 0){
                res = num - factor;
                factor = factor << 1;
            }
            output[i] = res;

        }
        return output;
    }
}
// int x = nums.get(i);
//             int res = -1;
//             int d = 1;
//             while ((x & d) != 0) {
//                 res = x - d;
//                 d <<= 1;
//             }
//             result[i] = res;