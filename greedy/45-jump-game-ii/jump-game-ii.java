class Solution {
    public int jump(int[] nums) {
        int k = nums.length;
        int[] dis = new int[nums.length];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums[i]; j++){
                if(j+ i < k && 1 + dis[i] < dis[j + i]) dis[j + i] = dis[i] + 1;
            }
        }
        return dis[nums.length-1] != Integer.MAX_VALUE ?  dis[nums.length-1] : -1;
    }
}