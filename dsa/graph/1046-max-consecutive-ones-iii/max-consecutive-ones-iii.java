class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int maxCount = 0;
        int numZero = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                queue.add(1);
                count++;
                maxCount = Math.max(maxCount,count);
            }else{
                if(numZero == k){
                    queue.add(0);
                    while(queue.peek() != 0){
                        queue.poll();
                        count--;
                    }
                    queue.poll();
                }else{
                    queue.add(0);
                    numZero++;
                    count++;
                    maxCount = Math.max(maxCount,count);
                }
            }
        }
        return maxCount;
    }
}